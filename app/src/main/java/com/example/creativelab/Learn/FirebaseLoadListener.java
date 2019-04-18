package com.example.creativelab.Learn;

import java.util.List;

public interface FirebaseLoadListener {
    void onFirebaseLoadSuccess(List<LearnCards> learnCardsList);
    void onFirebaseLoadFailed(String message);
}
