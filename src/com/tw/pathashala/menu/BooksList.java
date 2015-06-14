package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.CHECKOUT_MENU;
import static com.tw.pathashala.constants.Constants.CONTINUE;

public class BooksList implements MenuAction {

    private Library library;
    private ConsoleOutputTemplate outputTemplate;

    public BooksList(Library library, ConsoleOutputTemplate outputTemplate) {
        this.library = library;
        this.outputTemplate = outputTemplate;
    }

    @Override
    public String execute() {
        outputTemplate.addToBody(library.availableBooks());
        outputTemplate.addToFooter(CHECKOUT_MENU);
        outputTemplate.renderOutput();
        return CONTINUE;
    }

}
