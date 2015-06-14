package com.tw.pathashala.menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuitTest {
    @Test
    public void testForQuitDisplayShouldGiveNull() {
        Quit quit = new Quit();

        String actual = quit.execute();

        assertEquals("STOP", actual);
    }

}