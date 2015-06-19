package com.tw.pathashala.models;

import com.tw.pathashala.constants.Constants;

import static com.tw.pathashala.constants.Constants.NULL_USER;

public class NullUser extends User{

    public NullUser(String userName, String password, Integer role) {
        super(userName, password, NULL_USER);
    }
}
