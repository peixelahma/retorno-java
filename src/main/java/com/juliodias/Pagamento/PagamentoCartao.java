package com.juliodias.Pagamento;

public class PagamentoCartao implements Pagamento {

    private String tipoPagamento;

    public void adicionarPagamento(String metodoPagamento) {
        this.tipoPagamento = metodoPagamento;
    }


    public void imprimirFormaPagamento() {
        System.out.println("Forma de Pagamento com " + tipoPagamento);
    }
}
