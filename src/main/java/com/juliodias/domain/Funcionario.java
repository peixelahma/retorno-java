package com.juliodias.domain;

public class Funcionario {
    private String nome;
    private final int idade;
    private double salario;
    private boolean ativo;

    //Construtor
    public Funcionario(String nome, int idade, double salario, boolean ativo) {
        this.nome = nome;
        this.idade = idade;
        this.ativo = ativo;
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero.");
        }

        this.salario = salario;
    }

    //Setters e Getters
    public String getNome() {return nome;}
    public double getSalario() {return salario;}
    public boolean isAtivo() {return ativo;}
    public int getIdade() {return idade;}


    //Informa salário anual
    public double calcularSalarioAnual() {
        return salario * 12;
        //return salario * 12;
    }

    //Informa aumento
    public boolean aumentarPercentualSalario (double percentual) {
        if (percentual > 0) {
            this.salario = salario * (1 + percentual / 100);
            return true;
        }
        return false;
    }

    //Informa se funcionário maior de idade
    public boolean funcionarioMaiorDeIdade () {
        /*if (idade < 18) {
            return false;
        }
        return true;*/
        return idade >= 18;
    }

    //Informa se o funcionário está ativo
    public boolean funcionarioAtivo () {
        return ativo;
    }

    //Desativar funcionario
    public boolean desativarFuncionario () {
        if (ativo) {
            ativo = false;
            return true;
        }
        return false;
    }

    //Ativar funcionario
    public boolean ativarFuncionario () {
        if (!ativo) {
            ativo = true;
            return true;
        }
        return false;
    }
}

