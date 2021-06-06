package com.example.vitaliibazylo.repository;

import com.example.vitaliibazylo.models.ClientEntity;

import java.util.List;

public interface UserRepositoryService {
    List<ClientEntity> getAll(int month, int day);
}
