package oo.max.httpexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import oo.max.httpexamples.Model.Book;

public class MainActivity extends AppCompatActivity implements GetBooksAsyncTask.BooksDownloadedListener, CreateBookAsyncTask.BookCreateListener {

    public static final int ID = 3487;
    private Button refreshButton;
    private Button addButton;
    private EditText addEditText;
    private ListView listView;

    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshButton = (Button) findViewById(R.id.refreshButton);
        addButton = (Button) findViewById(R.id.addButton);
        addEditText = (EditText) findViewById(R.id.addEditText);
        listView = (ListView) findViewById(R.id.listView);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshBooks();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addNewBook();
            }
        });
    }

    private void refreshBooks() {
        new GetBooksAsyncTask(this).execute();
    }

    @Override
    public void onBooksDownloaded(List<Book> books) {
        if (books == null) {
            Toast.makeText(this, "Failed to download", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, books);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBookCreate(boolean isSuccessful) {

        if(isSuccessful) {
            Toast.makeText(this, "Book added!", Toast.LENGTH_SHORT).show();
            addEditText.setText("");
            return;
        }
        Toast.makeText(this, "Adding book failed!", Toast.LENGTH_SHORT).show();
    }

    private void addNewBook() {
        String newBookName = addEditText.getText().toString();
        if (newBookName == null || newBookName.isEmpty()) {

            Toast.makeText(this, "Invalid name!", Toast.LENGTH_SHORT).show();
            return;
        }
        Book newBook = new Book(newBookName);
        new CreateBookAsyncTask(this).execute(newBook);
    }


}

