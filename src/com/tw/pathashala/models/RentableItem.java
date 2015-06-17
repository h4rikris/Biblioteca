package com.tw.pathashala.models;

import java.util.ArrayList;
import java.util.Calendar;

import static com.tw.pathashala.constants.Constants.BOOK_FORMAT;

public abstract class RentableItem {
    private String name;
    private String author;
    private Integer year;

    public RentableItem(String name, String author, Integer year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format(BOOK_FORMAT, name, author, year);
    }

    public boolean isYearInFuture() {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        return year < this.year;
    }

    public abstract RentableItem checkOut();

    public abstract RentableItem returnItem();

    public void addToListIfTitleMatches(ArrayList<RentableItem> rentableItems, String searchName) {
        if (searchName.equals(this.name)) {
            rentableItems.add(this);
        }
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
