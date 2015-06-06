package com.tw.pathashala.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConsoleOutputTemplateTest {

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void testForDivider() {
        ConsoleOutputTemplate template = new ConsoleOutputTemplate();
        String divider = template.divider(100);
        String expectdDivider = "------------------------------------------------------------------------------------" +
                "----------------\n";

        assertThat(divider, is(expectdDivider));
    }

    @Test
    public void testForTemplateToIncludeBodyMessageOrNot() {
        ConsoleOutputTemplate template = new ConsoleOutputTemplate();

        template.addToBody("Welcome");
        template.renderOutput();
        String actual = outputContent.toString();

        assertTrue(actual.contains("Welcome"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

}