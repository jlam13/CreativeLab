package com.example.creativelab.learn.test.data;

public class QuestionsObsolete {
    private String question, answerA, answerB, correctAnswer, learnCardId;

    public QuestionsObsolete() {}

    public QuestionsObsolete(String question, String answerA, String answerB, String correctAnswer, String learnCardId) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.correctAnswer = correctAnswer;
        this.learnCardId = learnCardId;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getLearnCardId() {
        return learnCardId;
    }

    public void setLearnCardId(String learnCardId) {
        this.learnCardId = learnCardId;
    }
}
