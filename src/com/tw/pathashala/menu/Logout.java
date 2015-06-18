package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;

import static com.tw.pathashala.constants.Constants.CONTINUE;

public class Logout implements MenuAction{
    Authentication authentication;

    public Logout(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public String execute() {
        authentication.setCurrentLoggedInUser(null);
        return CONTINUE;
    }
}
