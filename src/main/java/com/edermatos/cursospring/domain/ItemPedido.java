package com.edermatos.cursospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemPedido implements Serializable {

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private double desconto;

    private int quantidade;

    @Column(nullable = false)
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, double desconto, int quantidade, double preco) {
        this.getId().setPedido(pedido);
        this.getId().setProduto(produto);
        this.setDesconto(desconto);
        this.setQuantidade(quantidade);
        this.setPreco(preco);
    }

    public Produto getProduto() {
        return getId().getProduto();
    }

}
