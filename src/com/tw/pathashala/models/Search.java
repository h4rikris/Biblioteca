package com.tw.pathashala.models;

import java.util.ArrayList;

public class Search {
    public ArrayList<Book> search(ArrayList<Book> bookDetails, String searchString) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book book : bookDetails) {
            if (book.isYourName(searchString)) {
                books.add(book);
            }
        }
        return books;
    }
}
