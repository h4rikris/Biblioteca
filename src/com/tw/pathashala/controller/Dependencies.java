package com.tw.pathashala.controller;

import com.tw.pathashala.menu.*;
import com.tw.pathashala.models.*;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.ArrayList;
import java.util.Scanner;

public class Dependencies {

    private ConsoleOutputTemplate consoleOutputTemplate;
    private ConsoleInput consoleInput;
    private Library library;
    private InputParser inputParser;

    public Dependencies() {
        library = new Library(availableBookDetails(), new ArrayList<Book>(), new Search());
        consoleInput = new ConsoleInput(new Scanner(System.in));
        consoleOutputTemplate = new ConsoleOutputTemplate();
        inputParser = new InputParser(library, new BooksList(library, consoleOutputTemplate), new Quit(), new InvalidOption(consoleOutputTemplate),
                new CheckOut(consoleOutputTemplate, consoleInput, library), new ReturnBook(consoleOutputTemplate, consoleInput, library));

    }

    public InputParser getInputParserInstance() {
        return inputParser;
    }

    public Library getLibraryInstance() {
        return library;
    }

    public ConsoleInput getConsoleInputInstance() {
        return consoleInput;
    }

    public ConsoleOutputTemplate getConsoleOutputInstance() {
        return consoleOutputTemplate;
    }

    private ArrayList<Book> availableBookDetails() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new AvailableBook("Pathashala", "Saurav", 2016));
        books.add(new AvailableBook("University", "Rajat", 2015));
        books.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        books.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
        return books;
    }
}