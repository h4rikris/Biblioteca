package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {

    ArrayList<RentableItem> availableRentableItems = new ArrayList<RentableItem>();
    ArrayList<RentableItem> checkedOutRentableItems = new ArrayList<RentableItem>();
    Search search = new Search();

    @Before
    public void setup() {
        availableRentableItems.add(new AvailableBook("Pathashala", "Saurav", 2016));
        availableRentableItems.add(new AvailableBook("University", "Rajat", 2015));
        availableRentableItems.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        availableRentableItems.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
        checkedOutRentableItems.clear();
    }

    @Test
    public void testForBooksReturningBookDetails() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        String booksDetails = library.availableItems();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForEmptyListOfBooks() {
        Library library = new Library(new ArrayList<RentableItem>(), checkedOutRentableItems, search);

        String booksDetails = library.availableItems();
        String expectedBooksDetails = "No Book details are Found";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForNotToDisplayBookDetailsHavingFutureYearOfPublication() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        String booksDetails = library.availableItems();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForDisplayCheckedOutBookDetails() {
        checkedOutRentableItems.add(new CheckedOutBook("Java", "Hari", 2015));
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        String booksDetails = library.checkedOutItems();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "Java", "Hari", "2015") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForCheckOutBookFromListOfBooks() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        Boolean actualResult = library.checkOut("Refactoring");

        assertEquals(true, actualResult);
    }

    @Test
    public void testForCheckOutBookWhichIsNotAvailable() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        Boolean actualResult = library.checkOut("This Book does Not Exist");

        assertEquals(false, actualResult);
    }

    @Test
    public void shouldDisplayCheckedOutBooksIfPresent() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        library.checkOut("Refactoring");
        String checkedOutBooks = String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n";

        assertEquals(checkedOutBooks, library.checkedOutItems());
    }

    @Test
    public void shouldDisplayMessageWhenCheckedOutBooksAreEmpty() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        String booksDetails = library.checkedOutItems();
        String expectedBooksDetails = "No Book details are Found";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testToReturnBookFromAvailableBooks() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        Boolean actualResult = library.returnItem("Refactoring");

        assertThat(actualResult, is(false));
    }

    @Test
    public void testToReturnBookFromCheckedOutBooks() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        library.checkOut("Refactoring");
        Boolean actualResult = library.returnItem("Refactoring");

        assertThat(actualResult, is(true));
    }

    @Test
    public void testToCheckReturnBookThatBookNotExistInList() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search);

        Boolean actualResult = library.returnItem("Not exist");

        assertFalse(actualResult);
    }
}