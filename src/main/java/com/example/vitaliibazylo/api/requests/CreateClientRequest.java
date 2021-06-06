package com.example.vitaliibazylo.api.requests;

import com.example.vitaliibazylo.models.Account;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class CreateClientRequest {
    private String        firstName;
    private String        lastName;
    private List<Account> accounts;
}
