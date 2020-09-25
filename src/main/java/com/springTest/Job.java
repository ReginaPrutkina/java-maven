package com.springTest;

public class Job {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Job{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
