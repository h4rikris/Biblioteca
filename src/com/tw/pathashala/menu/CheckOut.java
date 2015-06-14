package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.CHECKOUT_MESSAGE;
import static com.tw.pathashala.constants.Constants.CONTINUE;

public class CheckOut implements MenuAction {
    ConsoleOutputTemplate outputTemplate;
    ConsoleInput consoleInput;
    Library library;

    public CheckOut(ConsoleOutputTemplate outputTemplate, ConsoleInput consoleInput, Library library) {
        this.outputTemplate = outputTemplate;
        this.consoleInput = consoleInput;
        this.library = library;
    }

    @Override
    public String execute() {
        String bookName = askForBookName();
        library.checkOut(bookName);
        return CONTINUE;
    }

    private String askForBookName() {
        outputTemplate.addToBody(library.availableBooks());
        outputTemplate.addToFooter(CHECKOUT_MESSAGE);
        outputTemplate.renderOutput();
        return consoleInput.getUserInput();
    }
}
