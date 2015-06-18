package com.tw.pathashala.models;

import com.tw.pathashala.menu.InvalidOption;
import com.tw.pathashala.menu.MenuAction;

import java.util.Map;

public class InputParser {
    private Map<Integer, MenuAction> menuList;
    private MenuAction invalidOption;

    public InputParser(Map<Integer, MenuAction> menuList, InvalidOption invalidOption) {
        this.invalidOption = invalidOption;
        this.menuList = menuList;

    }

    public MenuAction chooseOption(String menuOption) {
        try {
            Integer option = convertToInteger(menuOption);
            if (menuList.containsKey(option))
                return menuList.get(option);
        } catch (Exception e) {
            return invalidOption;
        }
        return invalidOption;
    }

    private int convertToInteger(String menuOption) {
        return Integer.parseInt(menuOption);
    }

}
