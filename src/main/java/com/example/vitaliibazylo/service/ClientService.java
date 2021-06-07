package com.example.vitaliibazylo.service;

import com.example.vitaliibazylo.api.requests.CreateClientRequest;
import com.example.vitaliibazylo.models.*;
import com.example.vitaliibazylo.repository.AccountRepository;
import com.example.vitaliibazylo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

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

    public List<Account> getUserAccounts(Long clientId) {
        List<Account> accounts = new ArrayList<>();

        List<AccountEntity> accountEntities = accountRepository.findAccountEntitiesByClientId(clientId);

        for (AccountEntity entity : accountEntities) {
            Account account = new Account();
            AccountEntity accountEntity;
            accountEntity = entity;
            account.setAccountId(accountEntity.getAccountId());
            account.setAccountNum(accountEntity.getAccountNum());
            account.setAccountType(accountEntity.getAccountType());
            account.setBalance(accountEntity.getBalance());

            accounts.add(account);
        }
        return accounts;
    }
};
