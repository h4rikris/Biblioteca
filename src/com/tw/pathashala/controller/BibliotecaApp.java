package com.tw.pathashala.controller;

import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.models.InputParser;
import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

public class BibliotecaApp {

    private ConsoleOutputTemplate template;
    private ConsoleInput input;
    private Library library;
    private InputParser inputParser;

    public BibliotecaApp(ConsoleOutputTemplate template, ConsoleInput input, Library library, InputParser inputParser) {
        this.template = template;
        this.input = input;
        this.library = library;
        this.inputParser = inputParser;
    }

    public void start() {

        template.renderOutput(WELCOME_MESSAGE, MAIN_MENU);


        String option;
        MenuAction action;
        String result;
        do {
            option = input.getUserInput();
            action = inputParser.chooseOption(option);
            result = action.execute();
        }
        while (!(result.equals(STOP)));
    }

}