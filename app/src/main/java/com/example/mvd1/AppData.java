package com.example.mvd1;

import java.util.List;

public class AppData {
    private List<ServiceItem> services;
    private OfficeInfo office;
    private List<FaqItem> faq;

    public List<ServiceItem> getServices() { return services; }
    public OfficeInfo getOffice() { return office; }
    public List<FaqItem> getFaq() { return faq; }
}