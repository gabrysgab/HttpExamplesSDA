package oo.max.httpexamples;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import oo.max.httpexamples.Model.Book;
import oo.max.httpexamples.Model.BookResponse;

public class ServerApiClient {

    private final Gson gson;

    public ServerApiClient() {

        this.gson = new Gson();


    }

    public List<Book> callServerApi() throws IOException {
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try {
            URL url = new URL("http://91.134.143.223:9000/asset/test.json?X-BAASBOX-APPCODE=1234567890");
            httpURLConnection = (HttpURLConnection) url.openConnection();

            inputStream = httpURLConnection.getInputStream();

            String responseBody = IOUtils.toString(inputStream);

            BookResponse bookResponse = gson.fromJson(responseBody, BookResponse.class);

            return bookResponse.getData();

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

    }

}
