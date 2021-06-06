package com.example.vitaliibazylo.api.responce;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {
    private Long   paymentId;
    private String status;
}
