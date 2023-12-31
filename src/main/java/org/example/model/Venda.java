package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.interfaces.OperacaoFinanceira;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Venda extends EntityId implements OperacaoFinanceira {
    private LocalDate dataVenda;
    private FormaPagamento formaPagamento;
    private String observacao;
    private Cliente cliente;
    private List<ItemVenda> itens = new ArrayList<>();

    @Override
    public LocalDate getDataOperacao() {
        return dataVenda;
    }

    @Override
    public Double getValorTotalOperacao() {
        return getItens().stream()
                .mapToDouble(ItemVenda::getValorCalculado)
                .sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.CREDITO;
    }

    public void addItemVenda(ItemVenda item) {
        itens.add(item);
    }
}
