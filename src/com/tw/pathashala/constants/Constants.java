package com.tw.pathashala.constants;

public interface Constants {
    public static final String WELCOME_MESSAGE = "Welcome to BiBlioteca";
    public static final String INVALID_OPTION_MESSAGE = "Select a Valid Option";

    public static final String STOP = "STOP";
    public static final String CONTINUE = "CONTINUE";

    public static final Integer LIBRARIAN = 1;
    public static final Integer NORMAL_USER = 2;
    public static final Integer NULL_USER = 3;


    public static final String BOOK_FORMAT = "| %-41s | %-41s | %-8s |";
    public static final String MOVIE_FORMAT = "| %-39s | %-38s | %-8s | %-2s |";

    public static final String BOOKS_LIST_OPTION = "List Books";
    public static final String BOOKS_CHECKOUT_OPTION = "Checkout";
    public static final String BOOKS_RETURN_OPTION = "Return Book";
    public static final String MOVIE_LIST_OPTION = "List Movies";
    public static final String MOVIE_CHECKOUT_OPTION = "Checkout Movie";
    public static final String MOVIE_RETURN_OPTION = "Return Movie";
    public static final String USER_HISTORY_OPTION = "Checkout History";
    public static final String LOGIN_OPTION = "Login";
    public static final String LOGOUT_OPTION = "Logout";
    public static final String USER_INFO_OPTION = "User Profile";
    public static final String QUIT_OPTION = "Quit";
    public static final String CHECKOUT_MESSAGE = "Enter Name:";
    public static final String BOOK_CHECKOUT_INVALID_MESSAGE = "That Book is not available.";
    public static final String BOOK_CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the Book.";
    public static final String BOOK_RETURN_PROMPT_MESSAGE = "Enter Name To Return:";
    public static final String BOOK_RETURN_SUCCESS_MESSAGE = "Thank you for returning the Book.";
    public static final String BOOK_RETURN_FAIL_MESSAGE = "That is not a valid Book return.";
    public static final String MOVIE_CHECKOUT_INVALID_MESSAGE = "That Movie is not available.";
    public static final String MOVIE_CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the Movie.";
    public static final String MOVIE_RETURN_SUCCESS_MESSAGE = "Thank you for returning the Movie.";
    public static final String MOVIE_RETURN_FAIL_MESSAGE = "That is not a valid Movie return.";
    public static final String NO_ITEMS_DETAILS_ARE_FOUND = "No Item details are Found";
    public static final String LOGOUT_SUCCESS_MESSAGE = "Successfully logged out.";
}
