package com.example.vitaliibazylo.service;

import com.example.vitaliibazylo.api.requests.CreateClientRequest;
import com.example.vitaliibazylo.models.*;
import com.example.vitaliibazylo.repository.AccountRepository;
import com.example.vitaliibazylo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InitService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;

    public Long saveNewClient(CreateClientRequest request) {
        Long clientId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        clientRepository.save(
                new ClientEntity(
                        null,
                        clientId,
                        request.getFirstName(),
                        request.getLastName()
                )
        );
        saveAccount(request.getAccounts(), clientId);
        return clientId;
    }

    public void saveAccount(List<Account> accounts, Long clientId) {
        accounts.forEach(account ->
                accountRepository.save(
                        new AccountEntity(
                                null,
                                clientId,
                                UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                                account.getAccountNum(),
                                account.getAccountType(),
                                account.getBalance()
                        )
                )
        );
    }
};
