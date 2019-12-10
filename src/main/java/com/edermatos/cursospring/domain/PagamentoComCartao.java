package com.edermatos.cursospring.domain;


import com.edermatos.cursospring.enumerations.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PagamentoComCartao extends Pagamento implements Serializable {

    private int numeroDeParcelas;

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, int numeroDeParcelas) {
        super(id, estado, pedido);

        this.setNumeroDeParcelas(numeroDeParcelas);
    }
}
