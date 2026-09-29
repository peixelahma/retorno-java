package com.juliodias.domain;

public class Funcionario {
    private String nome;
    private Integer idade;
    private double salario;
    private boolean ativo;

    //Construtor
    public Funcionario(String nome, Integer idade, double salario, boolean ativo) {

        this.nome = nome;
        this.idade = idade;
        this.ativo = ativo;
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário do(a) " + nome  + " deve ser maior que zero.");
        }
        this.salario = salario;
    }

    //Setters e Getters
    public String getNome() {return nome;}
    public double getSalario() {return salario;}
    public boolean isAtivo() {return ativo;}
    public int getIdade() {return idade;}


    //Informa aumento
    /*
    public boolean aumentarPercentualSalario (double percentual) {
        if (percentual > 0) {
            this.salario = salario * (1 + percentual / 100);
            return true;
        }
        return false;
    }
    */
    //Informa aumento do dia 17 - Exceptions
    public void aumentarPercentualSalario (double percentual) {
        if (percentual < 0) {
            throw new IllegalArgumentException("Percentual deve ser maior que zero");
        }
        this.salario = salario * (1 + percentual / 100);
    }


    //Informa se funcionário maior de idade
    public boolean funcionarioMaiorDeIdade () {
        /*if (idade < 18) {
            return false;
        }
        return true;*/
        return idade >= 18;
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

