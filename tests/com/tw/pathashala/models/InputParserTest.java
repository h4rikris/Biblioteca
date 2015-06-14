package com.tw.pathashala.models;

import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.Quit;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InputParserTest {
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
        InputParser m = new InputParser(library, new BooksList(library,new ConsoleOutputTemplate()), new Quit());

        Integer menuSizeBeforeEntry = m.menuList().size();
        m.addOption("Checkout", new BooksList(library,new ConsoleOutputTemplate()));
        Integer menuSizeAfterEntry = m.menuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry + 1)));
    }

}