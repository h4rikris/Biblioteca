package com.tw.pathashala.models;

import com.tw.pathashala.menu.*;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

    @Mock
    ConsoleInput consoleInput;

    @Mock
    ReturnBook returnBook;

    @Test
    public void testForMenuAddItemEntry() {
        ConsoleOutputTemplate outputTemplate = new ConsoleOutputTemplate();
        InputParser m = new InputParser(library, new BooksList(library, outputTemplate), new Quit(), new InvalidOption(outputTemplate),
                new CheckOut(outputTemplate, consoleInput, library), returnBook);

        Integer menuSizeBeforeEntry = m.menuList().size();
        m.addOption(5, new BooksList(library, new ConsoleOutputTemplate()));
        Integer menuSizeAfterEntry = m.menuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry + 1)));
    }

}