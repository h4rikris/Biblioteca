package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        Library library = new Library(new ArrayList<Book>());

        String booksDetails = library.availableBooks();
        String expectedBooksDetails = "No Book details are Found";

        assertThat(booksDetails, is(expectedBooksDetails));
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

    @Test
    public void testForCheckOutBookFromListOfBooks() {
        Library library = new Library(listOfBooks);

        Boolean actualResult = library.checkOut("Refactoring");

        assertEquals(true, actualResult);
    }

    @Test
    public void testForCheckOutBookWhichIsNotAvailable() {
        Library library = new Library(listOfBooks);

        Boolean actualResult = library.checkOut("This Book does Not Exist");

        assertEquals(false, actualResult);
    }

    @Test
    public void shouldDisplayCheckedOutBooksIfPresent() {
        Library library = new Library(listOfBooks);

        library.checkOut("Refactoring");
        String checkedOutBooks = String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n";

        assertEquals(checkedOutBooks, library.checkedOutBooks());
    }

    @Test
    public void shouldDisplayMessageWhenCheckedOutBooksAreEmpty() {
        Library library = new Library(listOfBooks);

        String booksDetails = library.checkedOutBooks();
        String expectedBooksDetails = "No Checkedout Book details are Found";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testToReturnBookFromAvailableBooks() {
        Library library = new Library(listOfBooks);

        Boolean actualResult = library.returnBook("Refactoring");

        assertThat(false, is(actualResult));
    }

    @Test
    public void testToReturnBookFromCheckedOutBooks() {
        Library library = new Library(listOfBooks);

        library.checkOut("Refactoring");
        Boolean actualResult = library.returnBook("Refactoring");

        assertThat(true, is(actualResult));
    }

    @Test
    public void testToCheckReturnBookThatBookNotExistInList() {
        Library library = new Library(listOfBooks);

        Boolean actualResult = library.returnBook("Not exist");

        assertFalse(actualResult);
    }
}