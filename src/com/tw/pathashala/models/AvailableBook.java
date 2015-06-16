package com.tw.pathashala.models;

public class AvailableBook extends Book{

    private final Integer yearOfPublication;
    private final String author;
    private final String name;

    public AvailableBook(String name, String author, Integer yearOfPublication) {
        super(name, author, yearOfPublication);
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public Book checkOut() {
        return new CheckedOutBook(name, author, yearOfPublication);
    }

    @Override
    public Book returnBook() {
        return new NullBook();
    }
}
