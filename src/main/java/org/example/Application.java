package org.example;

import org.example.model.Produto;
import org.example.model.Status;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("Teste");
        produto.setDescricao("Produto teste");
        produto.setStatus(Status.ALUGADO);
        produto.setDataValidade(LocalDate.now());
        produto.setPrecoCompra(1000d);
        produto.setPrecoVenda(1500d);

        System.out.println(produto.calculaMargemLucro());
    }

}

