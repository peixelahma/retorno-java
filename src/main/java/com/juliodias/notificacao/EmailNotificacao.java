package com.juliodias.notificacao;

public class EmailNotificacao implements Notificacao {

    public void enviarNotificacao(String mensagem) {
        System.out.println(mensagem);
    }

}
