package com.bankapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapi.dto.NovoCorrentista;
import com.bankapi.model.Conta;
import com.bankapi.model.Correntista;
import com.bankapi.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;
    public void save(NovoCorrentista novoCorrentista){

        //criando um novo correntista
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        //criando uma nova conta 
        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());
        correntista.setConta(conta);
        repository.save(correntista);
    }
}
