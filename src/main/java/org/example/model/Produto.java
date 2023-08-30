package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Produto extends ItemVendavel {
    private String nome;
    private Double precoCompra;
    private LocalDate dataValidade;
    private LocalDate dataPrazo;
    private Status status;

    public Produto(String nome, String descricao) {
        super();
        setNome(nome);
        setDescricao(descricao);
    }

    public void setPrecoVenda(Double precoVenda) {
        setValorUnitario(precoVenda);
        if (calculaMargemLucro() < 20) {
            System.out.println("Margem de lucro deve ser superior a 20%");
        }
    }

    public Double calculaMargemLucro() {
        double precoVenda = getValorUnitario();
        double lucro = precoVenda - precoCompra;
        return (lucro / precoVenda) * 100;
    }
}
