package com.example.mvd1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ServiceDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);

        int serviceId = getIntent().getIntExtra("service_id", -1);
        AppData data = JsonLoader.loadFromAsset(this);
        if (data == null) return;

        ServiceItem selected = null;
        for (ServiceItem s : data.getServices()) {
            if (s.getId() == serviceId) {
                selected = s;
                break;
            }
        }

        if (selected == null) return;

        TextView title = findViewById(R.id.detail_title);
        TextView desc = findViewById(R.id.detail_description);
        TextView result = findViewById(R.id.detail_result);

        title.setText(selected.getTitle());
        desc.setText(selected.getDescription());
        result.setText("Результат: " + selected.getResult());

        ListView listView = findViewById(R.id.document_list);
        List<String> docs = new ArrayList<>(selected.getDocuments());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, docs);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
