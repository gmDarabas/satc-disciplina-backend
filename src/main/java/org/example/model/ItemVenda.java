package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemVenda {
    private ItemVendavel itemVendavel;
    private Double valorUnitario;
    private Double quantidade;
    private Double desconto;

    public ItemVenda(ItemVendavel itemVendavel, double valorUnitario, double quantidade, double desconto) {
        this.itemVendavel = itemVendavel;
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
