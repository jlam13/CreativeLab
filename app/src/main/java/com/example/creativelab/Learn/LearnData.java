package com.example.creativelab.Learn;

import java.util.ArrayList;

public class LearnData {
    private String editor;
    private int id;
    private String lesson1;
    private String lesson2;
    private String lesson3;
    private String test;


    public LearnData(){}

    public LearnData(String editor, int id, String lesson1, String lesson2, String lesson3, String test) {
        this.editor = editor;
        this.id = id;
        this.lesson1 = lesson1;
        this.lesson2 = lesson2;
        this.lesson3 = lesson3;
        this.test = test;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLesson1() {
        return lesson1;
    }

    public void setLesson1(String lesson1) {
        this.lesson1 = lesson1;
    }

    public String getLesson2() {
        return lesson2;
    }

    public void setLesson2(String lesson2) {
        this.lesson2 = lesson2;
    }

    public String getLesson3() {
        return lesson3;
    }

    public void setLesson3(String lesson3) {
        this.lesson3 = lesson3;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public static ArrayList<LearnData> getLearnData() {
        ArrayList<LearnData> learnData = new ArrayList<>();
        learnData.add(new LearnData("Photoshop",1, "1.1", "1.2", "1.3", "test"));
        learnData.add(new LearnData("Illustrator",2, "2.1", "2.2" , "2.3", "test"));
        learnData.add(new LearnData("After Effects",3, "2.1", "2.2" , "2.3", "test"));
        learnData.add(new LearnData("InDesign",4, "2.1", "2.2" , "2.3", "test"));
        learnData.add(new LearnData("Premiere Pro",5, "2.1", "2.2" , "2.3", "test"));
        learnData.add(new LearnData("Lightroom",6, "2.1", "2.2" , "2.3", "test"));

        return learnData;
    }
}
