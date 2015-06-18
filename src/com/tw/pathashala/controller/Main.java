package com.tw.pathashala.controller;

import com.tw.pathashala.models.UserMenuMapper;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

public class Main {
    public static void main(String args[]) {
        Dependencies dependencies = new Dependencies();
        ConsoleOutputTemplate outputTemplate = dependencies.getConsoleOutputInstance();
        ConsoleInput consoleInput = dependencies.getConsoleInputInstance();
        UserMenuMapper userMenuMapper = dependencies.getUserMenuMapper();
        BibliotecaApp app = new BibliotecaApp(outputTemplate, consoleInput, userMenuMapper);
        app.start();
    }
}
