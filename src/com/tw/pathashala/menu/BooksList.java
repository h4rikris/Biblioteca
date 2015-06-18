package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static com.tw.pathashala.constants.Constants.LOGGEDIN_MAIN_MENU;

public class BooksList implements MenuAction {

    private Library library;
    private ConsoleOutputTemplate outputTemplate;

    public BooksList(Library library, ConsoleOutputTemplate outputTemplate) {
        this.library = library;
        this.outputTemplate = outputTemplate;
    }

    @Override
    public String execute() {
        outputTemplate.renderOutput(library.availableItems(), LOGGEDIN_MAIN_MENU);
        return CONTINUE;
    }

}
