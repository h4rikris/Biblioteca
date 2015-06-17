package com.tw.pathashala.controller;

import com.tw.pathashala.menu.*;
import com.tw.pathashala.models.*;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.tw.pathashala.constants.Constants.*;

public class Dependencies {

    private ConsoleOutputTemplate consoleOutputTemplate;
    private ConsoleInput consoleInput;
    private Library bookLibrary;
    private Library movieLibrary;
    private InputParser inputParser;

    public Dependencies() {
        bookLibrary = new Library(availableBookDetails(), new ArrayList<RentableItem>(), new Search());
        movieLibrary = new Library(availableMovieDetails(), new ArrayList<RentableItem>(), new Search());
        consoleInput = new ConsoleInput(new Scanner(System.in));
        consoleOutputTemplate = new ConsoleOutputTemplate();
        inputParser = new InputParser(createMenu(),new InvalidOption(consoleOutputTemplate));

    }

    public InputParser getInputParserInstance() {
        return inputParser;
    }

    public Library getLibraryInstance() {
        return bookLibrary;
    }

    public ConsoleInput getConsoleInputInstance() {
        return consoleInput;
    }

    public ConsoleOutputTemplate getConsoleOutputInstance() {
        return consoleOutputTemplate;
    }

    private ArrayList<RentableItem> availableBookDetails() {
        ArrayList<RentableItem> rentableItems = new ArrayList<RentableItem>();
        rentableItems.add(new AvailableBook("Pathashala", "Saurav", 2016));
        rentableItems.add(new AvailableBook("University", "Rajat", 2015));
        rentableItems.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        rentableItems.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
        return rentableItems;
    }

    private ArrayList<RentableItem> availableMovieDetails() {
        ArrayList<RentableItem> rentableItems = new ArrayList<RentableItem>();
        rentableItems.add(new AvailableMovie("Inception", "Saurav", 2016, 10));
        rentableItems.add(new AvailableMovie("Avatar", "Rajat", 2015, 9));
        rentableItems.add(new AvailableMovie("Titanic", "Jashwanth", 2015, 9));
        rentableItems.add(new AvailableMovie("AVP", "Venkatesh", 2014, 9));
        return rentableItems;
    }

    private Map<Integer, MenuAction> createMenu() {
        Map<Integer, MenuAction> menuList = new HashMap<Integer, MenuAction>();
        menuList.put(BOOKS_LIST_OPTION, new BooksList(bookLibrary, consoleOutputTemplate));
        menuList.put(BOOKS_CHECKOUT_OPTION, new CheckOutBook(consoleOutputTemplate, consoleInput, bookLibrary));
        menuList.put(BOOKS_RETURN_OPTION, new ReturnBook(consoleOutputTemplate, consoleInput, bookLibrary));
        menuList.put(MOVIE_LIST_OPTION, new BooksList(movieLibrary, consoleOutputTemplate));
        menuList.put(MOVIE_CHECKOUT_OPTION, new CheckOutBook(consoleOutputTemplate, consoleInput, movieLibrary));
        menuList.put(MOVIE_RETURN_OPTION, new ReturnBook(consoleOutputTemplate, consoleInput, movieLibrary));
        menuList.put(QUIT_OPTION, new Quit());
        return menuList;
    }
}