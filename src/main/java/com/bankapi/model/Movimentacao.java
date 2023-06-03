package com.bankapi.model;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Movimentacao {
    private Integer id;
    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
    

}
