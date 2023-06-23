package com.bankapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapi.dto.NovaMovimentacao;
import com.bankapi.model.Movimentacao;
import com.bankapi.repository.MovimentacaoRepository;
import com.bankapi.service.MovimentacaoService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacoes")
@CrossOrigin(origins = "http://localhost:4200")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoRepository repository;
    
    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable("id") Integer id) {
    Optional<Movimentacao> optionalMovimentacao = repository.findById(id);

    if (optionalMovimentacao.isPresent()) {
        Movimentacao movimentacao = optionalMovimentacao.get();
        return ResponseEntity.ok().body(movimentacao);
    } else {
        return ResponseEntity.notFound().build();
    }
    }

    // @GetMapping("/{idConta}")
    // public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
    //     return repository.findByIdConta(idConta);
    // }   
    

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){
        service.save(movimentacao);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> update(@PathVariable Integer id, @RequestBody @Valid Movimentacao movimentacao) {
    Optional<Movimentacao> optionalMovimentacao = service.update(id, movimentacao);

    if (optionalMovimentacao.isPresent()) {
        Movimentacao updatedMovimentacao = optionalMovimentacao.get();
        return ResponseEntity.ok().body(updatedMovimentacao);
    } else {
        return ResponseEntity.notFound().build();
    }
    }
}
