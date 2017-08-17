package net.december1900.rxjava2samples_android.ui.operators;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import net.december1900.rxjava2samples_android.R;
import net.december1900.rxjava2samples_android.model.Product;
import net.december1900.rxjava2samples_android.net.RetrofitWork;
import net.december1900.rxjava2samples_android.util.PreferenceUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by december on 2017/8/16.
 */

public class RxConcatActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, RxConcatActivity.class);
        context.startActivity(starter);
    }

    private static final String TAG = "RxConcatActivity";

    private TextView tv;
    private Button btn;

    private PreferenceUtil sp;

    private boolean isLoad;

    private Product mProduct;
    private String mProductJson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samples);

        sp = new PreferenceUtil();
        tv = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomething();
            }
        });
    }

    private void doSomething() {

        Observable<Product> getCache = Observable.create(new ObservableOnSubscribe<Product>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Product> e) throws Exception {

                Product data = new Gson().fromJson(mProductJson, Product.class);

                if (data != null) {
                    isLoad = false;
                    Log.d(TAG, "get data from local\n");
                    e.onNext(data);
                } else {
                    isLoad = true;
                    Log.d(TAG, "request server to load data\n");
                    e.onComplete();
                }
            }
        });

        Observable.concat(getCache, RetrofitWork.getApi().getProduct())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Product>() {
                    @Override
                    public void accept(Product product) throws Exception {
                        if (isLoad) {
                            mProduct = product;
                            Gson gson = new Gson();
                            mProductJson = gson.toJson(mProduct);
                            sp.saveString(PreferenceUtil.PRODUCT_INFO, mProductJson);
                            Log.d(TAG, "accept : success : load data");
                        } else {
                            tv.setText(mProduct._product.get(0).getName());
                            Log.d(TAG, "accept : success : get cache");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "onError : " + throwable.getMessage());
                    }
                });
    }
}

