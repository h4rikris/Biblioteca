package com.tw.pathashala.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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

    @Test
    public void testToCheckTwosAreEqual() {
        User first = new User("hari", "password");
        User second = new User("hari", "password");

        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    public void reflexiveTestFor() {
        User first = new User("hari", "password");
        User second = new User("hari", "password");

        boolean expected = first.equals(second);

        assertTrue(expected);
    }

    @Test
    public void symmetricTestFor() {
        User first = new User("hari", "password");
        User second = new User("hari", "password");

        boolean actual = first.equals(second);
        actual = actual && second.equals(first);

        boolean expected = true;

        assertThat(actual, is(expected));
    }

    @Test
    public void trasitiveTestFor() {
        User first = new User("hari", "password");
        User second = new User("hari", "password");
        User third = new User("hari", "password");

        boolean actual = first.equals(second);
        actual = actual && second.equals(third);
        actual = actual && third.equals(first);
        boolean expected = true;

        assertThat(actual, is(expected));
    }

    @Test
    public void nullComparisonTestFor() {
        User first = new User("hari", "password");
        User second = null;

        boolean actual = first.equals(second);
        boolean expected = false;

        assertThat(actual, is(expected));
    }
}