package com.tw.pathashala.models;

import com.tw.pathashala.constants.Constants;

import static com.tw.pathashala.constants.Constants.FAILED;

public class NullBook extends Book{

    public NullBook() {
        super("", "", 0);
    }

    @Override
    public boolean checkOut() {
        return FAILED;
    }

    @Override
    public boolean returnBook() {
        return FAILED;
    }
}
