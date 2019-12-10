package com.edermatos.cursospring.enumerations;

import lombok.Getter;

@Getter
public enum EstadoPagamento {

    PENDETE(0),
    QUITADO(1),
    CANCELADO(2);

    private int codigo;

    EstadoPagamento(int codigo) {
        this.codigo = codigo;
    }

}
