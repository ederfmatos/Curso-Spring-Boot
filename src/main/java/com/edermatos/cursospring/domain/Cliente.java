package com.edermatos.cursospring.domain;

import com.edermatos.cursospring.enumerations.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "clientes")
@Getter
@Setter
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Cliente  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cpfOuCnpj;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoCliente tipo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telefones")
    private Set<String> telefones = new HashSet<>();

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setCpfOuCnpj(cpfOuCnpj);
        this.setTipo(tipo);
    }

}
