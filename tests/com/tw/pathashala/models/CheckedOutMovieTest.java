package com.tw.pathashala.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckedOutMovieTest {
    @Test
    public void shouldContainsRatingInDisplay() {
        RentableItem movie = new CheckedOutMovie("Inception", "Hari", 2015, 9);

        String movieDetails = movie.toString();
        Integer rating = 9;

        assertTrue(movieDetails.contains(rating.toString()));
    }

    @Test
    public void shouldContainsDirectorNameInDisplay() {
        RentableItem movie = new CheckedOutMovie("Inception", "Hari", 2015, 9);

        String movieDetails = movie.toString();
        String directorName = "Hari";

        assertTrue(movieDetails.contains(directorName));
    }

    @Test
    public void shouldContainsMovieNameInDisplay() {
        RentableItem movie = new CheckedOutMovie("Inception", "Hari", 2015, 9);

        String movieDetails = movie.toString();
        String movieName = "Inception";

        assertTrue(movieDetails.contains(movieName));
    }

    @Test
    public void shouldContainsReleaseYearInDisplay() {
        RentableItem movie = new CheckedOutMovie("Inception", "Hari", 2015, 9);

        String movieDetails = movie.toString();
        Integer year = 2015;

        assertTrue(movieDetails.contains(year.toString()));
    }

    @Test
    public void shouldReturnAvailableBookOnReturningTheBook() {
        RentableItem movie = new CheckedOutMovie("Inception", "Hari", 2015, 9);

        RentableItem availableMovie = movie.returnItem();

        assertEquals("com.tw.pathashala.models.AvailableMovie", availableMovie.getClass().getName());
    }

    @Test
    public void shouldReturnNullOnCheckingOutTheBook() {
        RentableItem movie = new CheckedOutMovie("Inception", "Hari", 2015, 9);

        RentableItem availableMovie = movie.checkOut();

        assertNull(availableMovie);
    }
}