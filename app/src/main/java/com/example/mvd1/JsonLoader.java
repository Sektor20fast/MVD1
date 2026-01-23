package com.example.mvd1;

import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import android.content.Context;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;


public class JsonLoader {
    public static AppData loadFromAsset(Context context) {
        try {
            InputStream is = context.getAssets().open("data.json");
            InputStreamReader reader = new InputStreamReader(is);
            Gson gson = new Gson();
            return gson.fromJson(reader, AppData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
