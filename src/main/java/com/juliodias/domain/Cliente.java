package com.juliodias.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Pedido> pedidos;

    //Construtor para instanciar os objetos com valores
    public Cliente(String nome ) {
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido (Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void listarPedidos() {
        System.out.println("Nome: " + this.nome);
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido " + pedido.getNumeroPedido());
            System.out.println("Produtos:");
            pedido.listarProdutos();
            pedido.listarFormaPagamento();
        }
    }

    public String getNome() {
        return nome;
    }

}
