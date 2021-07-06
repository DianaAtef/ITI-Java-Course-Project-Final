package com.example.wuzzufjavaproject.model;

import java.util.ArrayList;

public class WuzzufModel {
    private String title;
    private String company;
    private String location;
    private String level;
    private Double minYearsExperience;
    private Double maxYearExperience;
    private String Country;
    private ArrayList<String> Skills;

    public WuzzufModel(String title, String company, String location, String level, Double minYearsExperience, Double maxYearExperience, String country, ArrayList<String> skills) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.level = level;
        this.minYearsExperience = minYearsExperience;
        this.maxYearExperience = maxYearExperience;
        Country = country;
        Skills = skills;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getMinYearsExperience() {
        return minYearsExperience;
    }

    public void setMinYearsExperience(Double minYearsExperience) {
        this.minYearsExperience = minYearsExperience;
    }

    public Double getMaxYearExperience() {
        return maxYearExperience;
    }

    public void setMaxYearExperience(Double maxYearExperience) {
        this.maxYearExperience = maxYearExperience;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public ArrayList<String> getSkills() {
        return Skills;
    }

    public void setSkills(ArrayList<String> skills) {
        Skills = skills;
    }

    @Override
    public String toString() {
        return "WuzzufModel{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", level='" + level + '\'' +
                ", minYearsExperience=" + minYearsExperience +
                ", maxYearExperience=" + maxYearExperience +
                ", Country='" + Country + '\'' +
                ", Skills=" + Skills +
                '}';
    }
}
