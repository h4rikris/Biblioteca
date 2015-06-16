package com.tw.pathashala.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckedOutBookTest {


    @Test
    public void testForBookCheckOutToConvertAvailableBookAfterReturn() {
        Book book = new CheckedOutBook("Java", "Hari", 2016);

        Book checkedBook = book.returnBook();

        assertEquals("com.tw.pathashala.models.AvailableBook", checkedBook.getClass().getName());
    }

    @Test
    public void testForCheckingNameOfBookWithItself() {
        Book book = new AvailableBook("Java", "Hari", 2016);

        boolean result = book.isYourName("Java");

        assertEquals(true, result);
    }

}