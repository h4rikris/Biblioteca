package com.tw.pathashala.com.tw.pathashala.menu;

import com.tw.pathashala.models.Books;

public class DisplayBookList implements MenuAction{
    @Override
    public String display(Books books) {
        return books.toString();
    }
}
