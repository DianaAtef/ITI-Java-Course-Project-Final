package com.example.wuzzufjavatester;

public class JobsSummary {
    private String summary;
    private String title;
    private String company;
    private String location;
    private String type;
    private String level;
    private String yearsExp;
    private String country;
    private String skills;

    public JobsSummary(String summary, String title, String company, String location, String type, String level, String yearsExp, String country, String skills) {
        this.summary = summary;
        this.title = title;
        this.company = company;
        this.location = location;
        this.type = type;
        this.level = level;
        this.yearsExp = yearsExp;
        this.country = country;
        this.skills = skills;
    }

    public String getSummary() {
        return summary;
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

    public String getYearsExp() {
        return yearsExp;
    }

    public String getCountry() {
        return country;
    }

    public String getSkills() {
        return skills;
    }
}
