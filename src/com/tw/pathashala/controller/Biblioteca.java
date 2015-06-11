package com.tw.pathashala.controller;

import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.menu.Quit;
import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.Library;
import com.tw.pathashala.models.Menu;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main (String args[]){
        ConsoleOutputTemplate template = new ConsoleOutputTemplate();

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Pathashala", "Saurav", 2016));
        books.add(new Book("University", "Rajat", 2015));
        books.add(new Book("Refactoring", "Jashwanth", 2015));
        books.add(new Book("Object Oriented", "Venkatesh", 2014));
        Book checkedOutBook = new Book("Object Oriented Design", "Hari", 2014);
        checkedOutBook.checkOut();
        books.add(checkedOutBook);

        Library library = new Library(books);
        Menu menu = new Menu(library, new BooksList(library), new Quit());
        template.addToBody("Welcome!");
        template.addToFooter(menu.toString());
        template.renderOutput();

        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        MenuAction action = menu.chooseOption(option);
        while(action.display() != null) {
            template.addToBody(action.display());
            template.addToFooter(menu.toString());
            template.renderOutput();
            option = sc.nextLine();
            action = menu.chooseOption(option);
        }
    }

}
