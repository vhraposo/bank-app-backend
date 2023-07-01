package com.bankapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapi.dto.NovaMovimentacao;
import com.bankapi.model.Correntista;
import com.bankapi.model.Movimentacao;
import com.bankapi.model.MovimentacaoTipo;
import com.bankapi.repository.CorrentistaRepository;
import com.bankapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;
    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();

       Double valor = novaMovimentacao.getValor();
       if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA){
           valor = valor * -1;
       }

        movimentacao.setDataHora(novaMovimentacao.getDataHora());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(novaMovimentacao.getValor());
       

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);
    }
    public Optional<Movimentacao> update(Integer id, Movimentacao novaMovimentacao) {
    Optional<Movimentacao> optionalMovimentacao = repository.findById(id);

    if (optionalMovimentacao.isPresent()) {
        Movimentacao existingMovimentacao = optionalMovimentacao.get();
        existingMovimentacao.setDescricao(novaMovimentacao.getDescricao());
        existingMovimentacao.setValor(novaMovimentacao.getValor());
        existingMovimentacao.setTipo(novaMovimentacao.getTipo());
        existingMovimentacao.setDataHora(novaMovimentacao.getDataHora());
        existingMovimentacao.setIdConta(novaMovimentacao.getIdConta());

        Correntista correntista = correntistaRepository.findById(existingMovimentacao.getIdConta()).orElse(null);
        if (correntista != null) {
            correntista.getConta().setSaldo(novaMovimentacao.getValor());
            correntistaRepository.save(correntista);
        }
        repository.save(existingMovimentacao);

        return Optional.of(existingMovimentacao);
    } else {
        return Optional.empty();
    }
}



}