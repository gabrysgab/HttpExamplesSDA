package oo.max.httpexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import oo.max.httpexamples.Model.Book;

public class MainActivity extends AppCompatActivity implements GetBooksAsyncTask.BooksDownloadedListener {

    public static final int ID = 3487;
    private TextView textView;
    private Button refreshButton;

    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        refreshButton = (Button) findViewById(R.id.refreshButton);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshBooks();
            }
        });


    }

    private void refreshBooks() {
        new GetBooksAsyncTask(this).execute();
    }

    @Override
    public void onBooksDownloaded(List<Book> books) {
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

