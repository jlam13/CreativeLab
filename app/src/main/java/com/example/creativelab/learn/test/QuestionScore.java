package com.example.creativelab.learn.test;

public class QuestionScore {
    private String questionScore;
    private String User;
    private String Score;

    public QuestionScore() {}

    public QuestionScore(String questionScore, String user, String score) {
        this.questionScore = questionScore;
        User = user;
        Score = score;
    }

    public String getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(String questionScore) {
        this.questionScore = questionScore;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }
}
