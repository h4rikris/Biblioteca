package com.tw.pathashala.controller;

import com.tw.pathashala.menu.*;
import com.tw.pathashala.models.*;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import java.util.*;

import static com.tw.pathashala.constants.Constants.*;

public class Dependencies {

    private ConsoleOutputTemplate consoleOutputTemplate;
    private ConsoleInput consoleInput;
    private Library bookLibrary;
    private Library movieLibrary;
    private InputParser inputParser;
    private InputParser normalInputParser;
    private InputParser guestInputParser;
    private MenuMapper menuMapper;
    private UserHistory userHistory;
    private Authentication authentication;
    private Login login;

    public Dependencies() {
        consoleInput = new ConsoleInput(new Scanner(System.in));
        consoleOutputTemplate = new ConsoleOutputTemplate();
        authentication = new Authentication(userList(), new NullUser());
        userHistory = new UserHistory(authentication, getUserHistoryDetails());
        bookLibrary = new Library(availableBookDetails(), new ArrayList<RentableItem>(), new Search(), userHistory);
        movieLibrary = new Library(availableMovieDetails(), new ArrayList<RentableItem>(), new Search(), userHistory);
        login = new Login(consoleInput, consoleOutputTemplate, authentication);
        inputParser = new InputParser(createMenuForLibrarian(), new InvalidOption(consoleOutputTemplate));
        normalInputParser = new InputParser(createMenuForNormalUser(), new InvalidOption(consoleOutputTemplate));
        guestInputParser = new InputParser(createMenuForGuestUser(), new InvalidOption(consoleOutputTemplate));
        menuMapper = new MenuMapper(authentication, roleMenuMapperDetails());
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

    public MenuMapper getMenuMapper() {
        return menuMapper;
    }

    public Map<Integer, InputParser> getUserMenuMapperList() {
        return roleMenuMapperDetails();
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

    private Map<String, MenuAction> createMenuForLibrarian() {
        Map<String, MenuAction> menuList = new LinkedHashMap<>();
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

    private Map<String, MenuAction> createMenuForNormalUser() {
        Map<String, MenuAction> menuList = new LinkedHashMap<>();
        menuList.put(BOOKS_LIST_OPTION, new ListOutItems(bookLibrary, consoleOutputTemplate));
        menuList.put(BOOKS_CHECKOUT_OPTION, new CheckOutBook(consoleOutputTemplate, consoleInput, bookLibrary));
        menuList.put(BOOKS_RETURN_OPTION, new ReturnBook(consoleOutputTemplate, consoleInput, bookLibrary));
        menuList.put(MOVIE_LIST_OPTION, new ListOutItems(movieLibrary, consoleOutputTemplate));
        menuList.put(MOVIE_CHECKOUT_OPTION, new CheckOutBook(consoleOutputTemplate, consoleInput, movieLibrary));
        menuList.put(MOVIE_RETURN_OPTION, new ReturnBook(consoleOutputTemplate, consoleInput, movieLibrary));
        menuList.put(LOGOUT_OPTION, new Logout(authentication, consoleOutputTemplate));
        return menuList;
    }

    private Map<String, MenuAction> createMenuForGuestUser() {
        Map<String, MenuAction> menuList = new LinkedHashMap<>();
        menuList.put(BOOKS_LIST_OPTION, new ListOutItems(bookLibrary, consoleOutputTemplate));
        menuList.put(BOOKS_CHECKOUT_OPTION, login);
        menuList.put(BOOKS_RETURN_OPTION, login);
        menuList.put(MOVIE_LIST_OPTION, new ListOutItems(movieLibrary, consoleOutputTemplate));
        menuList.put(MOVIE_CHECKOUT_OPTION, login);
        menuList.put(MOVIE_RETURN_OPTION, login);
        menuList.put(LOGIN_OPTION, login);
        return menuList;
    }

    private ArrayList<User> userList() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("normal", "krishna", NORMAL_USER));
        users.add(new User("admin", "password", LIBRARIAN));
        users.add(new NullUser());
        return users;
    }

    private Map<Integer, InputParser> roleMenuMapperDetails() {
        Map<Integer, InputParser> roleMap = new HashMap<>();
        roleMap.put(NULL_USER, guestInputParser);
        roleMap.put(LIBRARIAN, inputParser);
        roleMap.put(NORMAL_USER, normalInputParser);
        return roleMap;
    }

    public UserHistory getUserHistory() {
        return userHistory;
    }

    private Map<User, ArrayList<RentableItem>> getUserHistoryDetails() {
        Map<User, ArrayList<RentableItem>> userList = new HashMap<>();
        userList.put(userList().get(0), new ArrayList<RentableItem>());
        userList.put(userList().get(1), new ArrayList<RentableItem>());
        userList.put(userList().get(2), new ArrayList<RentableItem>());
        return userList;
    }
}