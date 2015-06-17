package com.tw.pathashala.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldTrueOnCorrectCredentials() {
        User user = new User("hari", "pass");

        boolean actual = user.checkCredentials("hari", "pass");

        assertEquals(true, actual);
    }

    @Test
    public void shouldFalseOnInCorrectCredentials() {
        User user = new User("hari", "pass");

        boolean actual = user.checkCredentials("hari", "passaa");

        assertEquals(false, actual);
    }
}