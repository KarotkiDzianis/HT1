package com.tat19.autotest.DAO;

public class Users {

    String name;
    String fullName;
    String password;
    String email;

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Users(String name, String fullName, String email, String password) {
        this.name = name;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Users() {

    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
