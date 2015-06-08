package com.tw.pathashala.controller;

import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.Menu;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.ArrayList;

public class Biblioteca {
    public static void main (String args[]){
        ConsoleOutputTemplate out = new ConsoleOutputTemplate();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Pathashala", "Saurav", 2016));
        listOfBooks.add(new Book("University", "Rajat", 2015));
        listOfBooks.add(new Book("Refactoring", "Jashwanth", 2015));
        listOfBooks.add(new Book("Object Oriented", "Venkatesh", 2014));

        Menu menu = new Menu();
        out.addToBody("Welcome!");
        out.addToBody(menu.toString());
        out.renderOutput();

    }
}
