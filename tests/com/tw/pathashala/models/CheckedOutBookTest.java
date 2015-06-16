package com.tw.pathashala.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckedOutBookTest {


    @Test
    public void testForBookCheckOutToConvertAvailableBookAfterReturn() {
        RentableItem book = new CheckedOutBook("Java", "Hari", 2016);

        RentableItem checkedBook = book.returnItem();

        assertEquals("com.tw.pathashala.models.AvailableBook", checkedBook.getClass().getName());
    }

    @Test
    public void testForCheckingNameOfBookWithItself() {
        RentableItem book = new AvailableBook("Java", "Hari", 2016);

        boolean result = book.isYourName("Java");

        assertEquals(true, result);
    }

}