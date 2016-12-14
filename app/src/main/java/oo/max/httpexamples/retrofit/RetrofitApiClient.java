package oo.max.httpexamples.retrofit;


import okhttp3.ResponseBody;
import oo.max.httpexamples.Model.Book;
import oo.max.httpexamples.Model.BookResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by RENT on 2016-12-13.
 */

public interface RetrofitApiClient {

    @GET("/plugin/test.getTestCollection")
    @Headers("X-BAASBOX-APPCODE: 1234567890")
    Call<BookResponse> getBooks();

    @POST("/plugin/test.createTestEntry")
    @Headers({"X-BAASBOX-APPCODE: 1234567890",
            "Content-type: application/json"})
    Call<ResponseBody> createBook(
            @Body Book book
    );




}
