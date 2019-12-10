package com.edermatos.cursospring.domain;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento implements Serializable {

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

}
