package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class SearchTest {

    ArrayList<RentableItem> rentableItemDetails = new ArrayList<RentableItem>();

    @Before
    public void setUp() throws Exception {
        rentableItemDetails.add(new AvailableBook("University", "Rajat", 2015));
        rentableItemDetails.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        rentableItemDetails.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
    }

    @Test
    public void shouldReturnListOfBooksBasedOnBookName() {
        Search search = new Search();

        ArrayList<RentableItem> actualBooks = search.search(rentableItemDetails, "University");
        ArrayList<RentableItem> expectedRentableItems = new ArrayList<RentableItem>(1);
        expectedRentableItems.add(new AvailableBook("University", "Rajat", 2015));

        assertArrayEquals(expectedRentableItems.toArray(), actualBooks.toArray());
    }
}