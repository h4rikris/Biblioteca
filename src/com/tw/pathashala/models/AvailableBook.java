package com.tw.pathashala.models;

import static com.tw.pathashala.constants.Constants.BOOK_CHECKOUT_INVALID_MESSAGE;
import static com.tw.pathashala.constants.Constants.BOOK_CHECKOUT_SUCCESS_MESSAGE;

public class AvailableBook extends RentableItem {

    private final Integer yearOfPublication;
    private final String author;
    private final String name;

    public AvailableBook(String name, String author, Integer yearOfPublication) {
        super(name, author, yearOfPublication);
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public RentableItem checkOut() {
        return new CheckedOutBook(name, author, yearOfPublication);
    }

    @Override
    public RentableItem returnItem() {
        return null;
    }

    @Override
    public String getSuccessMessage() {
        return BOOK_CHECKOUT_SUCCESS_MESSAGE;
    }

    @Override
    public String getFailMessage() {
        return BOOK_CHECKOUT_INVALID_MESSAGE;
    }
}
