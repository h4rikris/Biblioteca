package com.tw.pathashala.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvailableBookTest {

    @Test
    public void testForBookReturningBookDetails() {
        RentableItem book = new AvailableBook("Java", "Hari", 2015);

        String bookDetails = book.toString();
        String expectedBookDetails = "| Java                                      | Hari                                      | 2015     |";

        assertEquals(expectedBookDetails, bookDetails);
    }

    @Test
    public void testForBookDetailsConsistsAuthor() {
        RentableItem book = new AvailableBook("Java", "Hari", 2015);

        String bookDetails = book.toString();
        String author = "Hari";

        assertTrue(bookDetails.contains(author));
    }

    @Test
    public void testForBookDetailsConsistsBookName() {
        RentableItem book = new AvailableBook("Java", "Hari", 2015);

        String bookDetails = book.toString();
        String bookName = "Java";

        assertTrue(bookDetails.contains(bookName));
    }

    @Test
    public void testForBookDetailsConsistsDateOfPublication() {
        RentableItem book = new AvailableBook("Java", "Hari", 2015);

        String bookDetails = book.toString();
        Integer dateOfPublication = 2015;

        assertTrue(bookDetails.contains(dateOfPublication.toString()));
    }

    @Test
    public void testForBookDetailsNotHavingFutureDateOfPublication() {
        RentableItem book = new AvailableBook("Java", "Hari", 2015);

        boolean bookYearInFuture = book.isYearInFuture();
        boolean expectedResult = false;

        assertEquals(expectedResult, bookYearInFuture);
    }

    @Test
    public void testForBookDetailsHavingFutureDateOfPublication() {
        RentableItem book = new AvailableBook("Java", "Hari", 2016);

        boolean bookYearInFuture = book.isYearInFuture();
        boolean expectedResult = true;

        assertEquals(expectedResult, bookYearInFuture);
    }

    @Test
    public void testForBookCheckOutReturnCheckedOutBookAfterCheckedOut() {
        RentableItem book = new AvailableBook("Java", "Hari", 2016);

        RentableItem checkoutBook = book.checkOut();
        String expected = checkoutBook.getClass().getName();

        assertEquals("com.tw.pathashala.models.CheckedOutBook", expected);
    }

}