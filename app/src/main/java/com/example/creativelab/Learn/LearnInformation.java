package com.example.creativelab.Learn;

import java.util.ArrayList;

public class LearnInformation {
    private ArrayList<LearnLessons> learnLessonsList = new ArrayList<>();

    public ArrayList<LearnLessons> getLearnLessonsList() {
        return learnLessonsList;
    }

    public void setLearnLessonsList(ArrayList<LearnLessons> learnLessonsList) {
        this.learnLessonsList = learnLessonsList;
    }
}
