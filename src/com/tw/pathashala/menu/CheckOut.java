package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

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
        if (library.checkOut(bookName)) {
            outputTemplate.addToBody(CHECKOUT_SUCCESS_MESSAGE);
        } else {
            outputTemplate.addToBody(CHECKOUT_INVALID_MESSAGE);
        }
        outputTemplate.addToFooter(MAIN_MENU);
        outputTemplate.renderOutput();
        return CONTINUE;
    }

    private String askForBookName() {
        outputTemplate.addToBody(library.availableItems());
        outputTemplate.addToFooter(CHECKOUT_MESSAGE);
        outputTemplate.renderOutput();
        return consoleInput.getUserInput();
    }
}
