package com.example.creditapp.model;

public class ApplicationDetails extends ApplicationRequest {
    private String applicationId;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}