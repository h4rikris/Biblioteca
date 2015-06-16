package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class SearchTest {

    ArrayList<Book> bookDetails = new ArrayList<Book>();

    @Before
    public void setUp() throws Exception {
        bookDetails.add(new AvailableBook("University", "Rajat", 2015));
        bookDetails.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        bookDetails.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
    }

    @Test
    public void shouldReturnListOfBooksBasedOnBookName() {
        Search search = new Search();

        ArrayList<Book> actualBooks = search.search(bookDetails, "University");
        ArrayList<Book> expectedBooks = new ArrayList<Book>(1);
        expectedBooks.add(new AvailableBook("University", "Rajat", 2015));

        assertArrayEquals(expectedBooks.toArray(), actualBooks.toArray());
    }
}