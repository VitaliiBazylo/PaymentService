package com.example.vitaliibazylo.repository;

import com.example.vitaliibazylo.models.PaymentEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {
    @Query("SELECT * FROM payments p WHERE p.payer_id = ?1 AND p.recipient_id = ?2 AND p.src_acc_id = ?3 AND p.dest_acc_id = ?4")
    List<PaymentEntity> findPaymentEntityByPayerIdAndRecipientIdAndSrcAccIdAndDestAccId (Long payerId, Long recipientId, Long sourceAccId, Long destAccId);
}
