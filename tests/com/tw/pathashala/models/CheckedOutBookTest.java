package com.tw.pathashala.models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckedOutBookTest {


    @Test
    public void testForBookCheckOutToConvertAvailableBookAfterReturn() {
        RentableItem book = new CheckedOutBook("Java", "Hari", 2016);

        RentableItem checkedBook = book.returnItem();

        assertEquals("com.tw.pathashala.models.AvailableBook", checkedBook.getClass().getName());
    }

    @Test
    public void testForCheckingNameAddToListIfTitleMatches() {
        RentableItem book = new AvailableBook("Java", "Hari", 2016);

        ArrayList<RentableItem> itemList = new ArrayList<RentableItem>();
        book.addToListIfTitleMatches(itemList, "Java");

        assertEquals(1, itemList.size());
    }

}