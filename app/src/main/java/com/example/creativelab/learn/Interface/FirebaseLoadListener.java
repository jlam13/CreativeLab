package com.example.creativelab.learn.Interface;

import com.example.creativelab.learn.data.LearnCards;

import java.util.List;

// Firebase reference - https://www.youtube.com/watch?v=K2FSLZzYnnQ
public interface FirebaseLoadListener {
    void onFirebaseLoadSuccess(List<LearnCards> learnCardsList);
    void onFirebaseLoadFailed(String message);
}