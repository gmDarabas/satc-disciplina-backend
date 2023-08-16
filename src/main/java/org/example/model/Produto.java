package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
public class Produto {
    public Integer id;

    public String nome;
    public String descricao;
    public Double precoVenda;
    public Double precoCompra;
    public LocalDate dataValidade;
    public LocalDate dataPrazo;
    public Status status;

    public Double calculaMargemLucro() {
        double lucro = precoVenda - precoCompra;
        return (lucro/precoVenda)*100;
    }
}
