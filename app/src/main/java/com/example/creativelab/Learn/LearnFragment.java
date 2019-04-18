package com.example.creativelab.Learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.creativelab.Learn.Lesson.LessonActivity;
import com.example.creativelab.Learn.Lesson.TestActivity;
import com.example.creativelab.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class LearnFragment extends Fragment {
    RecyclerView verticalRVParent;
    VerticalAdapter verticalAdapter;
    private ArrayList<Learn> learnArrayList;

    String jsonString = "{\"Lesson info\":[\n" +
            "\t{\"editor\":\"Photoshop\",\"lessons\":[\n" +
            "\t\t{\"lessonId\":\"L1\",\"lessonName\":\"PS 1\"},\n" +
            "\t\t{\"lessonId\":\"L2\",\"lessonName\":\"PS 2\"},\n" +
            "\t\t{\"lessonId\":\"L3\",\"lessonName\":\"PS 3\"},\n" +
            "\t\t{\"lessonId\":\"T1\",\"lessonName\":\"PS Test\"}]},\n" +
            "\t{\"editor\":\"Illustrator\",\"lessons\":[\n" +
            "\t\t{\"lessonId\":\"L4\",\"lessonName\":\"IL 1\"},\n" +
            "\t\t{\"lessonId\":\"L5\",\"lessonName\":\"IL 2\"},\n" +
            "\t\t{\"lessonId\":\"L6\",\"lessonName\":\"IL 3\"},\n" +
            "\t\t{\"lessonId\":\"T2\",\"lessonName\":\"IL Test\"}]},\n" +
            "\t{\"editor\":\"InDesign\",\"lessons\":[\n" +
            "\t\t{\"lessonId\":\"L7\",\"lessonName\":\"ID 1\"},\n" +
            "\t\t{\"lessonId\":\"L8\",\"lessonName\":\"ID 2\"},\n" +
            "\t\t{\"lessonId\":\"L9\",\"lessonName\":\"ID 3\"},\n" +
            "\t\t{\"lessonId\":\"T3\",\"lessonName\":\"ID Test\"}]},\n" +
            "\t{\"editor\":\"Lightroom\",\"lessons\":[\n" +
            "\t\t{\"lessonId\":\"L10\",\"lessonName\":\"LR 1\"},\n" +
            "\t\t{\"lessonId\":\"L11\",\"lessonName\":\"LR 2\"},\n" +
            "\t\t{\"lessonId\":\"L12\",\"lessonName\":\"LR 3\"},\n" +
            "\t\t{\"lessonId\":\"T4\",\"lessonName\":\"LR Test\"}]},\n" +
            "\t{\"editor\":\"Premiere Pro\",\"lessons\":[\n" +
            "\t\t{\"lessonId\":\"L13\",\"lessonName\":\"PP 1\"},\n" +
            "\t\t{\"lessonId\":\"L14\",\"lessonName\":\"PP 2\"},\n" +
            "\t\t{\"lessonId\":\"L15\",\"lessonName\":\"PP 3\"},\n" +
            "\t\t{\"lessonId\":\"T5\",\"lessonName\":\"PP Test\"}]},\n" +
            "\t{\"editor\":\"After Effects\",\"lessons\":[\n" +
            "\t\t{\"lessonId\":\"L16\",\"lessonName\":\"AE 1\"},\n" +
            "\t\t{\"lessonId\":\"L17\",\"lessonName\":\"AE 2\"},\n" +
            "\t\t{\"lessonId\":\"L18\",\"lessonName\":\"AE 3\"},\n" +
            "\t\t{\"lessonId\":\"T6\",\"lessonName\":\"AE Test\"}]}\n" +
            "\t\t]};\t";

    ArrayList<LearnLessons> learnLessonsArrayList;
    LearnInformation learnInformation = new LearnInformation();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_learn, container, false);

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonLessonsArray = jsonObject.getJSONArray("Lesson info");
            learnLessonsArrayList = new ArrayList<>();
            for (int i = 0; i <jsonLessonsArray.length(); i++){
                LearnLessons learnLessons = new LearnLessons();
                JSONObject jsonEditorobject = jsonLessonsArray.getJSONObject(i);
                String editor = jsonEditorobject.getString("editor");
                learnLessons.setEditor(editor);
                JSONArray jsonArraylessons = jsonEditorobject.getJSONArray("lessons");
                ArrayList<Learn> learnArrayList = new ArrayList<>();
                for (int j = 0; j < jsonArraylessons.length(); j++){
                    Learn learn = new Learn();
                    JSONObject eventObj = jsonArraylessons.getJSONObject(j);
                    learn.setLessonId(eventObj.getString("lessonId"));
                    learn.setLessonName(eventObj.getString("lessonName"));
                    learnArrayList.add(learn);
                }
                learnLessons.setLessons(learnArrayList);
                learnLessonsArrayList.add(learnLessons);
            }
            learnInformation.setLearnLessonsList(learnLessonsArrayList);
            Log.d("message",learnInformation.toString());
        }catch (Exception e){

        }

        verticalRVParent = rootView.findViewById(R.id.verticalRVParent);
        verticalAdapter = new VerticalAdapter(learnInformation, this.getContext());
        verticalRVParent.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false);
        verticalRVParent.setLayoutManager(mLayoutManager);
        verticalRVParent.setAdapter(verticalAdapter);

        return rootView;
    }

}


/*


            holder.lessonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (learn.getLessonId().contains("T")) {
                        Intent intent = new Intent(mContext, TestActivity.class);
                        intent.putExtra("position", position);
                        mContext.startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(mContext, LessonActivity.class);
                        intent.putExtra("position", position);
                        mContext.startActivity(intent);
                    }
                    Toast.makeText(mContext, learn.getLessonName(), Toast.LENGTH_SHORT).show();
                }
            });
 */