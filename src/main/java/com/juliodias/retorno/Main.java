package com.juliodias.retorno;

public class Main {

    public static void main(String[] args) {

        Produto produto = new Produto("Teclado", 250.00);

        System.out.println(produto.getNome());
        System.out.println(produto.getPreco());
    }
}