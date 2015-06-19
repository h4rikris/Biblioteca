package com.tw.pathashala.constants;

public interface Constants {
    public static final String WELCOME_MESSAGE = "Welcome to BiBlioteca";
    public static final String INVALID_OPTION_MESSAGE = "Select a Valid Option";

    public static final String STOP = "STOP";
    public static final String CONTINUE = "CONTINUE";

    public static final String BOOK_FORMAT = "| %-41s | %-41s | %-8s |";
    public static final String MOVIE_FORMAT = "| %-39s | %-38s | %-8s | %-2s |";

    public static final String LOGGEDIN_MAIN_MENU = "1) List Books\n2) Checkout\n3) Return Book\n" +
            "4) List Movies\n5) Checkout Movie\n6) Return Movie\n7) CheckOut History\n8) Logout\n9) Quit\nEnter Your Option:";
    public static final String LOGGEDOUT_MAIN_MENU = "1) List Books\n2) Checkout\n3) Return Book\n" +
            "4) List Movies\n5) Checkout Movie\n6) Return Movie\n7) Checkout History\n8) Login\n9) Quit\nEnter Your Option:";
    public static final Integer BOOKS_LIST_OPTION = 1;
    public static final Integer BOOKS_CHECKOUT_OPTION = 2;
    public static final Integer BOOKS_RETURN_OPTION = 3;
    public static final Integer MOVIE_LIST_OPTION = 4;
    public static final Integer MOVIE_CHECKOUT_OPTION = 5;
    public static final Integer MOVIE_RETURN_OPTION = 6;
    public static final Integer USER_HISTORY_OPTION = 7;
    public static final Integer LOGIN_OPTION = 8;
    public static final Integer LOGOUT_OPTION = 8;
    public static final Integer QUIT_OPTION = 9;
    public static final String CHECKOUT_MESSAGE = "Enter Book Name:";
    public static final String BOOK_CHECKOUT_INVALID_MESSAGE = "That Book is not available.";
    public static final String BOOK_CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the Book.";
    public static final String BOOK_RETURN_PROMPT_MESSAGE = "Enter Book Name To Return:";
    public static final String BOOK_RETURN_SUCCESS_MESSAGE = "Thank you for returning the Book.";
    public static final String BOOK_RETURN_FAIL_MESSAGE = "That is not a valid Book return.";
    public static final String MOVIE_CHECKOUT_INVALID_MESSAGE = "That Movie is not available.";
    public static final String MOVIE_CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the Movie.";
    public static final String MOVIE_RETURN_PROMPT_MESSAGE = "Enter Movie Name To Return:";
    public static final String MOVIE_RETURN_SUCCESS_MESSAGE = "Thank you for returning the Movie.";
    public static final String MOVIE_RETURN_FAIL_MESSAGE = "That is not a valid Movie return.";
    public static final String NO_CHECKEDOUT_BOOK_DETAILS_ARE_FOUND = "No Checkedout Book details are Found";
    public static final String NO_ITEMS_DETAILS_ARE_FOUND = "No Item details are Found";
    public static final String LOGOUT_SUCCESS_MESSAGE = "Successfully logged out.";
}
