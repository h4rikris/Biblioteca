package com.tw.pathashala.models;

import com.tw.pathashala.constants.Constants;
import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.InvalidOption;
import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.menu.Quit;

import java.util.HashMap;
import java.util.Map;

import static com.tw.pathashala.constants.Constants.LIST_BOOKS_OPTION;
import static com.tw.pathashala.constants.Constants.QUIT_OPTION;

public class InputParser {
    private Map<Integer, MenuAction> menuList = new HashMap<Integer, MenuAction>();
    private Library library;
    private MenuAction invalidOption;

    public InputParser(Library library, BooksList bookList, Quit quit, InvalidOption invalidOption) {
        this.library = library;
        this.invalidOption = invalidOption;
        menuList.put(LIST_BOOKS_OPTION, bookList);
        menuList.put(QUIT_OPTION, quit);
    }

    public void addOption(Integer menuOption, MenuAction action) {
        menuList.put(menuOption, action);
    }

    public Map<Integer, MenuAction> menuList() {
        return menuList;
    }

    public MenuAction chooseOption(String menuOption) {
        Integer option = convertToInteger(menuOption);
        if(menuList.containsKey(option))
            return menuList.get(option);
        return invalidOption;
    }

    private int convertToInteger(String menuOption) {
        return Integer.parseInt(menuOption);
    }

}
