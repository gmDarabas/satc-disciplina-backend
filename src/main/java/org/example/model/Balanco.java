package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.interfaces.OperacaoFinanceira;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Balanco extends EntityId {
    private LocalDate dataBalanco;
    private String responsavel;
    private List<OperacaoFinanceira> operacoesFinanceiras = new ArrayList<>();

    public void addOperacaoFinanceira(OperacaoFinanceira operacaoFinanceira) {
        operacoesFinanceiras.add(operacaoFinanceira);
    }

    public void delOperacoes(OperacaoFinanceira operacaoFinanceira) {
        operacoesFinanceiras.remove(operacaoFinanceira);
    }

    public void imprimirBalanco() {
        System.out.println("----------------------");
        System.out.println("Balanço numero: " + this.getId());
        System.out.println("Data: " + this.getDataBalanco());
        System.out.println("Responsavel: " + this.getResponsavel());
        System.out.println("------------------------");
        System.out.println("Itens: ");
        for (OperacaoFinanceira op : this.getOperacoesFinanceiras()) {
            System.out.println(
                    "Data Operação: " + op.getDataOperacao() + " | " +
                    "Tipo operação: " + op.getTipoOperacao() + " | " +
                    "Valor operação: " + op.getValorTotalOperacao() +
                    " - (" + getTipoOperacao(op) + ")"
            );
        }

        System.out.println("--------------------------");
        System.out.println("Total de debito: " + getTotalDebito());
        System.out.println("Total de credito: " + getTotalCredito());
        System.out.println("Total: " + (getTotalCredito() - getTotalDebito()));
    }

    public Double getValorTotal(TipoOperacao tipo) {
        return getOperacoesFinanceiras().stream().filter(op -> op.getTipoOperacao().equals(tipo))
                .mapToDouble(OperacaoFinanceira::getValorTotalOperacao)
                .sum();
    }

    public Double getTotalCredito() {
        return getValorTotal(TipoOperacao.CREDITO);
    }

    public Double getTotalDebito() {
        return getValorTotal(TipoOperacao.DEBITO);
    }

    public String getTipoOperacao(OperacaoFinanceira operacao) {
        if (operacao instanceof Compra) {
            return "Compra";
        }

        if (operacao instanceof Venda) {
            return "Venda";
        }

        return "Locação";
    }
}
