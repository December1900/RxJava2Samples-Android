package net.december1900.rxjava2samples_android;

import android.app.Application;
import android.content.Context;

/**
 * Created by december on 2017/8/16.
 */

public class MyApplication extends Application{

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();
    }
}
