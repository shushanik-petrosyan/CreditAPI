package com.example.creditapp.controller;

import com.example.creditapp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    private final Map<String, ApplicationDetails> applicationsDb = new ConcurrentHashMap<>();

    @PostMapping(
        value = "/application",
        produces = "application/json",
        consumes = "application/json"
    )
    public ResponseEntity<ApplicationResponse> createApplication(
            @RequestBody ApplicationRequest application) {
        
        String applicationId = "app-" + UUID.randomUUID();
        
        // Создаем новый объект ApplicationDetails
        ApplicationDetails details = new ApplicationDetails();
        
        // Копируем простые поля
        details.setClientId(application.getClientId());
        details.setFullName(application.getFullName());
        details.setBirthDate(application.getBirthDate());
        details.setGender(application.getGender());
        details.setIncomeLevel(application.getIncomeLevel());
        details.setEmploymentStatus(application.getEmploymentStatus());
        details.setMaritalStatus(application.getMaritalStatus());
        details.setHasChildren(application.isHasChildren());
        details.setRequestedAmount(application.getRequestedAmount());
        
        // Копируем вложенные объекты (важно создавать новые экземпляры)
        if (application.getPassport() != null) {
            PassportData passport = new PassportData();
            passport.setSeries(application.getPassport().getSeries());
            passport.setNumber(application.getPassport().getNumber());
            passport.setIssueDate(application.getPassport().getIssueDate());
            passport.setIssuerCode(application.getPassport().getIssuerCode());
            passport.setIssuedBy(application.getPassport().getIssuedBy());
            details.setPassport(passport);
        }
        
        if (application.getContactInfo() != null) {
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setPhoneNumber(application.getContactInfo().getPhoneNumber());
            contactInfo.setEmail(application.getContactInfo().getEmail());
            details.setContactInfo(contactInfo);
        }
        
        if (application.getAddresses() != null) {
            Addresses addresses = new Addresses();
            addresses.setResidenceAddress(application.getAddresses().getResidenceAddress());
            addresses.setRegistrationAddress(application.getAddresses().getRegistrationAddress());
            details.setAddresses(addresses);
        }
        
        // Устанавливаем ID анкеты
        details.setApplicationId(applicationId);
        
        // Сохраняем в "базу данных"
        applicationsDb.put(applicationId, details);
        
        // Создаем ответ
        ApplicationResponse response = new ApplicationResponse();
        response.setApplicationId(applicationId);
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping(
        value = "/application/{applicationId}",
        produces = "application/json"
    )
    public ResponseEntity<ApplicationDetails> getApplication(
            @PathVariable String applicationId) {
        
        ApplicationDetails details = applicationsDb.get(applicationId);
        if (details == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(details);
    }
}