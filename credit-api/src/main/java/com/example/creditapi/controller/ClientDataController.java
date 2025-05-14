package com.example.creditapi.controller;

import com.example.creditapi.model.PersonalDataResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.creditapp.model.MaritalStatus;
import com.example.creditapp.model.EmploymentStatus;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ClientDataController {

    private final Map<UUID, PersonalDataResponse> clientsDb = new HashMap<>();

    public ClientDataController() {
        // Инициализация тестовых данных
        UUID clientId = UUID.fromString("d290f1ee-6c54-4b01-90e6-d701748f0851");
        
        // Создаем объект вручную (без Lombok)
        PersonalDataResponse clientData = new PersonalDataResponse();
        clientData.setClientId(clientId);
        clientData.setFullName("Иванов Иван Иванович");
        clientData.setGender("MALE");
        clientData.setBirthDate(LocalDate.of(1990, 1, 1));
        
        // Паспортные данные
        Map<String, String> passport = new HashMap<>();
        passport.put("series", "4509");
        passport.put("number", "123456");
        passport.put("issueDate", "2010-01-01");
        passport.put("issuerCode", "770-001");
        passport.put("issuedBy", "ОВД района Арбат г. Москвы");
        passport.put("placeOfBirth", "г. Москва");
        clientData.setPassport(passport);
        
        // Контактная информация
        Map<String, String> contactInfo = new HashMap<>();
        contactInfo.put("phoneNumber", "+79001234567");
        contactInfo.put("email", "ivanov@example.com");
        clientData.setContactInfo(contactInfo);
        
        // Адреса
        Map<String, String> addresses = new HashMap<>();
        addresses.put("residenceAddress", "г. Москва, ул. Ленина, д. 10");
        addresses.put("registrationAddress", "г. Москва, ул. Ленина, д. 10");
        clientData.setAddresses(addresses);
        
        clientsDb.put(clientId, clientData);

        clientData.setMaritalStatus(MaritalStatus.MARRIED);
        clientData.setEmploymentStatus(EmploymentStatus.EMPLOYED);
        clientData.setHasChildren(true);

    }

    @GetMapping(
        value = "/client-data/{clientId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PersonalDataResponse> getClientData(
            @PathVariable UUID clientId) {
        
        PersonalDataResponse clientData = clientsDb.get(clientId);
        if (clientData == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(clientData);
    }
}