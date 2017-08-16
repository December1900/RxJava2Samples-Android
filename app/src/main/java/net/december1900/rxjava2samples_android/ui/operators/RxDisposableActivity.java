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

import net.december1900.rxjava2samples_android.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by december on 2017/8/16.
 */

public class RxDisposableActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, RxDisposableActivity.class);
        context.startActivity(starter);
    }

    private static final String TAG = "RxDisposableActivity";

    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samples);

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
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.d(TAG, "Observable emit value 1\n");
                e.onNext(1);
                Log.d(TAG, "Observable emit value 2\n");
                e.onNext(2);
                Log.d(TAG, "Observable emit value 3\n");
                e.onNext(3);
                e.onComplete();
                Log.d(TAG, "Observable emit value 4\n");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {
            int i;
            Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                i++;
                if (i == 2) {
                    mDisposable.dispose();
                }
                tv.append("onNext : value : " + i + "\n");
                Log.d(TAG, "onNext : value : " + i + "\n");
                Log.d(TAG, "onNext : disposable :" + mDisposable.isDisposed() + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError : value : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete ");
            }
        });
    }

}
