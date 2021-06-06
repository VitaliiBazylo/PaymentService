package com.example.vitaliibazylo.repository;

import com.example.vitaliibazylo.models.Account;
import com.example.vitaliibazylo.models.AccountEntity;
import com.example.vitaliibazylo.models.PaymentEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {
//    @Query("SELECT a FROM accounts a WHERE a.account_id = ?1")
//    Account findAccountEntityByAccountId(Long accountId);
}
