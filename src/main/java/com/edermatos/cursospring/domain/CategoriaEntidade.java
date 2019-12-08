package com.edermatos.cursospring.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "categorias")
@Getter
@Setter
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String nome;

}
