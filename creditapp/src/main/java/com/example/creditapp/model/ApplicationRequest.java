package com.example.creditapp.model;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.UUID;

public class ApplicationRequest {
    private UUID clientId;
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private PassportData passport;
    private ContactInfo contactInfo;
    private Addresses addresses;
    private BigDecimal incomeLevel;
    private EmploymentStatus employmentStatus;
    private MaritalStatus maritalStatus;
    private boolean hasChildren;
    private BigDecimal requestedAmount;

    // Геттеры
    public UUID getClientId() { return clientId; }
    public String getFullName() { return fullName; }
    public LocalDate getBirthDate() { return birthDate; }
    public Gender getGender() { return gender; }
    public PassportData getPassport() { return passport; }
    public ContactInfo getContactInfo() { return contactInfo; }
    public Addresses getAddresses() { return addresses; }
    public BigDecimal getIncomeLevel() { return incomeLevel; }
    public EmploymentStatus getEmploymentStatus() { return employmentStatus; }
    public MaritalStatus getMaritalStatus() { return maritalStatus; }
    public boolean isHasChildren() { return hasChildren; }
    public BigDecimal getRequestedAmount() { return requestedAmount; }

    // Сеттеры
    public void setClientId(UUID clientId) { this.clientId = clientId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setPassport(PassportData passport) { this.passport = passport; }
    public void setContactInfo(ContactInfo contactInfo) { this.contactInfo = contactInfo; }
    public void setAddresses(Addresses addresses) { this.addresses = addresses; }
    public void setIncomeLevel(BigDecimal incomeLevel) { this.incomeLevel = incomeLevel; }
    public void setEmploymentStatus(EmploymentStatus employmentStatus) { this.employmentStatus = employmentStatus; }
    public void setMaritalStatus(MaritalStatus maritalStatus) { this.maritalStatus = maritalStatus; }
    public void setHasChildren(boolean hasChildren) { this.hasChildren = hasChildren; }
    public void setRequestedAmount(BigDecimal requestedAmount) { this.requestedAmount = requestedAmount; }
}