package com.example.creativelab.Learn.Data;

public class LearnCardData {
    private String learnCardId, learnCardName;

    public LearnCardData() {

    }

    public LearnCardData(String learnCardId, String learnCardName) {
        this.learnCardId = learnCardId;
        this.learnCardName = learnCardName;
    }

    public String getLearnCardId() {
        return learnCardId;
    }

    public void setLearnCardId(String learnCardId) {
        this.learnCardId = learnCardId;
    }

    public String getLearnCardName() {
        return learnCardName;
    }

    public void setLearnCardName(String learnCardName) {
        this.learnCardName = learnCardName;
    }
}

