package oo.max.httpexamples.retrofit;


import oo.max.httpexamples.Model.BookResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by RENT on 2016-12-13.
 */

public interface RetrofitApiClient {

    @GET("/plugin/test.getTestCollection")
    @Headers("X-BAASBOX-APPCODE: 1234567890")
    Call<BookResponse> getBooks();




}
