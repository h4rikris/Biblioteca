package com.tw.pathashala.models;

import java.util.Calendar;

import static com.tw.pathashala.constants.Constants.FORMAT;

public abstract class RentableItem {
    private String name;
    private String author;
    private Integer yearOfPublication;

    public RentableItem(String name, String author, Integer yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, name, author, yearOfPublication);
    }

    public boolean isPublicationYearInFuture() {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        return year < yearOfPublication;
    }

    public abstract RentableItem checkOut();

    public abstract RentableItem returnItem();

    public boolean isYourName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentableItem book = (RentableItem) o;

        return !(name != null ? !name.equals(book.name) : book.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
