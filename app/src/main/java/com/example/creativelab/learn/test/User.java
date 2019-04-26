package com.example.creativelab.learn.test;

public class User {
    public String name, email;
    public int total;

    public User() {}

    public User(String name, String email, int total) {
        this.name = name;
        this.email = email;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}