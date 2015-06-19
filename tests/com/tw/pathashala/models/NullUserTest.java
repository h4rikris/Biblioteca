package com.tw.pathashala.models;

import com.tw.pathashala.constants.Constants;
import org.junit.Test;

import static com.tw.pathashala.constants.Constants.NULL_USER;
import static org.junit.Assert.assertEquals;

public class NullUserTest {

    @Test
    public void shouldHaveNullUserRole() {
        NullUser nullUser = new NullUser();

        Integer role = nullUser.getRole();

        assertEquals(NULL_USER, role);
    }

}