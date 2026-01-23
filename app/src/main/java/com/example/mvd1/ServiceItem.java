package com.example.mvd1;

import java.util.List;

public class ServiceItem {
    private int id;
    private String title;
    private String description;
    private String result;
    private List<String> documents;

    // Геттеры и сеттеры
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getResult() { return result; }
    public List<String> getDocuments() { return documents; }
}
