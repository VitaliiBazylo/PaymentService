package com.example.vitaliibazylo.service;

import com.example.vitaliibazylo.api.requests.CreatePaymentRequest;
import com.example.vitaliibazylo.api.requests.PaymentLogRequest;
import com.example.vitaliibazylo.api.responce.PaymentLogResponse;
import com.example.vitaliibazylo.api.responce.PaymentResponse;
import com.example.vitaliibazylo.models.ClientEntity;
import com.example.vitaliibazylo.models.PaymentEntity;
import com.example.vitaliibazylo.repository.AccountRepository;
import com.example.vitaliibazylo.repository.ClientRepository;
import com.example.vitaliibazylo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PaymentRepository paymentRepository;

    public List<PaymentResponse> createPayment(List<CreatePaymentRequest> paymentsRequest) {
        List<PaymentResponse> paymentResponses = new ArrayList<>();

        for(var i=0 ; i < paymentsRequest.size(); i++) {

            PaymentResponse paymentResponse = new PaymentResponse();
            var request = paymentsRequest.get(i);
            var sourceAcc = accountRepository.findAccountEntityByAccountId(request.getSourceAccId());
            var destinationAcc = accountRepository.findAccountEntityByAccountId(request.getDestAccId());
            var paymentId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            var sourceBalance = sourceAcc.getBalance();
            var destBalance = destinationAcc.getBalance();
            var paymentStatus = "";

            if(sourceBalance >= request.getAmount()) {
                sourceAcc.setBalance(sourceBalance - paymentsRequest.get(i).getAmount());
                destinationAcc.setBalance(destBalance + request.getAmount());
                paymentStatus = "ok";
                accountRepository.save(sourceAcc);
                accountRepository.save(destinationAcc);
            } else {
                paymentStatus = "error";
            }
            paymentRepository.save(
                    new PaymentEntity(
                            null,
                            paymentId,
                            new Date(),
                            sourceAcc.getAccountId(),
                            destinationAcc.getAccountId(),
                            sourceAcc.getAccountNum(),
                            destinationAcc.getAccountNum(),
                            request.getAmount(),
                            paymentStatus,
                            request.getReason(),
                            sourceAcc.getClientId(),
                            destinationAcc.getClientId()
                    )
            );
            paymentResponse.setPaymentId(paymentId);
            paymentResponse.setStatus(paymentStatus);
            paymentResponses.add(paymentResponse);
        }
        return paymentResponses;
    }

    public List<PaymentLogResponse> createPaymentLog (PaymentLogRequest request){

        PaymentLogResponse paymentLog = new PaymentLogResponse();
        List<PaymentLogResponse> paymentLogResponses = new ArrayList<>();
        PaymentLogResponse.Payer payer = new PaymentLogResponse.Payer();
        PaymentLogResponse.Recipient recipient = new PaymentLogResponse.Recipient();
        List<PaymentEntity> paymentEntities = paymentRepository.findPaymentEntityByPayerIdAndRecipientIdAndSrcAccIdAndDestAccId(
                request.getPayerId(),
                request.getRecipientId(),
                request.getSourceAccId(),
                request.getDestAccId()
        );
        for (PaymentEntity paymentEntity : paymentEntities) {
            ClientEntity payerEntity = clientRepository.findClientByClientId(paymentEntity.getPayerId());
            ClientEntity recipientEntity = clientRepository.findClientByClientId(paymentEntity.getRecipientId());

            payer.setFirstName(payerEntity.getFirstName());
            payer.setLastName(payerEntity.getLastName());

            recipient.setFirstName(recipientEntity.getFirstName());
            recipient.setLastName(recipientEntity.getLastName());

            paymentLog.setPaymentId(paymentEntity.getPaymentId());
            paymentLog.setTimestamp(paymentEntity.getDate());
            paymentLog.setSrcAccNum(paymentEntity.getSrcAccNum());
            paymentLog.setDestAccNum(paymentEntity.getDestAccNum());
            paymentLog.setAmount(paymentEntity.getAmount());
            paymentLog.setPayer(payer);
            paymentLog.setRecipient(recipient);
            paymentLog.setStatus(paymentEntity.getStatus());

            paymentLogResponses.add(paymentLog);
        }
        return paymentLogResponses;
    }
}
