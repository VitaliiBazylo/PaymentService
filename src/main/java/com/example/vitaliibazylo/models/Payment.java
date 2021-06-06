package com.example.vitaliibazylo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long    accountId;
    private Long    accountNum;
    private String  accountType;
    private Integer balance;
}
