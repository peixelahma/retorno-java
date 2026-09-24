package com.juliodias.domain;

import com.juliodias.common.utils.StatusPedido;
import com.juliodias.pagamento.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<Produto> produtos;
    private Pagamento pagamento;
    private StatusPedido statusPedido;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.produtos = new ArrayList<>();
        this.statusPedido = StatusPedido.CRIADO;
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

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void pagarPedido() {
        if (statusPedido == StatusPedido.CRIADO) {
            statusPedido = StatusPedido.PAGO;
        } else {
            throw new IllegalArgumentException("Erro ao pagar o pedido. Status Inválido.");
        }
    }


    public void enviarPedido() {
        if (statusPedido== StatusPedido.PAGO) {
            statusPedido = StatusPedido.ENVIADO;
        } else {
            throw new IllegalStateException("Erro ao enviar o pedido. Status Inválido.");
        }
    }

    public void entregarPedido() {
        if (statusPedido== StatusPedido.ENVIADO) {
            statusPedido = StatusPedido.ENTREGUE;
        } else {
            throw new IllegalArgumentException("Erro ao entregar o pedido. Status Inválido.");
        }

    }

    public void cancelarPedido() {
        if (
                (statusPedido == StatusPedido.CRIADO) ||
                (statusPedido== StatusPedido.PAGO)
    ) {
            statusPedido = StatusPedido.CANCELADO;
        }else {
            throw new IllegalArgumentException("Erro ao cancelar o pedido. Status Inválido.");
        }
    }
}
