package com.tw.pathashala.models;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.*;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public String availableBooks() {
        String booksDetails = "";
        for (Book book : books) {
            if (!(book.isPublicationYearInFuture() || book.isCheckedOut())) {
                booksDetails = booksDetails.concat(book.toString() + "\n");
            }
        }
        if (booksDetails.equals("")) {
            return NO_BOOK_DETAILS_ARE_FOUND;
        }
        return booksDetails;
    }

    public Boolean checkOut(String bookName) {
        Book book = getBookByName(bookName);
        if (book == null) {
            return FAILED;
        }
        return book.checkOut();
    }

    private Book getBookByName(String bookName) {
        Book dummyBook = new Book(bookName, "", 0);
        if (books.contains(dummyBook)) {
            return books.get(books.indexOf(dummyBook));
        }
        return null;
    }

    public String checkedOutBooks() {
        String booksDetails = "";
        for (Book book : books) {
            if (book.isCheckedOut()) {
                booksDetails = booksDetails.concat(book.toString() + "\n");
            }
        }
        if (booksDetails.equals("")) {
            return NO_CHECKEDOUT_BOOK_DETAILS_ARE_FOUND;
        }
        return booksDetails;
    }

    public Boolean returnBook(String bookName) {
        Book book = getBookByName(bookName);
        if (book == null) {
            return FAILED;
        } else {
            return book.returnBook();
        }

    }
}
