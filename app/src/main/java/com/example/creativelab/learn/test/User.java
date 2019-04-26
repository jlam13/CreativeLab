package com.example.creativelab.learn.test;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name, email;
    public List<Results> result;
    public int points;

    public User() {}

    public User(String name, String email, List<Results> result, int points) {
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}