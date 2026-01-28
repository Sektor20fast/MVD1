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


        name.setText(office.getName());
        address.setText(office.getAddress());
        hours.setText(office.getWorkHours());
        phone.setText(office.getPhone());


        findViewById(R.id.btn_call).setOnClickListener(v -> {
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + office.getPhone()));
            startActivity(call);
        });

        findViewById(R.id.btn_map).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:56.8733359089947, 35.900520009468636"));
            startActivity(intent);

        });
    }
}
