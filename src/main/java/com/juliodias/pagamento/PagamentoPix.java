package com.juliodias.pagamento;

public class PagamentoPix {
    private String tipoPagamento;

    public void adicionarPagamento(String metodoPagamento) {
        System.out.println("Pago com " + metodoPagamento);
    }

    public void imprimirFormaPagamento() {
        System.out.println("Forma de Pagamento com " + tipoPagamento);
    }
}
