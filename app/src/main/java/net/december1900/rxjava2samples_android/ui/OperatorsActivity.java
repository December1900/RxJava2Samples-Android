package net.december1900.rxjava2samples_android.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.december1900.rxjava2samples_android.MyApplication;
import net.december1900.rxjava2samples_android.R;
import net.december1900.rxjava2samples_android.ui.operators.RxConcatActivity;
import net.december1900.rxjava2samples_android.ui.operators.RxDisposableActivity;
import net.december1900.rxjava2samples_android.ui.operators.RxMapActivity;

public class OperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
    }

    public void startDisposableActivity(View view){
        RxDisposableActivity.start(MyApplication.sContext);
    }

    public void startMapActivity(View view){
        RxMapActivity.start(MyApplication.sContext);
    }

    public void startConcatActivity(View view){
        RxConcatActivity.start(MyApplication.sContext);
    }

}
