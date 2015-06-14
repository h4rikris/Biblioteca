package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

public class ReturnBook implements MenuAction {
    ConsoleOutputTemplate outputTemplate;
    ConsoleInput consoleInput;
    Library library;

    public ReturnBook(ConsoleOutputTemplate outputTemplate, ConsoleInput consoleInput, Library library) {
        this.outputTemplate = outputTemplate;
        this.consoleInput = consoleInput;
        this.library = library;
    }

    @Override
    public String execute() {
        String bookName = askForBookName();
        Boolean result = library.checkOut(bookName);
        if (result) {
            outputTemplate.addToBody(RETURN_SUCCESS_MESSAGE);
        } else {
            outputTemplate.addToBody(RETURN_FAIL_MESSAGE);
        }
        outputTemplate.addToFooter(MAIN_MENU);
        outputTemplate.renderOutput();
        return CONTINUE;
    }

    private String askForBookName() {
        outputTemplate.addToBody(library.checkedOutBooks());
        outputTemplate.addToFooter(RETURN_MESSAGE);
        outputTemplate.renderOutput();
        return consoleInput.getUserInput();
    }
}
