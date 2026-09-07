package com.juliodias.domain;

import com.juliodias.Pagamento.Pagamento;
import com.juliodias.Pagamento.TipoPagamento;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<Produto> produtos;
    private Pagamento pagamento;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.produtos = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }


    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.print("id: " + produto.getId());
            System.out.println(" -> Nome: " + produto.getNome());
        }
    }

    public void listarFormaPagamento () {
        pagamento.imprimirFormaPagamento();
    }

    public void adicionarTipoPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
