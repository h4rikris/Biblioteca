package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {
    ArrayList<User> users;
    User hari;
    Map<User, InputParser> userMenuMapper;

    @Before
    public void setUp() throws Exception {
        hari = new User("hari", "krishna");
        users = new ArrayList<User>();
        users.add(hari);
        users.add(new User("sourav", "cr"));
        userMenuMapper = new HashMap<>();
    }

    @Test
    public void shouldReturnUserIfCredentialsMatches() {
        Authenticator auth = new Authenticator(users, userMenuMapper);

        User actualUser = auth.authenticate("hari", "krishna");

        assertEquals(hari, actualUser);
    }

}