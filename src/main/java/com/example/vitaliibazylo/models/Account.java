package com.example.vitaliibazylo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long    accountId;
    private Long    accountNum;
    private String  accountType;
    private Integer balance;
}
