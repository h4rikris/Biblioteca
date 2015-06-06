package com.tw.pathashala.models;

import java.util.ArrayList;

public class Menu {
    public ArrayList<String> menuList = new ArrayList<String>();

    public void addItem(String menuItem) {
        menuList.add(menuItem);
    }

}
