package oo.max.httpexamples.retrofit;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import oo.max.httpexamples.Model.Book;
import oo.max.httpexamples.Model.BookResponse;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by RENT on 2016-12-13.
 */

public class BookService {
    
    private final RetrofitApiClient retrofitApiClient;

    public BookService() {
        ApiClientFactory apiClientFactory = new ApiClientFactory();
        this.retrofitApiClient = apiClientFactory.createApiClient();
        
    }
    
    public List<Book> getBooks() throws IOException {
        
        Call<BookResponse> call =  retrofitApiClient.getBooks();
        Response<BookResponse> response = call.execute();
        BookResponse bookResponse = response.body();
        return bookResponse.getData();

    }

    public void createBook(Book book) throws IOException {
        Call<ResponseBody> call = retrofitApiClient.createBook(book);
        Response<ResponseBody> response = call.execute();
        if(!response.isSuccessful()) {
            throw new RuntimeException("Failed!");
        }

    }

}
