package com.tw.pathashala.models;

import com.tw.pathashala.constants.Constants;
import com.tw.pathashala.controller.Dependencies;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.*;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    ArrayList<RentableItem> availableRentableItems = new ArrayList<RentableItem>();
    ArrayList<RentableItem> checkedOutRentableItems = new ArrayList<RentableItem>();
    Search search = new Search();
    UserHistory userHistory;
    Dependencies dependencies = new Dependencies();
    Authentication authentication;

    @Before
    public void setup() {
        authentication = dependencies.getAuthenticatorInstance();
        authentication.setCurrentLoggedInUser(new User("admin","password"));
        userHistory = dependencies.getUserHistory();
        availableRentableItems.add(new AvailableBook("Pathashala", "Saurav", 2016));
        availableRentableItems.add(new AvailableBook("University", "Rajat", 2015));
        availableRentableItems.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        availableRentableItems.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
        checkedOutRentableItems.add(new CheckedOutBook("Oriented", "SSS", 2014));
    }

    @Test
    public void testForBooksReturningBookDetails() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String booksDetails = library.availableItems();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForEmptyListOfBooks() {
        Library library = new Library(new ArrayList<RentableItem>(), checkedOutRentableItems, search, userHistory);

        String booksDetails = library.availableItems();
        String expectedBooksDetails = "No Item details are Found";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForNotToDisplayBookDetailsHavingFutureYearOfPublication() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String booksDetails = library.availableItems();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForDisplayCheckedOutBookDetails() {
        checkedOutRentableItems.clear();
        checkedOutRentableItems.add(new CheckedOutBook("Java", "Hari", 2015));
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String booksDetails = library.checkedOutItems();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "Java", "Hari", "2015") + "\n";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testForCheckOutBookFromListOfBooks() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String actualResult = library.checkOut("Refactoring");

        assertEquals(BOOK_CHECKOUT_SUCCESS_MESSAGE, actualResult);
    }

    @Test
    public void testForCheckOutBookWhichIsNotAvailable() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String actualResult = library.checkOut("This Book does Not Exist");

        assertEquals(BOOK_CHECKOUT_INVALID_MESSAGE, actualResult);
    }

    @Test
    public void shouldDisplayCheckedOutBooksIfPresent() {
        checkedOutRentableItems.clear();
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        library.checkOut("Refactoring");
        String checkedOutBooks = String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n";

        assertEquals(checkedOutBooks, library.checkedOutItems());
    }

    @Test
    public void shouldDisplayMessageWhenCheckedOutBooksAreEmpty() {
        checkedOutRentableItems.clear();
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String booksDetails = library.checkedOutItems();
        String expectedBooksDetails = "No Item details are Found";

        assertThat(booksDetails, is(expectedBooksDetails));
    }

    @Test
    public void testToReturnBookFromAvailableBooks() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String actualResult = library.returnItem("Refactoring");

        assertThat(actualResult, is(BOOK_RETURN_FAIL_MESSAGE));
    }

    @Test
    public void testToReturnBookFromCheckedOutBooks() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        library.checkOut("Refactoring");
        String actualResult = library.returnItem("Refactoring");

        assertThat(actualResult, is(BOOK_RETURN_SUCCESS_MESSAGE));
    }

    @Test
    public void testToCheckReturnBookThatBookNotExistInList() {
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        String actualResult = library.returnItem("Not exist");

        assertEquals(Constants.BOOK_RETURN_FAIL_MESSAGE, actualResult);
    }

    @Test
    public void shouldAddCheckOutItemToUserHistory() {
        UserHistory userHistory = Mockito.mock(UserHistory.class);
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        library.checkOut("Refactoring");
        RentableItem item = new CheckedOutBook("Refactoring", "Jashwanth", 2015);

        verify(userHistory).addItem(item);
    }

    @Test
    public void shouldRemoveReturnedItemFromUserHistory() {
        UserHistory userHistory = Mockito.mock(UserHistory.class);
        Library library = new Library(availableRentableItems, checkedOutRentableItems, search, userHistory);

        library.returnItem("Oriented");
        RentableItem item = new CheckedOutBook("Oriented", "SSS", 2014);

        verify(userHistory).removeItem(item);
    }
}