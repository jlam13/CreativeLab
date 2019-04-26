package com.example.creativelab.learn.test;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name, email, points;
    public List<Results> result;

    public User() {}

    public User(String name, String email, List<Results> result, String points) {
        this.name = name;
        this.email = email;
        this.result = result;
        this.points = points;
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

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}