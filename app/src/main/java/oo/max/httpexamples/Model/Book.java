package oo.max.httpexamples.Model;

public class Book {
    private final String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }
}
