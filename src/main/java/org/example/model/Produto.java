package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Produto extends EntityId {
    private String nome;
    private String descricao;
    private Double precoVenda;
    private Double precoCompra;
    private LocalDate dataValidade;
    private LocalDate dataPrazo;
    private Status status;

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
        if (calculaMargemLucro() < 20) {
            System.out.println("Margem de lucro deve ser superior a 20%");
        }
    }

    public Double calculaMargemLucro() {
        double lucro = precoVenda - precoCompra;
        return (lucro / precoVenda) * 100;
    }
}
