package com.juliodias.Pagamento;

public class TipoPagamento {
    private Pagamento pagamento;

    public TipoPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void adicionarTipoPagamento (String metodoPagamento) {
        pagamento.adicionarPagamento(metodoPagamento);
    }
}
