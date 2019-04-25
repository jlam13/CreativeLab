package com.example.creativelab.learn.data;

public class LearnCardData {
    private String learnCardId, learnCardName, youtubeId, learnInformation;

    public LearnCardData() {

    }

    public LearnCardData(String learnCardId, String learnCardName, String youtubeId, String learnInformation) {
        this.learnCardId = learnCardId;
        this.learnCardName = learnCardName;
        this.youtubeId = youtubeId;
        this.learnInformation = learnInformation;
    }

    public String getLearnCardId() {
        return learnCardId;
    }

    public String getLearnCardName() {
        return learnCardName;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public String getLearnInformation() {
        return learnInformation;
    }
}
