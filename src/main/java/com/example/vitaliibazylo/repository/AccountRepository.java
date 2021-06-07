package com.example.vitaliibazylo.repository;

import com.example.vitaliibazylo.models.AccountEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    @Query("SELECT a FROM accounts a WHERE a.account_id = ?1")
    AccountEntity findAccountEntityByAccountId(Long accountId);

    @Query("SELECT * FROM accounts a WHERE a.client_id = ?1")
    List<AccountEntity> findAccountEntitiesByClientId (Long clientId);
}
