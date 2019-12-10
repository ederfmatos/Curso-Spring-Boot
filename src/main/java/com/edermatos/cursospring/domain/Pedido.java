package com.edermatos.cursospring.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pedido")
public class Pedido  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    @JoinColumn
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoEntrega;

}
