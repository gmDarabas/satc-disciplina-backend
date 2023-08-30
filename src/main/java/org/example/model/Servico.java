package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servico extends ItemVendavel {
    private Double quantidadeHoras;

    public Servico(String descricao, Double quantidadeHoras, double valorUnitario) {
        setDescricao(descricao);
        setQuantidadeHoras(quantidadeHoras);
        setValorUnitario(valorUnitario);
    }

    @Override
    public Boolean getEstocavel() {
        return false;
    }

}
