package com.tw.pathashala.models;

import java.util.ArrayList;

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
        if(booksDetails.equals("")){
            return "No Library details are Found";
        }
        return booksDetails;
    }

    public Boolean checkOut(String bookName) {
        Book dummyBook = new Book(bookName, "",0);
        boolean result = false;
        if(books.contains(dummyBook)){
            result = books.get(books.indexOf(dummyBook)).checkOut();
        }
        return result;
    }
}
