package com.example.vitaliibazylo.api.controllers;

import com.example.vitaliibazylo.api.requests.CreateClientRequest;
import com.example.vitaliibazylo.models.Account;
import com.example.vitaliibazylo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/user/inner")
    String createClient(@RequestBody CreateClientRequest request) {
        Long clientId = clientService.saveNewClient(request);
        return ("client_id : " + clientId);
    };

    @GetMapping("/user/accounts")
    List<Account> getClientAcc(@RequestParam ("clientId") Long clientId) {
        return clientService.getUserAccounts(clientId);
    };
};
