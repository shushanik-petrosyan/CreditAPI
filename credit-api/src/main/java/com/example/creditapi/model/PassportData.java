package com.example.creditapi.model;

import java.time.LocalDate;

public class PassportData {
    private String series;
    private String number;
    private LocalDate issueDate;
    private String issuerCode;
    private String issuedBy;
    private String placeOfBirth;

    // Constructors, getters and setters
    public PassportData() {}

    public PassportData(String series, String number, LocalDate issueDate, String issuerCode, String issuedBy, String placeOfBirth) {
        this.series = series;
        this.number = number;
        this.issueDate = issueDate;
        this.issuerCode = issuerCode;
        this.issuedBy = issuedBy;
        this.placeOfBirth = placeOfBirth;
    }

    // Getters and setters...
}