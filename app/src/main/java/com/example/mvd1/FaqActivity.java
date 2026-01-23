package com.example.mvd1;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        ExpandableListView expandableListView = findViewById(R.id.faq_list);

        AppData data = JsonLoader.loadFromAsset(this);
        if (data == null) return;

        List<String> questions = new ArrayList<>();
        HashMap<String, String> answers = new HashMap<>();

        for (FaqItem item : data.getFaq()) {
            questions.add(item.getQuestion());
            answers.put(item.getQuestion(), item.getAnswer());
        }

        FaqExpandableAdapter adapter = new FaqExpandableAdapter(this, questions, answers);
        expandableListView.setAdapter(adapter);
    }
}
