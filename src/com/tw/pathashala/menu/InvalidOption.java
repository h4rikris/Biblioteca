package com.tw.pathashala.menu;

import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

public class InvalidOption implements MenuAction {
    private ConsoleOutputTemplate outputTemplate;

    public InvalidOption(ConsoleOutputTemplate outputTemplate) {
        this.outputTemplate = outputTemplate;
    }

    @Override
    public String execute() {
        outputTemplate.renderOutput(INVALID_OPTION_MESSAGE, LOGGEDIN_MAIN_MENU);
        return CONTINUE;
    }
}
