package com.example.creativelab.learn.test;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name, email;
    public List<Results> result;

    public User(String name, String email, List<Results> result) {
        this.name = name;
        this.email = email;
        this.result = result;
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

    public List<Results> getResult() {
        return result;
    }

    public void setResult(List<Results> result) {
        this.result = result;
    }
}