package com.example.creativelab.learn.Interface;

import com.example.creativelab.learn.data.LearnCards;

import java.util.List;

public interface FirebaseLoadListener {
    void onFirebaseLoadSuccess(List<LearnCards> learnCardsList);
    void onFirebaseLoadFailed(String message);
}