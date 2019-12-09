package com.edermatos.cursospring.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "categorias")
@Getter
@Setter
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class CategoriaEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<ProdutoEntidade> produtos = new ArrayList<>();

    public CategoriaEntidade(Integer id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }
}
