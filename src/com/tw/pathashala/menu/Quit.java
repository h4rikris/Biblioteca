package com.tw.pathashala.menu;

import static com.tw.pathashala.constants.Constants.STOP;

public class Quit implements MenuAction {

    @Override
    public String execute() {
        return STOP;
    }
}
