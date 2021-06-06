package com.example.vitaliibazylo.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    private Long    clientId;
    private Long    accountId;
    private Long    accountNum;
    private String  accountType;
    private Integer balance;
}
