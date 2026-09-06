package com.juliodias.notificacao;

public class PushNotificacao implements Notificacao {
    public void enviarNotificacao(String mensagem) {
        System.out.println(mensagem);
    }
}
