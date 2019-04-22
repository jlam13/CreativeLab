package com.example.creativelab.learn.test;

public class QuestionLibrary {

    private String questions [] = {
            "What does 1 + 1 equal?",
            "What does 4 x 4 equal?",
            "What does 4 / 2 equal?",
            "What does 8 - 3 equal?" };

    private String choices [][] = {
            {"1", "2"},
            {"16", "67"},
            {"2", "3"},
            {"5", "52"}};

    private String correct [] = {
            "2", "16", "2", "5"};


    public String getQuestion(int a) {
        String question = questions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice1 = choices[a][0];
        return choice1;
    }

    public String getChoice2(int a) {
        String choice2 = choices[a][1];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = correct[a];
        return answer;
    }


}

