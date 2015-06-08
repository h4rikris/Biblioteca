package com.tw.pathashala.menu;

import com.tw.pathashala.models.Books;

public class BooksList implements MenuAction {

    @Override
    public String display() {
        return new Books().toString();
    }

    @Override
    public String toString() {
        return "BooksList{}";
    }
}
