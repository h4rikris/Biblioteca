package com.tw.pathashala.models;

import org.junit.Test;

import static com.tw.pathashala.constants.Constants.LIBRARIAN;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldTrueOnCorrectCredentials() {
        User user = new User("hari", "pass", 1, null, null, null);

        boolean actual = user.checkCredentials("hari", "pass");

        assertEquals(true, actual);
    }

    @Test
    public void shouldFalseOnInCorrectCredentials() {
        User user = new User("hari", "pass", 1, null, null, null);

        boolean actual = user.checkCredentials("hari", "passaa");

        assertEquals(false, actual);
    }

    @Test
    public void testToCheckTwosAreEqual() {
        User first = new User("hari", "password", 1, null, null, null);
        User second = new User("hari", "password", 1, null, null, null);

        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    public void reflexiveTestForUser() {
        User first = new User("hari", "password", 1, null, null, null);
        User second = new User("hari", "password", 1, null, null, null);

        boolean expected = first.equals(second);

        assertTrue(expected);
    }

    @Test
    public void symmetricTestForUser() {
        User first = new User("hari", "password", 1, null, null, null);
        User second = new User("hari", "password", 1, null, null, null);

        boolean actual = first.equals(second);
        actual = actual && second.equals(first);

        assertThat(actual, is(true));
    }

    @Test
    public void trasitiveTestForUser() {
        User first = new User("hari", "password", 1, null, null, null);
        User second = new User("hari", "password", 1, null, null, null);
        User third = new User("hari", "password", 1, null, null, null);

        boolean actual = first.equals(second);
        actual = actual && second.equals(third);
        actual = actual && third.equals(first);
        boolean expected = true;

        assertThat(actual, is(expected));
    }

    @Test
    public void nullComparisonTestForUser() {
        User first = new User("hari", "password", 1, null, null, null);
        User second = null;

        boolean actual = first.equals(second);
        boolean expected = false;

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldDisplayUsernameAndContactDetailsForUserToString() {
        User first = new User("hari", "password", 1, null, "9618228649", "harikris@thoughtworks.com");

        String name = first.toString();

        assertEquals("hari-9618228649-harikris@thoughtworks.com", name);
    }

    @Test
    public void shouldReturnRoleOfUser() {
        User user = new User("hari", "password", LIBRARIAN, null, null, null);

        Integer role = user.getRole();

        assertEquals(LIBRARIAN, role);
    }
}