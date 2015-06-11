package com.tw.pathashala.models;

import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.Quit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuTest {
    Library library;

    ArrayList<Book> listOfBooks = new ArrayList<Book>();

    @Before
    public void setup() {
        listOfBooks.add(new Book("Pathashala", "Saurav", 2016));
        listOfBooks.add(new Book("University", "Rajat", 2015));
        listOfBooks.add(new Book("Refactoring", "Jashwanth", 2015));
        listOfBooks.add(new Book("Object Oriented", "Venkatesh", 2014));
    }

    @Before
    public void setUp() throws Exception {
        library = new Library(listOfBooks);
    }

    @Test
    public void testForMenuAddItemEntry() {
        Menu m = new Menu(library, new BooksList(library), new Quit());

        Integer menuSizeBeforeEntry = m.menuList().size();
        m.addOption("Checkout", new BooksList(library));
        Integer menuSizeAfterEntry = m.menuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry + 1)));
    }

}