package net.december1900.rxjava2samples_android.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import net.december1900.rxjava2samples_android.MyApplication;

/**
 * Created by december on 2017/8/16.
 */

public class PreferenceUtil{

    public static final String PRODUCT_INFO = "product_data";

    public static String getString(String key){
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.sContext).getString(key,"");
    }

    public static String getString(String key, String def){
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.sContext).getString(key,def);
    }

    public static void saveString(String key, String value){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MyApplication.sContext).edit();
        editor.putString(key, value);
        editor.apply();
    }
}
