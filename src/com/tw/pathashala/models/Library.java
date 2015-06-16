package com.tw.pathashala.models;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.FAILED;
import static com.tw.pathashala.constants.Constants.NO_BOOK_DETAILS_ARE_FOUND;

public class Library {
    private Search searchAgent;
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks, Search searchAgent) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
        this.searchAgent = searchAgent;
    }

    public String availableBooks() {
        return displayBooks(availableBooks);
    }

    public Boolean checkOut(String bookName) {
        ArrayList<Book> books = searchAgent.search(availableBooks, bookName);
        for(Book book: books) {
            Book checkedOutBook = book.checkOut();
            availableBooks.remove(book);
            return checkedOutBooks.add(checkedOutBook);
        }
        return false;
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
        ArrayList<Book> books = searchAgent.search(checkedOutBooks, bookName);
        for(Book book: books) {
            Book returnedBook = book.returnBook();
            checkedOutBooks.remove(book);
            return availableBooks.add(returnedBook);
        }
        return false;
    }
}
