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
import net.december1900.rxjava2samples_android.model.Money;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by december on 2017/8/16.
 */

public class RxMapActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, RxMapActivity.class);
        context.startActivity(starter);
    }

    private static final String TAG = "RxMapActivity";

    private TextView tv;
    private Button btn;

    private List<Money> money = new ArrayList<>();
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samples);

        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.text);

        money.add(new Money("112¥","122$","111€"));
        money.add(new Money("123¥","133$","134€"));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomething();
            }
        });
    }

    private void doSomething(){
        Observable.fromIterable(money)
                .map(new Function<Money, String>() {
                    @Override
                    public String apply(@NonNull Money money) throws Exception {
                        return money.getRMB();
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv.append("We have " + s + "\n");
                Log.d(TAG, "money : " + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d(TAG, "onError " + throwable.getMessage());
            }
        });

    }
}
