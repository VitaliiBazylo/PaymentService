package com.example.vitaliibazylo.api.controllers;

import com.example.vitaliibazylo.api.requests.CreatePaymentRequest;
import com.example.vitaliibazylo.api.responce.PaymentResponse;
import com.example.vitaliibazylo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    List<PaymentResponse> createPayment(@RequestBody List<CreatePaymentRequest> request) {
        List<PaymentResponse> paymentResponse = paymentService.createPayment(request);
        return paymentResponse;
    };

};
