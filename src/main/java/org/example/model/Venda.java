package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Venda extends EntityId {
    private LocalDate dataVenda;
    private FormaPagamento formaPagamento;
    private String observacao;
    private Cliente cliente;
}
