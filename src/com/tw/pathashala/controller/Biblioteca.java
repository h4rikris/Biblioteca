package com.tw.pathashala.controller;

import com.tw.pathashala.view.ConsoleOutputTemplate;

public class Biblioteca {
    public static void main (String args[]){
        ConsoleOutputTemplate out = new ConsoleOutputTemplate();
        out.addToBody("Welcome!\n");
        out.renderOutput();
    }
}
