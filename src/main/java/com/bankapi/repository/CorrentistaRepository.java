package com.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapi.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
    
}
