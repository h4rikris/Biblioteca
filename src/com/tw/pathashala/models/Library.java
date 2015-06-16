package com.tw.pathashala.models;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.NO_BOOK_DETAILS_ARE_FOUND;
import static com.tw.pathashala.constants.Constants.NO_CHECKEDOUT_BOOK_DETAILS_ARE_FOUND;

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
        return book.checkOut();
    }

    private Book getBookByName(String bookName) {
        bookName = eliminateNewLine(bookName);
        for (Book book : books) {
            if (book.isYourName(bookName)) {
                return book;
            }
        }
        return new NullBook();
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
        return book.returnBook();
    }

    private String eliminateNewLine(String name) {
        return name.split("\\n")[0];
    }
}
