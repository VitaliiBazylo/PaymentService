package com.example.vitaliibazylo.api.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentLogRequest {
        private Long    payerId;
        private Long    recipientId;
        private Long    sourceAccId;
        private Long    destAccId;
}