package com.tw.pathashala.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NullBookTest {
    @Test
    public void shouldReturnFailForCheckOutByDefault() {
        NullBook nullBook = new NullBook();

        boolean actual = nullBook.checkOut();

        assertFalse(actual);
    }

    @Test
    public void shouldReturnFailForReturnBookByDefault() {
        NullBook nullBook = new NullBook();

        boolean actual = nullBook.returnBook();

        assertFalse(actual);
    }
}