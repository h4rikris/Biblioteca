package com.tw.pathashala.view;

import java.util.Scanner;

public class ConsoleInput {
    Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserInput() {
        return scanner.nextLine();
    }
}
