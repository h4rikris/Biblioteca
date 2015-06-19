package com.tw.pathashala.models;

public class User {
    private String userName;
    private String password;
    private Integer role;

    public User(String userName, String password, Integer role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Boolean checkCredentials(String userName, String password) {
        return (this.userName.equals(userName) && this.password.equals(password));
    }

    public Integer getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return userName;
    }
}
