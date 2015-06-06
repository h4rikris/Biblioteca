package com.tw.pathashala.models;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> menuList = new ArrayList<String>();

    public Menu() {
        menuList.add("List Books");
        menuList.add("Quit");
    }

    public void addItem(String menuItem) {
        menuList.remove(menuList.size()-1);
        menuList.add(menuItem);
        menuList.add("Quit");
    }

    public ArrayList<String> getMenuList() {
        return menuList;
    }
}
