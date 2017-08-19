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

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import static android.R.attr.value;

/**
 * Created by december on 2017/8/19.
 */

public class RxFlowableActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, RxFlowableActivity.class);
        context.startActivity(starter);
    }

    private static final String TAG = "RxFlowableActivity";

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

        Flowable.just(1, 2, 3, 4)
                .reduce(50, new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                tv.append(" accept : value : " + value);
                Log.d(TAG, " accept : value : " + value);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                tv.append(" onError : " + throwable.getMessage());
                Log.d(TAG, " onError : " + throwable.getMessage());
            }
        });
    }
}
