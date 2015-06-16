package com.tw.pathashala.models;

import java.util.Calendar;

import static com.tw.pathashala.constants.Constants.*;

public class Book {
    private String name;
    private String author;
    private Integer yearOfPublication;
    private boolean checkedOut;

    public Book(String name, String author, Integer yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.checkedOut = CHECKEDIN;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, name, author, yearOfPublication);
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public boolean isPublicationYearInFuture() {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        return year < yearOfPublication;
    }

    public boolean checkOut() {
        if (!checkedOut) {
            checkedOut = CHECKEDOUT;
            return SUCCESS;
        } else {
            return FAILED;
        }

    }

    public boolean returnBook() {
        if (checkedOut) {
            checkedOut = CHECKEDIN;
            return SUCCESS;
        } else {
            return FAILED;
        }
    }

    public boolean isYourName(String name) {
        return this.name.equals(name);
    }
}
