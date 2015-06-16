package com.tw.pathashala.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NullBookTest {
    @Test
    public void shouldReturnFailForCheckOutByDefault() {
        NullBook nullBook = new NullBook();

        Book nullObject = nullBook.checkOut();

        assertNull(nullObject);
    }

    @Test
    public void shouldReturnFailForReturnBookByDefault() {
        NullBook nullBook = new NullBook();

        Book nullObject = nullBook.returnBook();

        assertNull(nullObject);
    }
}