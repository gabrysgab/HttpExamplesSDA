package oo.max.httpexamples.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RENT on 2016-12-13.
 */

public class ApiClientFactory {

    public RetrofitApiClient createApiClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://91.134.143.223:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       return retrofit.create(RetrofitApiClient.class);
    }
}
