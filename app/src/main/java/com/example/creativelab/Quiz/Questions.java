package com.example.creativelab.Quiz;

public class Questions {
    private String question, answerA, answerB, answerC, answerD, correctanswer, suiteid;

    public Questions() {
    }

    public Questions(String question, String answerA, String answerB, String answerC, String answerD, String correctanswer, String suiteid) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctanswer = correctanswer;
        this.suiteid = suiteid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    public String getSuiteid() {
        return suiteid;
    }

    public void setSuiteid(String suiteid) {
        this.suiteid = suiteid;
    }
}
