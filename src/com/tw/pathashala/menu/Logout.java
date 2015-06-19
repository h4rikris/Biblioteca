package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

public class Logout implements MenuAction{
    Authentication authentication;
    ConsoleOutputTemplate outputTemplate;

    public Logout(Authentication authentication, ConsoleOutputTemplate outputTemplate) {
        this.authentication = authentication;
        this.outputTemplate = outputTemplate;
    }

    @Override
    public String execute() {
        authentication.logout();
        outputTemplate.renderOutput(LOGOUT_SUCCESS_MESSAGE, LOGGEDOUT_MAIN_MENU);
        return CONTINUE;
    }
}
