package com.edermatos.cursospring.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "produtos")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class ProdutoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String nome;

    @Column
    private double preco;

    @ManyToMany
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriaEntidade> categorias = new ArrayList<>();

    public ProdutoEntidade(Integer id, String nome, double preco) {
        this.setId(id);
        this.setNome(nome);
        this.setPreco(preco);
    }

}