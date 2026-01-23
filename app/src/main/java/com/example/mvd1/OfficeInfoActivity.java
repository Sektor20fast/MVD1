package com.example.mvd1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OfficeInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_info);

        AppData data = JsonLoader.loadFromAsset(this);
        if (data == null) return;

        OfficeInfo office = data.getOffice();

        TextView name = findViewById(R.id.office_name);
        TextView address = findViewById(R.id.office_address);
        TextView hours = findViewById(R.id.office_hours);
        TextView phone = findViewById(R.id.office_phone);
        TextView email = findViewById(R.id.office_email);

        name.setText(office.getName());
        address.setText(office.getAddress());
        hours.setText(office.getWorkHours());
        phone.setText(office.getPhone());
        email.setText(office.getEmail());

        findViewById(R.id.btn_call).setOnClickListener(v -> {
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + office.getPhone()));
            startActivity(call);
        });

        findViewById(R.id.btn_map).setOnClickListener(v -> {

            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(office.getAddress()));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            // Проверяем безопасно
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                // Fallback: открыть в браузере
                Uri browserUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(office.getAddress()));
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, browserUri);
                startActivity(browserIntent);
            }
        });
    }
}
