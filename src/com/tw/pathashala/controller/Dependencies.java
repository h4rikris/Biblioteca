package com.tw.pathashala.controller;

import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.CheckOut;
import com.tw.pathashala.menu.InvalidOption;
import com.tw.pathashala.menu.Quit;
import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.InputParser;
import com.tw.pathashala.models.Library;
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
        library = new Library(bookDetails());
        consoleInput = new ConsoleInput(new Scanner(System.in));
        consoleOutputTemplate = new ConsoleOutputTemplate();
        inputParser = new InputParser(library, new BooksList(library, consoleOutputTemplate), new Quit(), new InvalidOption(consoleOutputTemplate), new CheckOut(consoleOutputTemplate, consoleInput, library));

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

    private ArrayList<Book> bookDetails() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Pathashala", "Saurav", 2016));
        books.add(new Book("University", "Rajat", 2015));
        books.add(new Book("Refactoring", "Jashwanth", 2015));
        books.add(new Book("Object Oriented", "Venkatesh", 2014));
        Book checkedOutBook = new Book("Object Oriented Design", "Hari", 2014);
        checkedOutBook.checkOut();
        books.add(checkedOutBook);
        return books;
    }
}