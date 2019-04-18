package com.example.creativelab.Learn.Data;

import java.util.ArrayList;

public class LearnCards {
    private String editor;
    private ArrayList<LearnCardData> learnCard;

    public LearnCards() {
    }

    public LearnCards(String editor, ArrayList<LearnCardData> learnCard) {
        this.editor = editor;
        this.learnCard = learnCard;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public ArrayList<LearnCardData> getLearnCard() {
        return learnCard;
    }

    public void setLearnCard(ArrayList<LearnCardData> learnCard) {
        this.learnCard = learnCard;
    }
}