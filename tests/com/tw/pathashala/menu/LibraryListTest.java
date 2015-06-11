package com.tw.pathashala.menu;

import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryListTest {
    ArrayList<Book> listOfBooks = new ArrayList<Book>();
    Library library;

    @Before
    public void setup() {
        listOfBooks.add(new Book("Pathashala", "Saurav", 2016));
        listOfBooks.add(new Book("University", "Rajat", 2015));
        listOfBooks.add(new Book("Refactoring", "Jashwanth", 2015));
        listOfBooks.add(new Book("Object Oriented", "Venkatesh", 2014));
        library = new Library(listOfBooks);
    }

    @Test
    public void canReturnListOfBooksWithDetailsInString() {
        BooksList booklist = new BooksList(library);

        String booksDetails = booklist.display();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertEquals(booksDetails, expectedBooksDetails);
    }

}