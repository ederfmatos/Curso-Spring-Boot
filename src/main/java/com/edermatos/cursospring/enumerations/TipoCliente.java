package com.edermatos.cursospring.enumerations;

import lombok.Getter;

@Getter
public enum TipoCliente {

    PESSOA_FISICA(0),
    PESSOA_JURIDICA(1);

    private int codigo;

    TipoCliente(int codigo) {
        this.codigo = codigo;
    }

}
