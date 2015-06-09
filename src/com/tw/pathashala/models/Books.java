package com.tw.pathashala.models;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> books = new ArrayList<Book>();

    public Books() {
        books.add(new Book("Pathashala", "Saurav", 2016));
        books.add(new Book("University", "Rajat", 2015));
        books.add(new Book("Refactoring", "Jashwanth", 2015));
        books.add(new Book("Object Oriented", "Venkatesh", 2014));
    }

    @Override
    public String toString() {
        String booksDetails = "";
        for (Book book : books) {
            if (!book.isPublicationYearInFuture()) {
                booksDetails = booksDetails.concat(book.toString() + "\n");
            }
        }
        if(booksDetails.equals("")){
            return "No Books details are Found";
        }
        return booksDetails;
    }
}
