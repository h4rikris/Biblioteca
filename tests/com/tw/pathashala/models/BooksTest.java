package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BooksTest {

    ArrayList<Book> listOfBooks = new ArrayList<Book>();

    @Before
    public void setup() {
        listOfBooks.add(new Book("Pathashala", "Saurav", 2016));
        listOfBooks.add(new Book("University", "Rajat", 2015));
        listOfBooks.add(new Book("Refactoring", "Jashwanth", 2015));
        listOfBooks.add(new Book("Object Oriented", "Venkatesh", 2014));
    }

    @Test
    public void testForBooksReturningBookDetails() {
        Books books = new Books(listOfBooks);

        String booksDetails = books.toString();
        String expectedBooksDetails = "University           | Rajat           | 2015 \n" +
                "Refactoring          | Jashwanth       | 2015 \n" +
                "Object Oriented      | Venkatesh       | 2014 \n";
        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForEmptyListOfBooks() {
        Books books = new Books(new ArrayList<Book>(0));

        String booksDetails = books.toString();
        String expectedBooksDetails = "";

        assertEquals(booksDetails, expectedBooksDetails);
    }

    @Test
    public void testForNotToDisplayBookDetailsHavingFutureYearOfPublication() {
        Books books = new Books(listOfBooks);

        String booksDetails = books.toString();
        String expectedBooksDetails = "University           | Rajat           | 2015 \n" +
                "Refactoring          | Jashwanth       | 2015 \n" +
                "Object Oriented      | Venkatesh       | 2014 \n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }
    
}