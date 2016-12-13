package oo.max.httpexamples;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import oo.max.httpexamples.Model.Book;
import oo.max.httpexamples.retrofit.BookService;

/**
 * Created by RENT on 2016-12-13.
 */

public class GetBooksAsyncTask extends AsyncTask<Void, Void, List<Book>> {

    private final BookService retrofitApiWrapper;
    private final BooksDownloadedListener booksDownloadedListener;

    public GetBooksAsyncTask(BooksDownloadedListener booksDownloadedListener) {
        this.booksDownloadedListener = booksDownloadedListener;
        this.retrofitApiWrapper = new BookService();
    }

    @Override
    protected List<Book> doInBackground(Void... params) {

        try {
            return retrofitApiWrapper.getBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(List<Book> books) {
        booksDownloadedListener.onBooksDownloaded(books);
    }



    public interface  BooksDownloadedListener {
        void onBooksDownloaded(List<Book> books);
    }
}
