package com.tw.pathashala.controller;

import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.models.Books;
import com.tw.pathashala.models.Menu;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.Scanner;

public class Biblioteca {
    public static void main (String args[]){
        ConsoleOutputTemplate out = new ConsoleOutputTemplate();

        Books books = new Books();
        Menu menu = new Menu(books);
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
