package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.tw.pathashala.constants.Constants.LIBRARIAN;
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
        Authentication auth = new Authentication(users);

        Boolean actualResult = auth.authenticate("hari", "krishna");

        assertTrue(actualResult);
    }

}