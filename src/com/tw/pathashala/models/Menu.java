package com.tw.pathashala.models;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> menuList = new ArrayList<String>();

    public Menu() {
        menuList.add("List Books");
        menuList.add("Quit");
    }

    public void addOption(String menuOption) {
        menuList.remove(menuList.size()-1);
        menuList.add(menuOption);
        menuList.add("Quit");
    }

    public ArrayList<String> menuList() {
        return menuList;
    }

    public boolean isValidOption(String menuOption) {
        return menuList.contains(menuOption);
    }
}
