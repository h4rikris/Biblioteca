package com.tw.pathashala.models;

import com.tw.pathashala.menu.InvalidOption;
import com.tw.pathashala.menu.MenuAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputParser {
    private Map<String, MenuAction> menuList;
    private MenuAction invalidOption;
    private Map<Integer, String> optionsMap;

    public InputParser(Map<String, MenuAction> menuList, InvalidOption invalidOption) {
        this.invalidOption = invalidOption;
        this.menuList = menuList;
        optionsMap = new LinkedHashMap<>();
        generateOptionsMap();
    }

    public MenuAction chooseOption(String menuOption) {
        try {
            Integer option = convertToInteger(menuOption);
            if (optionsMap.containsKey(option))
                return menuList.get(optionsMap.get(option));
        } catch (Exception e) {
            return invalidOption;
        }
        return invalidOption;
    }

    private int convertToInteger(String menuOption) {
        return Integer.parseInt(menuOption);
    }

    private void generateOptionsMap() {
        Integer optionCount = 1;
        for (String option : menuList.keySet()) {
            optionsMap.put(optionCount, option);
            optionCount++;
        }
    }
    @Override
    public String toString() {
        StringBuilder menuOutput = new StringBuilder();
        for (Integer option : optionsMap.keySet()) {
            menuOutput.append(option.toString());
            menuOutput.append(") ");
            menuOutput.append(optionsMap.get(option));
            menuOutput.append("\n");
        }
        return menuOutput.toString();
    }
}
