package com.tw.pathashala.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testForBookReturningBookDetails() {
        Book book = new Book("Java", "Hari" ,"12-05-2015");

        String bookDetails = book.toString();
        String expectedBookDetails = "Java Hari 12-05-2015";

        assertEquals(expectedBookDetails, bookDetails);
    }

    @Test
    public void testForBookDetailsConsistsAuthor() {
        Book book = new Book("Java", "Hari" ,"12-05-2015");

        String bookDetails = book.toString();
        String author = "Hari";

        assertTrue(bookDetails.contains(author));
    }
}