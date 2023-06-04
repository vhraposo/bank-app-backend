package com.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    
}
