package com.tw.pathashala.models;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> books = new ArrayList<Book>();

    public Books(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String booksDetails = "";
        for (Book book : books) {
            if (!book.isPublicationYearInFuture()) {
                booksDetails = booksDetails.concat(book.toString() + "\n");
            }
        }
        return booksDetails;
    }
}
