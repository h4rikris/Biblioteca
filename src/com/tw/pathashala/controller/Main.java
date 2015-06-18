package com.tw.pathashala.controller;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.models.InputParser;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

public class Main {
    public static void main(String args[]) {
        Dependencies dependencies = new Dependencies();
        ConsoleOutputTemplate outputTemplate = dependencies.getConsoleOutputInstance();
        ConsoleInput consoleInput = dependencies.getConsoleInputInstance();
        InputParser inputParser = dependencies.getInputParserInstance();
        Authentication authentication = dependencies.getAuthenticatorInstance();
        BibliotecaApp app = new BibliotecaApp(outputTemplate, consoleInput, inputParser);
        app.start();
    }
}
