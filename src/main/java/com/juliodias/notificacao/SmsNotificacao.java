package com.juliodias.notificacao;

public class SmsNotificacao implements Notificacao {
    public void enviarNotificacao(String mensagem) {
        System.out.println(mensagem);
    }
}
