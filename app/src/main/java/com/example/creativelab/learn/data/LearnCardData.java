package com.example.creativelab.learn.data;

public class LearnCardData {
    private String learnCardId, learnCardName, youtubeId;

    public LearnCardData() {

    }

    public LearnCardData(String learnCardId, String learnCardName, String youtubeId) {
        this.learnCardId = learnCardId;
        this.learnCardName = learnCardName;
        this.youtubeId = youtubeId;
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

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }
}
