package com.tw.pathashala.com.tw.pathashala.menu;

import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.Books;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DisplayBookListTest {

    ArrayList<Book> listOfBooks = new ArrayList<Book>();

    @Before
    public void setup() {
        listOfBooks.add(new Book("Pathashala", "Saurav", 2016));
        listOfBooks.add(new Book("University", "Rajat", 2015));
        listOfBooks.add(new Book("Refactoring", "Jashwanth", 2015));
        listOfBooks.add(new Book("Object Oriented", "Venkatesh", 2014));
    }

    @Test
    public void canReturnListOfBooksWithDetailsInString() {
        Books books = new Books(listOfBooks);
        DisplayBookList booklist = new DisplayBookList();

        String booksDetails = booklist.display(books);
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertEquals(booksDetails, expectedBooksDetails);
    }

}