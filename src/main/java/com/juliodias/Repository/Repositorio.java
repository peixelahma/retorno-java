package com.juliodias.Repository;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {
    private List<T> registros;
    public Repositorio() {
        this.registros = new ArrayList<>();
    }


    public void adicionar(T registro) {
        registros.add(registro);
    }
    public void remover(T registro) {
        registros.remove(registro);
    }
    public List<T> listar() {
        return registros;
    }
    public int quantidade() {
        return registros.size();
    }
    public T buscar(int index) {
        return registros.get(index);
    }

}
