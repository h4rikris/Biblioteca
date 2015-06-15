package com.tw.pathashala.view;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ConsoleInputTest {
    private ByteArrayInputStream inputContent;

    @Before
    public void setUp() {
        inputContent = new ByteArrayInputStream("Hello".getBytes());
        System.setIn(inputContent);
    }

    @Test
    public void shouldAbleToGetInputFromConsole() {
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));

        String input = consoleInput.getUserInput();

        assertEquals("Hello", input);
    }
}