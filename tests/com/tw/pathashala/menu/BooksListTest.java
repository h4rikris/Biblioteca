package com.tw.pathashala.menu;

import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.Books;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BooksListTest {

    ArrayList<Book> listOfBooks = new ArrayList<Book>();
    Books books;
    @Before
    public void setup() {
        books = new Books();
    }

    @Test
    public void canReturnListOfBooksWithDetailsInString() {
        BooksList booklist = new BooksList(books);

        String booksDetails = booklist.display();
        String expectedBooksDetails = String.format("| %-41s | %-41s | %-8s |", "University", "Rajat", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Refactoring", "Jashwanth", "2015") + "\n" +
                String.format("| %-41s | %-41s | %-8s |", "Object Oriented", "Venkatesh", "2014") + "\n";

        assertEquals(booksDetails, expectedBooksDetails);
    }

}