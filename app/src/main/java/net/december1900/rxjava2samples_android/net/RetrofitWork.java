package net.december1900.rxjava2samples_android.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by december on 2017/8/16.
 */

public class RetrofitWork {

    private static RetrofitService mApi;

    public static RetrofitService getApi() {
        OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://ccnubox.muxixyz.com/api/")
                .build();
        mApi = retrofit.create(RetrofitService.class);
        return mApi;
    }

}
