package oo.max.httpexamples;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import oo.max.httpexamples.Model.Book;
import oo.max.httpexamples.retrofit.BookService;

/**
 * Created by RENT on 2016-12-14.
 */

public class CreateBookAsyncTask extends AsyncTask<Book, Void, Boolean> {

    private final BookService bookService;
    private final BookCreateListener bookCreateListener;


    public CreateBookAsyncTask(BookCreateListener bookCreateListener) {
        bookService = new BookService();
        this.bookCreateListener = bookCreateListener;


    }


    @Override
    protected Boolean doInBackground(Book... books) {


        try {
            bookService.createBook(books[0]);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("CATASTROPHY", "I got an error", e);
            return false;
        }



    }

    @Override
    protected void onPostExecute(Boolean isSuccessful) {
        bookCreateListener.onBookCreate(isSuccessful);
    }

    public interface BookCreateListener {

        void onBookCreate(boolean isSuccessful);


    }
}
