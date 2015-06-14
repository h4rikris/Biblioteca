package com.tw.pathashala.menu;

import com.tw.pathashala.constants.Constants;

public class CheckOut implements MenuAction{
    @Override
    public String execute() {
        return Constants.CONTINUE;
    }
}
