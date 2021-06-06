package com.example.vitaliibazylo.api.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {
        private Long    sourceAccId;
        private Long    destAccId;
        private Integer amount;
        private String  reason;
}
