package com.edermatos.cursospring.domain;

import lombok.*;

import javax.persistence.*;

@Entity(name = "enderecos")
@Getter
@Setter
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private Integer numero;

    @Column
    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cep;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ClienteEntidade cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CidadeEntidade cidade;

}