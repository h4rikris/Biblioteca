package com.tw.pathashala.models;

import com.tw.pathashala.menu.*;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InputParserTest {
    Library library;

    ArrayList<RentableItem> listOfRentableItems = new ArrayList<RentableItem>();

    InputParser inputParser;

    @Mock
    ConsoleInput consoleInput;

    @Mock
    ReturnBook returnBook;

    @Before
    public void setup() {
        listOfRentableItems.add(new AvailableBook("Pathashala", "Saurav", 2016));
        listOfRentableItems.add(new AvailableBook("University", "Rajat", 2015));
        listOfRentableItems.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        listOfRentableItems.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
        ConsoleOutputTemplate outputTemplate = new ConsoleOutputTemplate();
        BooksList bookList = new BooksList(library, outputTemplate);
        inputParser = new InputParser(library, bookList, new Quit(), new InvalidOption(outputTemplate),
                new CheckOut(outputTemplate, consoleInput, library), returnBook);
    }

    @Before
    public void setUp() throws Exception {
        library = new Library(listOfRentableItems, new ArrayList<RentableItem>(), new Search());
    }

    @Test
    public void testForMenuAddItemEntry() {
        Integer menuSizeBeforeEntry = inputParser.menuList().size();

        inputParser.addOption(5, new BooksList(library, new ConsoleOutputTemplate()));
        Integer menuSizeAfterEntry = inputParser.menuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry + 1)));
    }

    @Test
    public void testToReturnInvalidInputOnUserEntersString() {
        String actualClassName = inputParser.chooseOption("No option").getClass().getName();

        assertEquals("com.tw.pathashala.menu.InvalidOption", actualClassName);
    }

    @Test
    public void testToReturnBooksListOnUserSelectslistBooks() {
        String actualClassName = inputParser.chooseOption(LIST_BOOKS_OPTION.toString()).getClass().getName();

        assertEquals("com.tw.pathashala.menu.BooksList", actualClassName);
    }

    @Test
    public void testToReturnQuitOnUserSelectsQuit() {
        String actualClassName = inputParser.chooseOption(QUIT_OPTION.toString()).getClass().getName();

        assertEquals("com.tw.pathashala.menu.Quit", actualClassName);
    }

    @Test
    public void testToReturnCheckOutOnUserSelectsCheckOut() {
        String actualClassName = inputParser.chooseOption(CHECKOUT_OPTION.toString()).getClass().getName();

        assertEquals("com.tw.pathashala.menu.CheckOut", actualClassName);
    }

    @Test
    public void testToReturnInvalidOptionOnInvalidSelectionInMenuList() {
        String actualClassName = inputParser.chooseOption("8").getClass().getName();

        assertEquals("com.tw.pathashala.menu.InvalidOption", actualClassName);
    }

}