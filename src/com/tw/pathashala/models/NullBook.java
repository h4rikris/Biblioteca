package com.tw.pathashala.models;

public class NullBook extends Book{

    public NullBook() {
        super("", "", 0);
    }

    @Override
    public Book checkOut() {
        return null;
    }

    @Override
    public Book returnBook() {
        return null;
    }

    @Override
    public Boolean isNull() {
        return true;
    }
}
