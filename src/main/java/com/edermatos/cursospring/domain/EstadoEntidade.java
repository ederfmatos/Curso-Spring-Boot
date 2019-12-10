package com.edermatos.cursospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "estados")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class EstadoEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 2, unique = true)
    private String sigla;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<CidadeEntidade> cidades = new ArrayList<>();

    public EstadoEntidade(Integer id, String nome, String sigla) {
        this.setId(id);
        this.setNome(nome);
        this.setSigla(sigla);
    }

}
