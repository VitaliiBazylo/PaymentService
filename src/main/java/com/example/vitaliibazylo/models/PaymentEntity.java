package com.example.vitaliibazylo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    private Long    paymentId;
    private Date    date;
    private Long    srcAccId;
    private Long    destAccId;
    private Long    srcAccNum;
    private Long    destAccNum;
    private Integer amount;
    private String  status;
    private String  purpose;
    private Long    payerId;
    private Long    recipientId;
}

