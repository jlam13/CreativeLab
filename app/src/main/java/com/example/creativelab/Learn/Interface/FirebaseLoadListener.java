package com.example.creativelab.Learn.Interface;

import com.example.creativelab.Learn.Data.LearnCards;

import java.util.List;

public interface FirebaseLoadListener {
    void onFirebaseLoadSuccess(List<LearnCards> learnCardsList);
    void onFirebaseLoadFailed(String message);
}
