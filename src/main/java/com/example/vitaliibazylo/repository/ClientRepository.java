package com.example.vitaliibazylo.repository;

import com.example.vitaliibazylo.models.ClientEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    @Query("SELECT c FROM clients c WHERE c.client_id = ?1")
    ClientEntity findClientByClientId (Long clientId);
}
