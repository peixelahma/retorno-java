package com.juliodias.notificacao;

public class ProcessadorNotificacao {
    private final Notificacao notificacao;

    public ProcessadorNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void processar(String mensagem) {
        notificacao.enviarNotificacao(mensagem);
    }
}
