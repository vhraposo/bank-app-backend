package com.bankapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapi.model.Correntista;
import com.bankapi.repository.CorrentistaRepository;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    
    @Autowired
    private CorrentistaRepository repository;
    
    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }
}
