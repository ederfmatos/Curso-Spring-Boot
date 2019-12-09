package com.edermatos.cursospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "estados")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class EstadoEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @OneToMany
    @JoinColumn
    private List<CidadeEntidade> cidades = new ArrayList<>();

    public EstadoEntidade(Integer id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }

}
