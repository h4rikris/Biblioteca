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
        outputTemplate.renderOutput(this.library.returnItem(bookName), LOGGEDIN_MAIN_MENU);
        return CONTINUE;
    }

    private String askForBookName() {
        outputTemplate.renderOutput(library.checkedOutItems(), BOOK_RETURN_PROMPT_MESSAGE);
        return consoleInput.getUserInput();
    }
}
