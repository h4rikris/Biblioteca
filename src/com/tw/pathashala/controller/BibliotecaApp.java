package com.tw.pathashala.controller;

import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

public class BibliotecaApp {

    private ConsoleOutputTemplate template;
    private ConsoleInput input;
    private Authentication authentication;

    public BibliotecaApp(ConsoleOutputTemplate template, ConsoleInput input, Authentication authentication) {
        this.template = template;
        this.input = input;
        this.authentication = authentication;
    }

    public void start() {

        template.renderOutput(WELCOME_MESSAGE, MAIN_MENU);

        String option;
        MenuAction action;
        String result;
        do {
            option = input.getUserInput();
            action = authentication.getMenuMapper().chooseOption(option);
            result = action.execute();
        }
        while (!(result.equals(STOP)));
    }

}