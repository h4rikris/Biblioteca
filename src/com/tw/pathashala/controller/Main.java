package com.tw.pathashala.controller;

import com.tw.pathashala.models.MenuMapper;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

public class Main {
    public static void main(String args[]) {
        Dependencies dependencies = new Dependencies();
        ConsoleOutputTemplate outputTemplate = dependencies.getConsoleOutputInstance();
        ConsoleInput consoleInput = dependencies.getConsoleInputInstance();
        MenuMapper menuMapper = dependencies.getMenuMapper();
        BibliotecaApp app = new BibliotecaApp(outputTemplate, consoleInput, menuMapper);
        app.start();
    }
}
