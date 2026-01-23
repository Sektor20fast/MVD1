package com.example.mvd1;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ServicesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        RecyclerView recyclerView = findViewById(R.id.recycler_services);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AppData data = JsonLoader.loadFromAsset(this);
        if (data != null) {
            List<ServiceItem> services = data.getServices();
            ServicesAdapter adapter = new ServicesAdapter(services, this);
            recyclerView.setAdapter(adapter);
        }
    }
}
