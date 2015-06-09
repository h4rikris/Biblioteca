package com.tw.pathashala.menu;

import com.tw.pathashala.models.Books;

public class BooksList implements MenuAction {

    private Books books;

    public BooksList(Books books) {
        this.books = books;
    }

    @Override
    public String display() {
        return books.toString();
    }

}
