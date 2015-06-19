package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static com.tw.pathashala.constants.Constants.LOGGEDIN_MAIN_MENU;
import static com.tw.pathashala.constants.Constants.LOGGEDOUT_MAIN_MENU;

public class ListOutItems implements MenuAction {

    private Library library;
    private ConsoleOutputTemplate outputTemplate;

    public ListOutItems(Library library, ConsoleOutputTemplate outputTemplate) {
        this.library = library;
        this.outputTemplate = outputTemplate;
    }

    @Override
    public String execute() {
        outputTemplate.renderOutput(library.availableItems(), LOGGEDOUT_MAIN_MENU);
        return CONTINUE;
    }

}
