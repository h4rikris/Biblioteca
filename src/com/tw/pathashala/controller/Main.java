package com.tw.pathashala.controller;

import com.tw.pathashala.models.InputParser;
import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

public class Main {
    public static void main(String args[]) {
        Dependencies dependencies = new Dependencies();
        ConsoleOutputTemplate outputTemplate = dependencies.getConsoleOutputInstance();
        ConsoleInput consoleInput = dependencies.getConsoleInputInstance();
        Library library = dependencies.getLibraryInstance();
        InputParser inputParser = dependencies.getInputParserInstance();
        BibliotecaApp app = new BibliotecaApp(outputTemplate, consoleInput, library, inputParser);
        app.start();
    }
}
