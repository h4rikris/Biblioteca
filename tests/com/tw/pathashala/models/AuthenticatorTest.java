package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {
    ArrayList<User> users;
    User hari;

    @Before
    public void setUp() throws Exception {
        hari = new User("hari", "krishna");
        users = new ArrayList<User>();
        users.add(hari);
        users.add(new User("sourav", "cr"));
    }

    @Test
    public void shouldReturnUserIfCredentialsMatches() {
        Authenticator auth = new Authenticator(users);

        User actualUser = auth.authenticate("hari", "krishna");

        assertEquals(hari, actualUser);
    }

}