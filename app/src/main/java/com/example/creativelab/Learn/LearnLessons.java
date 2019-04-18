package com.example.creativelab.Learn;

import java.util.ArrayList;

public class LearnLessons {
    private String editor;
    private ArrayList<Learn> lessons;

    public LearnLessons() {
    }

    public LearnLessons(String editor, ArrayList<Learn> lessons) {
        this.editor = editor;
        this.lessons = lessons;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public ArrayList<Learn> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Learn> lessons) {
        this.lessons = lessons;
    }
}