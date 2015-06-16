package com.tw.pathashala.models;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.FAILED;
import static com.tw.pathashala.constants.Constants.NO_BOOK_DETAILS_ARE_FOUND;

public class Library {
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public String availableBooks() {
        return displayBooks(availableBooks);
    }

    public Boolean checkOut(String bookName) {
        Book book = getBookByName(bookName, availableBooks);
        if (book.isNull()) {
            return FAILED;
        } else {
            Book checkedOutBook = book.checkOut();
            availableBooks.remove(book);
            return checkedOutBooks.add(checkedOutBook);
        }
    }

    private Book getBookByName(String bookName, ArrayList<Book> listOfBooks) {
        bookName = eliminateNewLine(bookName);
        for (Book book : listOfBooks) {
            if (book.isYourName(bookName)) {
                return book;
            }
        }
        return new NullBook();
    }

    public String checkedOutBooks() {
        return displayBooks(checkedOutBooks);
    }

    private String displayBooks(ArrayList<Book> listOfBooks) {
        String booksDetails = "";
        for (Book book : listOfBooks) {
            if(!book.isPublicationYearInFuture())
                booksDetails = booksDetails.concat(book.toString() + "\n");
        }
        if (booksDetails.equals("")) {
            return NO_BOOK_DETAILS_ARE_FOUND;
        }
        return booksDetails;
    }

    public Boolean returnBook(String bookName) {
        Book book = getBookByName(bookName, checkedOutBooks);
        if (book.isNull()) {
            return FAILED;
        } else {
            Book returnedBook = book.returnBook();
            checkedOutBooks.remove(book);
            return availableBooks.add(returnedBook);
        }
    }

    private String eliminateNewLine(String name) {
        return name.split("\\n")[0];
    }
}
