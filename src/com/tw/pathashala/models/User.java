package com.tw.pathashala.models;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Boolean checkCredentials(String userName, String password) {
        return (this.userName.equals(userName) && this.password.equals(password));
    }
}
