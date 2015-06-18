package com.tw.pathashala.models;

import com.tw.pathashala.controller.Dependencies;
import com.tw.pathashala.menu.ReturnBook;
import com.tw.pathashala.view.ConsoleInput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.*;
import static org.junit.Assert.assertEquals;

public class InputParserTest {
    Library library;

    ArrayList<RentableItem> listOfRentableItems = new ArrayList<RentableItem>();

    InputParser inputParser;
    UserHistory userHistory;

    @Mock
    ConsoleInput consoleInput;

    @Mock
    ReturnBook returnBook;

    @Before
    public void setup() {
        Dependencies dependencies = new Dependencies();
        inputParser = dependencies.getInputParserInstance();
        userHistory = dependencies.getUserHistory();
    }

    @Before
    public void setUp() throws Exception {
        library = new Library(listOfRentableItems, new ArrayList<RentableItem>(), new Search(), userHistory);
    }

    @Test
    public void testToReturnInvalidInputOnUserEntersString() {
        String actualClassName = inputParser.chooseOption("No option").getClass().getName();

        assertEquals("com.tw.pathashala.menu.InvalidOption", actualClassName);
    }

    @Test
    public void testToReturnBooksListOnUserSelectslistBooks() {
        String actualClassName = inputParser.chooseOption(BOOKS_LIST_OPTION.toString()).getClass().getName();

        assertEquals("com.tw.pathashala.menu.ListOutItems", actualClassName);
    }

    @Test
    public void testToReturnQuitOnUserSelectsQuit() {
        String actualClassName = inputParser.chooseOption(QUIT_OPTION.toString()).getClass().getName();

        assertEquals("com.tw.pathashala.menu.Quit", actualClassName);
    }

    @Test
    public void testToReturnCheckOutOnUserSelectsCheckOut() {
        String actualClassName = inputParser.chooseOption(BOOKS_CHECKOUT_OPTION.toString()).getClass().getName();

        assertEquals("com.tw.pathashala.menu.CheckOutBook", actualClassName);
    }

    @Test
    public void testToReturnInvalidOptionOnInvalidSelectionInMenuList() {
        String actualClassName = inputParser.chooseOption("-8").getClass().getName();

        assertEquals("com.tw.pathashala.menu.InvalidOption", actualClassName);
    }

}