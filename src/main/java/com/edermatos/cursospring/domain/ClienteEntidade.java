package com.edermatos.cursospring.domain;

import com.edermatos.cursospring.enumerations.TipoCliente;
import lombok.*;

import javax.persistence.*;
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
public class ClienteEntidade {

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
    private List<EnderecoEntidade> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telefones")
    private Set<String> telefones = new HashSet<>();

    public ClienteEntidade(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setCpfOuCnpj(cpfOuCnpj);
        this.setTipo(tipo);
    }

}
