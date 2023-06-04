package com.bankapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class CorrentistaController {
    
    @Autowired
    private CorrentistaRepository repository;
    
    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        service.save(correntista);
    }
}
