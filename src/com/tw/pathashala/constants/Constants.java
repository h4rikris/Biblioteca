package com.tw.pathashala.constants;

public interface Constants {
    public static final String WELCOME_MESSAGE = "Welcome to BiBlioteca";
    public static final String INVALID_OPTION_MESSAGE = "Select a Valid Option";

    public static final String STOP = "STOP";
    public static final String CONTINUE = "CONTINUE";
    public static final boolean CHECKEDOUT = true;
    public static final boolean CHECKEDIN = false;
    public static final boolean SUCCESS = true;
    public static final boolean FAILED = false;

    public static final String FORMAT = "| %-41s | %-41s | %-8s |";

    public static final String MAIN_MENU = "1) List Books\n2) Checkout\n3) Return Book\n4) Quit\nEnter Your Option:";
    public static final Integer LIST_BOOKS_OPTION = 1;
    public static final Integer CHECKOUT_OPTION = 2;
    public static final Integer RETURN_OPTION = 3;
    public static final Integer QUIT_OPTION = 4;
    public static final String CHECKOUT_MESSAGE = "Enter Book Name:";
    public static final String CHECKOUT_INVALID_MESSAGE = "That Book is not available.";
    public static final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the Book.";
    public static final String RETURN_MESSAGE = "Enter Book Name To Return:";
    public static final String RETURN_SUCCESS_MESSAGE = "Thank you for returning the Book.";
    public static final String RETURN_FAIL_MESSAGE = "That is not a valid Book return.";
    public static final String NO_CHECKEDOUT_BOOK_DETAILS_ARE_FOUND = "No Checkedout Book details are Found";
    public static final String NO_BOOK_DETAILS_ARE_FOUND = "No Book details are Found";
}
