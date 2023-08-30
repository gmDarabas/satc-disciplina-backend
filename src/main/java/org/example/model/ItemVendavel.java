package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemVendavel extends EntityId {
    private String descricao;
    private Double valorUnitario;
    private Boolean estocavel;
}
