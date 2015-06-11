package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;

public class BooksList implements MenuAction {

    private Library library;

    public BooksList(Library library) {
        this.library = library;
    }

    @Override
    public String display() {
        return library.toString();
    }

}
