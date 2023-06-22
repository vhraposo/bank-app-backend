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

import com.bankapi.dto.NovoCorrentista;
import com.bankapi.model.Correntista;
import com.bankapi.repository.CorrentistaRepository;
import com.bankapi.service.CorrentistaService;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
@CrossOrigin(origins = "http://localhost:4200")
public class CorrentistaController {
    
    @Autowired
    private CorrentistaRepository repository;
    
    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Correntista> findById(@PathVariable Integer id) {
    return repository.findById(id)
            .map(correntista -> ResponseEntity.ok().body(correntista))
            .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        service.save(correntista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Correntista> update(@PathVariable Integer id, @RequestBody Correntista correntista) {
    return service.update(id, correntista)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

}
