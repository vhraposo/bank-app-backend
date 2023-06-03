package com.bankapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Conta {
    @Column(name = "conta_numero" )
    private Long numero;

    @Column(name = "conta_saldo" )
    private Double saldo;
}
