package com.tw.pathashala.models;

import static com.tw.pathashala.constants.Constants.BOOK_RETURN_FAIL_MESSAGE;
import static com.tw.pathashala.constants.Constants.BOOK_RETURN_SUCCESS_MESSAGE;

public class CheckedOutBook extends RentableItem {

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
    public RentableItem checkOut() {
        return null;
    }

    @Override
    public RentableItem returnItem() {
        return new AvailableBook(name, author, yearOfPublication);
    }

    @Override
    public String getSuccessMessage() {
        return BOOK_RETURN_SUCCESS_MESSAGE;
    }

    @Override
    public String getFailMessage() {
        return BOOK_RETURN_FAIL_MESSAGE;
    }
}
