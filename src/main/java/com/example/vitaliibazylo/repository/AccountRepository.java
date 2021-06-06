package com.example.vitaliibazylo.repository;

import com.example.vitaliibazylo.models.AccountEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    @Query("SELECT a FROM accounts a WHERE a.account_id = ?1")
    AccountEntity findAccountEntityByAccountId(Long accountId);


//    @Query("UPDATE accounts a SET balance = ?1 WHERE a.account_id = ?2")
//    @Modifying
//    @Query("UPDATE accounts SET balance = ?2 WHERE account_id = ?1")
//    void updateAccountBalance(Integer balance, Long accountId);
}
