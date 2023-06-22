package com.bankapi.dto;

import lombok.Data;

@Data
public class NovoCorrentista {
    private String nome;
    private String cpf;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
