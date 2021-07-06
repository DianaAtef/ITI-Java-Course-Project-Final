package com.example.wuzzufjavaproject.model;

public class JobsFactorized {
    String minYears;
    String maxYears;

    public JobsFactorized(String minYears, String maxYears) {
        this.minYears = minYears;
        this.maxYears = maxYears;
    }

    public String getMinYears() {
        return minYears;
    }

    public String getMaxYears() {
        return maxYears;
    }
}
