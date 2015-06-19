package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.tw.pathashala.constants.Constants.LIBRARIAN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthenticationTest {
    ArrayList<User> users;
    User hari;
    Map<User, InputParser> userMenuMapper;

    @Before
    public void setUp() throws Exception {
        hari = new User("hari", "krishna", LIBRARIAN);
        users = new ArrayList<User>();
        users.add(hari);
        users.add(new User("sourav", "cr", LIBRARIAN));
        userMenuMapper = new HashMap<>();
    }

    @Test
    public void shouldReturnUserIfCredentialsMatches() {
        Authentication auth = new Authentication(users, new NullUser());

        Boolean actualResult = auth.authenticate("hari", "krishna");

        assertTrue(actualResult);
    }

    @Test
    public void shouldSetNullUserOnLogout() {
        NullUser nullUser = new NullUser();
        Authentication auth = new Authentication(users, nullUser);

        auth.authenticate("hari", "krishna");
        auth.logout();
        User actualUser = auth.getCurrentLoggedInUser();

        assertEquals(nullUser, actualUser);
    }
}