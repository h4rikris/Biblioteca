package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BooksTest {

    ArrayList<Book> listOfBooks = new ArrayList<Book>();

    @Before
    public void setup() {
        listOfBooks.add(new Book("Pathashala", "Saurav", "12-05-2014"));
        listOfBooks.add(new Book("University", "Rajat", "12-07-2015"));
        listOfBooks.add(new Book("Refactoring", "Jashwanth", "13-06-2015"));
        listOfBooks.add(new Book("Object Oriented", "Venkatesh", "11-05-2014"));
    }

    @Test
    public void testForBooksReturningAllBookDetails() {
        Books books = new Books(listOfBooks);

        String booksDetails = books.toString();
        String expectedBooksDetails = "Pathashala Saurav 12-05-2014\n" +
                "University Rajat 12-07-2015\n" +
                "Refactoring Jashwanth 13-06-2015\n" +
                "Object Oriented Venkatesh 11-05-2014\n";
        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForEmptyListOfBooks() {
        Books books = new Books(new ArrayList<Book>(0));

        String booksDetails = books.toString();
        String expectedBooksDetails = "";

        assertEquals(booksDetails, expectedBooksDetails);
    }

}