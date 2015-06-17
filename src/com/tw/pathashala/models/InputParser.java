package com.tw.pathashala.models;

import com.tw.pathashala.menu.*;

import java.util.HashMap;
import java.util.Map;

import static com.tw.pathashala.constants.Constants.*;

public class InputParser {
    private Map<Integer, MenuAction> menuList = new HashMap<Integer, MenuAction>();
    private Library library;
    private MenuAction invalidOption;

    public InputParser(Library bookLibrary, BooksList bookList, Quit quit, InvalidOption invalidOption, CheckOutBook checkOutBook, ReturnBook returnBook) {
        this.library = bookLibrary;
        this.invalidOption = invalidOption;
        menuList.put(LIST_BOOKS_OPTION, bookList);
        menuList.put(CHECKOUT_OPTION, checkOutBook);
        menuList.put(RETURN_OPTION, returnBook);
        menuList.put(QUIT_OPTION, quit);

    }

    public void addOption(Integer menuOption, MenuAction action) {
        menuList.put(menuOption, action);
    }

    public Map<Integer, MenuAction> menuList() {
        return menuList;
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
