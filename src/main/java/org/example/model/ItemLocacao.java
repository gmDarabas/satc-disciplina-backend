package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemLocacao extends ItemVendavel {
    private Produto produto;
    private Double valorUnitario;
    private Double quantidade;
    private Double desconto;

    public ItemLocacao(Produto produto, double valorUnitario, double quantidade, double desconto) {
        super();
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public double getValorCalculado() {
        double valorTotal = getValorUnitario() * quantidade;
        double descontoTotal = valorTotal * (getDesconto() / 100);
        return valorTotal - descontoTotal;
    }
}
