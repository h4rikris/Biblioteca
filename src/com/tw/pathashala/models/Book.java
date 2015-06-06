package com.tw.pathashala.models;

public class Book {
    private String name;
    private String author;
    private String dateOfPublication;

    public Book(String name, String author, String dateOfPublication) {
        this.name = name;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public String toString() {
        return name + ' ' + author + ' ' + dateOfPublication;
    }
}
