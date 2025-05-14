package com.example.creditapp.model;

import java.time.LocalDate;

public class PassportData {
    private String series;
    private String number;
    private LocalDate issueDate;
    private String issuerCode;
    private String issuedBy;

    // Геттеры и сеттеры
    public String getSeries() { return series; }
    public void setSeries(String series) { this.series = series; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    public String getIssuerCode() { return issuerCode; }
    public void setIssuerCode(String issuerCode) { this.issuerCode = issuerCode; }
    public String getIssuedBy() { return issuedBy; }
    public void setIssuedBy(String issuedBy) { this.issuedBy = issuedBy; }
}