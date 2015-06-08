package com.tw.pathashala.controller;

import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.Menu;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main (String args[]){
        ConsoleOutputTemplate out = new ConsoleOutputTemplate();

        //Book data initialization
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Pathashala", "Saurav", 2016));
        listOfBooks.add(new Book("University", "Rajat", 2015));
        listOfBooks.add(new Book("Refactoring", "Jashwanth", 2015));
        listOfBooks.add(new Book("Object Oriented", "Venkatesh", 2014));

        Menu menu = new Menu();
        out.addToBody("Welcome!");
        out.addToFooter(menu.toString());
        out.renderOutput();

        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        MenuAction action = menu.chooseOption(option);
        while(action.display() != null) {
            ConsoleOutputTemplate template = new ConsoleOutputTemplate();
            template.addToBody(action.display());
            template.addToFooter(menu.toString());
            template.renderOutput();
            option = sc.nextLine();
            action = menu.chooseOption(option);
        }
    }

}
