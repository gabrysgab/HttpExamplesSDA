package oo.max.httpexamples.Model;

import java.util.List;

public class BookResponse {
    private final String result;
    private final List<Book> data;
    private final int http_code;

    public BookResponse(String result, List<Book> data, int http_code) {
        this.result = result;
        this.data = data;
        this.http_code = http_code;
    }

    public String getResult() {
        return result;
    }

    public List<Book> getData() {
        return data;
    }

    public int getHttp_code() {
        return http_code;
    }
}