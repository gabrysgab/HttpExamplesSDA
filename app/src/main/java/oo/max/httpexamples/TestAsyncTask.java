package oo.max.httpexamples;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.List;

import oo.max.httpexamples.Model.Book;

public class TestAsyncTask extends AsyncTask<Integer, Integer, List<Book>> {

    private final TextView textView;
    private final ServerApiClient serverApiClient;

    public TestAsyncTask(TextView textView) {
        this.textView = textView;
        serverApiClient = new ServerApiClient();
    }

    @Override
    protected void onPreExecute() {
        textView.setText("Start");
    }

    @Override
    protected List<Book> doInBackground(Integer... integers) {
        try {
            return serverApiClient.callServerApi();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Book> books) {
        if (books == null) {
            textView.setText("FAILED");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.getName())
                    .append(System.lineSeparator());
            String result = stringBuilder.toString();
            textView.setText(result);
        }
    }
}
