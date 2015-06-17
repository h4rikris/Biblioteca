package com.tw.pathashala.models;

import static com.tw.pathashala.constants.Constants.MOVIE_FORMAT;

public class AvailableMovie extends RentableItem {
    private Integer rating;
    private String name;
    private String director;
    private Integer year;

    public AvailableMovie(String name, String director, Integer yearOfPublication, Integer rating) {
        super(name, director, yearOfPublication);
        this.name = name;
        this.director = director;
        this.year = yearOfPublication;
        this.rating = rating;
    }

    @Override
    public RentableItem checkOut() {
        return new CheckedOutMovie(name, director, year, rating);
    }

    @Override
    public RentableItem returnItem() {
        return null;
    }

    @Override
    public String toString() {
        return String.format(MOVIE_FORMAT, name, director, year, rating);
    }
}
