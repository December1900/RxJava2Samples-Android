package net.december1900.rxjava2samples_android.net;

import net.december1900.rxjava2samples_android.model.Product;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by december on 2017/8/16.
 */

public interface RetrofitService {

    @GET("product/")
    Observable<Product> getProduct();
}
