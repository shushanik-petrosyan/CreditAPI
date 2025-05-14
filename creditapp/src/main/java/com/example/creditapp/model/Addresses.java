package com.example.creditapp.model;

public class Addresses {
    private String residenceAddress;
    private String registrationAddress;

    public Addresses() {
    }

    public Addresses(String residenceAddress, String registrationAddress) {
        this.residenceAddress = residenceAddress;
        this.registrationAddress = registrationAddress;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "residenceAddress='" + residenceAddress + '\'' +
                ", registrationAddress='" + registrationAddress + '\'' +
                '}';
    }
}
