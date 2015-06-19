package com.tw.pathashala.controller;

import com.tw.pathashala.menu.*;
import com.tw.pathashala.models.*;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.tw.pathashala.constants.Constants.*;

public class Dependencies {

    private ConsoleOutputTemplate consoleOutputTemplate;
    private ConsoleInput consoleInput;
    private Library bookLibrary;
    private Library movieLibrary;
    private InputParser inputParser;
    private InputParser normalInputParser;
    private UserMenuMapper userMenuMapper;
    private UserHistory userHistory;
    private Authentication authentication;

    public Dependencies() {
        consoleInput = new ConsoleInput(new Scanner(System.in));
        consoleOutputTemplate = new ConsoleOutputTemplate();
        authentication = new Authentication(userList());
        userHistory = new UserHistory(authentication, getUserHistoryDetails());
        bookLibrary = new Library(availableBookDetails(), new ArrayList<RentableItem>(), new Search(), userHistory);
        movieLibrary = new Library(availableMovieDetails(), new ArrayList<RentableItem>(), new Search(), userHistory);
        inputParser = new InputParser(createMenu(), new InvalidOption(consoleOutputTemplate));
        normalInputParser = new InputParser(createMenuForNormal(), new InvalidOption(consoleOutputTemplate));
        userMenuMapper = new UserMenuMapper(authentication, userMenuMapperDetails());
    }

    public InputParser getInputParserInstance() {
        return inputParser;
    }

    public Authentication getAuthenticatorInstance() {
        return authentication;
    }

    public Library getLibraryInstance() {
        return bookLibrary;
    }

    public UserMenuMapper getUserMenuMapper() {
        return userMenuMapper;
    }

    public Map<User, InputParser> getUserMenuMapperList() {
        return userMenuMapperDetails();
    }

    public ConsoleInput getConsoleInputInstance() {
        return consoleInput;
    }

    public ConsoleOutputTemplate getConsoleOutputInstance() {
        return consoleOutputTemplate;
    }

    private ArrayList<RentableItem> availableBookDetails() {
        ArrayList<RentableItem> rentableItems = new ArrayList<RentableItem>();
        rentableItems.add(new AvailableBook("Pathashala", "Saurav", 2016));
        rentableItems.add(new AvailableBook("University", "Rajat", 2015));
        rentableItems.add(new AvailableBook("Refactoring", "Jashwanth", 2015));
        rentableItems.add(new AvailableBook("Object Oriented", "Venkatesh", 2014));
        return rentableItems;
    }

    private ArrayList<RentableItem> availableMovieDetails() {
        ArrayList<RentableItem> rentableItems = new ArrayList<RentableItem>();
        rentableItems.add(new AvailableMovie("Inception", "Saurav", 2016, 10));
        rentableItems.add(new AvailableMovie("Avatar", "Rajat", 2015, 9));
        rentableItems.add(new AvailableMovie("Titanic", "Jashwanth", 2015, 9));
        rentableItems.add(new AvailableMovie("AVP", "Venkatesh", 2014, 9));
        return rentableItems;
    }

    private Map<Integer, MenuAction> createMenu() {
        Map<Integer, MenuAction> menuList = new HashMap<Integer, MenuAction>();
        menuList.put(BOOKS_LIST_OPTION, new ListOutItems(bookLibrary, consoleOutputTemplate));
        menuList.put(BOOKS_CHECKOUT_OPTION, new CheckOutBook(consoleOutputTemplate, consoleInput, bookLibrary));
        menuList.put(BOOKS_RETURN_OPTION, new ReturnBook(consoleOutputTemplate, consoleInput, bookLibrary));
        menuList.put(MOVIE_LIST_OPTION, new ListOutItems(movieLibrary, consoleOutputTemplate));
        menuList.put(MOVIE_CHECKOUT_OPTION, new CheckOutBook(consoleOutputTemplate, consoleInput, movieLibrary));
        menuList.put(MOVIE_RETURN_OPTION, new ReturnBook(consoleOutputTemplate, consoleInput, movieLibrary));
        menuList.put(USER_HISTORY_OPTION, new CheckOutHistory(userHistory, consoleOutputTemplate));
        menuList.put(LOGOUT_OPTION, new Logout(authentication, consoleOutputTemplate));
        menuList.put(QUIT_OPTION, new Quit());
        return menuList;
    }

    private Map<Integer, MenuAction> createMenuForNormal() {
        Map<Integer, MenuAction> menuList = new HashMap<Integer, MenuAction>();
        menuList.put(BOOKS_LIST_OPTION, new ListOutItems(bookLibrary, consoleOutputTemplate));
        menuList.put(BOOKS_CHECKOUT_OPTION, new Login(consoleInput, consoleOutputTemplate, authentication));
        menuList.put(BOOKS_RETURN_OPTION, new Login(consoleInput, consoleOutputTemplate, authentication));
        menuList.put(MOVIE_LIST_OPTION, new ListOutItems(movieLibrary, consoleOutputTemplate));
        menuList.put(MOVIE_CHECKOUT_OPTION, new Login(consoleInput, consoleOutputTemplate, authentication));
        menuList.put(MOVIE_RETURN_OPTION, new Login(consoleInput, consoleOutputTemplate, authentication));
        menuList.put(USER_HISTORY_OPTION, new Login(consoleInput, consoleOutputTemplate, authentication));
        menuList.put(LOGIN_OPTION, new Login(consoleInput, consoleOutputTemplate, authentication));
        menuList.put(QUIT_OPTION, new Quit());
        return menuList;
    }

    private ArrayList<User> userList() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("normal", "krishna", NORMAL_USER));
        users.add(new User("admin", "password", LIBRARIAN));
        return users;
    }

    private Map<User, InputParser> userMenuMapperDetails() {
        Map<User, InputParser> userMap = new HashMap<>();
        userMap.put(new User("admin", "password", LIBRARIAN), inputParser);
        userMap.put(new User("normal", "krishna", NORMAL_USER), inputParser);
        userMap.put(null, normalInputParser);
        return userMap;
    }

    public UserHistory getUserHistory() {
        return userHistory;
    }

    private Map<User, ArrayList<RentableItem>> getUserHistoryDetails() {
        Map<User, ArrayList<RentableItem>> userList = new HashMap<>();
        userList.put(userList().get(0), new ArrayList<RentableItem>());
        userList.put(userList().get(1), new ArrayList<RentableItem>());
        return userList;
    }
}