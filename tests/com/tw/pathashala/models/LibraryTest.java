package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibraryTest {

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
        Library library = new Library(listOfBooks);

        String booksDetails = library.availableBooks();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForEmptyListOfBooks() {
        Library library = new Library(listOfBooks);

        String booksDetails = library.availableBooks();
        String expectedBooksDetails = "No Library details are Found";

        assertThat(booksDetails, is(not(expectedBooksDetails)));
    }

    @Test
    public void testForNotToDisplayBookDetailsHavingFutureYearOfPublication() {
        Library library = new Library(listOfBooks);

        String booksDetails = library.availableBooks();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForNotToDisplayCheckedOutBookDetails() {
        Library library = new Library(listOfBooks);

        String booksDetails = library.availableBooks();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

}