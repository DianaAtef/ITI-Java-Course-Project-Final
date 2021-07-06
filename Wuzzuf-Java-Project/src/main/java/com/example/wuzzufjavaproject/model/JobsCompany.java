package com.example.wuzzufjavaproject.model;

public class JobsCompany {
    String category;
    String count;

    public JobsCompany(String category, String count) {
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public String getCount() {
        return count;
    }
}
