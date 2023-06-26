package com.bankapi.dto;

import java.time.LocalDateTime;

import com.bankapi.model.MovimentacaoTipo;

import lombok.Data;

@Data
public class NovaMovimentacao {
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
    private Integer idConta;
    private LocalDateTime dataHora;
}
