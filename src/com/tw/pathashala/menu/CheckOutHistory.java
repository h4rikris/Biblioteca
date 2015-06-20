package com.tw.pathashala.menu;

import com.tw.pathashala.models.UserHistory;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static com.tw.pathashala.constants.Constants.LOGGEDIN_MAIN_MENU;

public class CheckOutHistory implements MenuAction{
    private UserHistory userHistory;
    private ConsoleOutputTemplate consoleOutputTemplate;

    public CheckOutHistory(UserHistory userHistory, ConsoleOutputTemplate consoleOutputTemplate) {
        this.userHistory = userHistory;
        this.consoleOutputTemplate = consoleOutputTemplate;
    }

    @Override
    public String execute() {
        consoleOutputTemplate.addToBody(userHistory.toString());
        return CONTINUE;
    }
}
