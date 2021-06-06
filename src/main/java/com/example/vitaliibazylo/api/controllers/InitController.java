package com.example.vitaliibazylo.api.controllers;

import com.example.vitaliibazylo.api.requests.CreateClientRequest;
import com.example.vitaliibazylo.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InitController {

    @Autowired
    InitService initService;

    @PostMapping("/inner/user")
    String createClient(@RequestBody CreateClientRequest request) {
        Long clientId = initService.saveNewClient(request);
        return ("client_id : " + clientId);
    };

};
