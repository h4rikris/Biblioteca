package com.tw.pathashala.models;

public class CheckedOutBook extends Book{

    private final String name;
    private final String author;
    private final Integer yearOfPublication;

    public CheckedOutBook(String name, String author, Integer yearOfPublication) {
        super(name, author, yearOfPublication);
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public Book checkOut() {
        return null;
    }

    @Override
    public Book returnBook() {
        return new AvailableBook(name, author, yearOfPublication);
    }
}
