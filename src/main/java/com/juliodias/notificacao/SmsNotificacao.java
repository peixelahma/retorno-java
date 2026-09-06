package com.juliodias.notificacao;

public class SmsNotificacao implements Notificacao {
    public void enviarNotificacao() {
        System.out.println("Notificação enviada por SMS");
    }
}
