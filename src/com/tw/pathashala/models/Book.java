package com.tw.pathashala.models;

import java.util.Calendar;

public class Book {
    private String name;
    private String author;
    private Integer yearOfPublication;
    private boolean checkedOut;

    public Book(String name, String author, Integer yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.checkedOut = false;
    }

    @Override
    public String toString() {
        return String.format("| %-41s | %-41s | %-8s |", name, author, yearOfPublication);
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
            checkedOut = true;
            return true;
        }
        else{
            return false;
        }
    }
}
