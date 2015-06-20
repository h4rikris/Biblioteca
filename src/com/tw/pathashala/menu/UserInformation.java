package com.tw.pathashala.menu;

import com.tw.pathashala.constants.Constants;
import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.models.User;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.CONTINUE;

public class UserInformation implements MenuAction{
    private Authentication authentication;
    private ConsoleOutputTemplate consoleOutputTemplate;

    public UserInformation(Authentication authentication, ConsoleOutputTemplate consoleOutputTemplate) {
        this.authentication = authentication;
        this.consoleOutputTemplate = consoleOutputTemplate;
    }

    @Override
    public String execute() {
        User user = authentication.getCurrentLoggedInUser();
        consoleOutputTemplate.addToBody(user.toString());
        return CONTINUE;
    }
}
