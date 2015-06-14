package com.tw.pathashala.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MessagesTest {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void testForNoWelcomeMessage() {
        Messages msg = new Messages();
        msg.displayWelcomeMessage();

        String actual = outputContent.toString();

        assertFalse(actual.equals(""));
    }

    @Test
    public void testToDisplayWelcomeMessage() {
        Messages msg = new Messages();

        msg.displayWelcomeMessage();
        String actual = outputContent.toString();

        assertTrue(actual.equals("Welcome\n"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

}