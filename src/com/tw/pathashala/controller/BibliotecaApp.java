package com.tw.pathashala.controller;

import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.models.InputParser;
import com.tw.pathashala.models.MenuMapper;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

public class BibliotecaApp {

    private ConsoleOutputTemplate template;
    private ConsoleInput input;
    private MenuMapper menuMapper;

    public BibliotecaApp(ConsoleOutputTemplate template, ConsoleInput input, MenuMapper menuMapper) {
        this.template = template;
        this.input = input;
        this.menuMapper = menuMapper;
    }

    public void start() {

        template.renderOutput(WELCOME_MESSAGE, LOGGEDOUT_MAIN_MENU);

        String option;
        MenuAction action;
        String result;
        InputParser inputParser;
        do {
            inputParser = menuMapper.getMenu();
            option = input.getUserInput();
            action = inputParser.chooseOption(option);
            result = action.execute();
        }
        while (!(result.equals(STOP)));
    }

}