package com.example.wuzzufjavaproject.model;

import java.util.ArrayList;

public class Jobs {
    private String title;
    private String company;
    private String location;
    private String type;
    private String level;
    private String YearsOfExperience;
    private String Country;
    private String Skills;

    public Jobs(String title, String company, String location, String type, String level, String yearsOfExperience, String country, String skills) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.type = type;
        this.level = level;
        YearsOfExperience = yearsOfExperience;
        Country = country;
        Skills = skills;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public String getYearsOfExperience() {
        return YearsOfExperience;
    }

    public String getCountry() {
        return Country;
    }

    public String getSkills() {
        return Skills;
    }
}
