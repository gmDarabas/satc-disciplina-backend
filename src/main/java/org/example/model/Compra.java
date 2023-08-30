package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.interfaces.OperacaoFinanceira;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Compra extends EntityId implements OperacaoFinanceira {
    private LocalDate dataCompra;
    private Fornecedor fornecedor;
    private String observacao;
    private List<ItemCompra> itens = new ArrayList<>();

    @Override
    public LocalDate getDataOperacao() {
        return dataCompra;
    }

    @Override
    public Double getValorTotalOperacao() {
        return getItens().stream()
                .mapToDouble(ItemCompra::getValorCalculado)
                .sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.DEBITO;
    }

    public void addItemCompra(ItemCompra item) {
        itens.add(item);
    }
}
