package org.example;

import org.example.model.*;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setId(1L);
        produto.setNome("Teste");
        produto.setDescricao("Produto teste");
        produto.setStatus(Status.ALUGADO);
        produto.setDataValidade(LocalDate.now());
        produto.setPrecoCompra(1000d);
        produto.setPrecoVenda(1200d);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Dell");

        Cliente cliente = new Cliente();
        cliente.setNome("Guilherme");

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(LocalDate.now());
        venda.setFormaPagamento(FormaPagamento.CREDITO);

        System.out.println(produto.calculaMargemLucro());
    }

}

