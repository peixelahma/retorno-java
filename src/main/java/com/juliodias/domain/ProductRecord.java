package com.juliodias.domain;

public record ProductRecord(
        Long id,
        String nome,
        double preco
) {
    public ProductRecord {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
    }

    public boolean precoCaro() {
        if (preco > 1100) {
            return true;
        }
        return false;
    }
}
