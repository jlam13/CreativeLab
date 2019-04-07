package com.example.creativelab;

import java.util.ArrayList;

public class LearnData {
    private String difficulty;
    private int learnID;
    private int testID;


    public LearnData(){}

    public LearnData(String difficulty, int learnID, int testID) {
        this.difficulty = difficulty;
        this.learnID = learnID;
        this.testID = testID;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getLearnID() {
        return learnID;
    }

    public void setLearnID(int learnID) {
        this.learnID = learnID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public static ArrayList<LearnData> getLearnData() {
        ArrayList<LearnData> learnData = new ArrayList<>();
        learnData.add(new LearnData("Beginner", 1, 1));
        learnData.add(new LearnData("Intermediate", 2, 2));
        learnData.add(new LearnData("Advanced", 3, 3));

        return learnData;
    }
}
