package com.edermatos.cursospring.domain;

import com.edermatos.cursospring.enumerations.EstadoPagamento;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "pagamento")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private EstadoPagamento estado = EstadoPagamento.PENDETE;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

}
