package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.interfaces.OperacaoFinanceira;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Locacao extends EntityId implements OperacaoFinanceira {
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Cliente cliente;
    private String endereco;
    private String observacao;
    private List<ItemLocacao> itens = new ArrayList<>();

    @Override
    public LocalDate getDataOperacao() {
        return dataLocacao;
    }

    @Override
    public Double getValorTotalOperacao() {
        return getItens().stream()
                .mapToDouble(ItemLocacao::getValorCalculado)
                .sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.CREDITO;
    }

    public void addItemLocacao(ItemLocacao item) {
        itens.add(item);
    }
}
