package com.bankapi.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapi.dto.NovoCorrentista;
import com.bankapi.model.Conta;
import com.bankapi.model.Correntista;
import com.bankapi.repository.CorrentistaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

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

    public Optional<Correntista> update(@Positive Integer id, @Valid Correntista correntista) {
    return repository.findById(id)
        .map(recordFound -> {
            recordFound.setNome(correntista.getNome());
            recordFound.setCpf(correntista.getCpf());
            return repository.save(recordFound);
        });
}


}
