package com.example.vitaliibazylo.api.responce;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PaymentLogResponse {
    private Long      paymentId;
    private Date      timestamp;
    private Long      srcAccNum;
    private Long      destAccNum;
    private Integer   amount;
    private Payer     payer;
    private Recipient recipient;
    private String    status;

    @Getter
    @Setter
    public static class Payer {
        private String firstName;
        private String lastName;
    }

    @Getter
    @Setter
    public static class Recipient {
        private String firstName;
        private String lastName;
    }
}
