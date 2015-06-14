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
            return CHECKEDOUT;
        }
        else{
            return CHECKEDIN;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return !(name != null ? !name.equals(book.name) : book.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
