package com.juliodias.domain;

public class Funcionario {
    private String nome;
    private int idade;
    private double salario;
    private boolean ativo;

    //Construtor
    public Funcionario(String nome, int idade, double salario, boolean ativo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.ativo = ativo;
    }

    //Informa salário anual
    public double calcularSalarioAnual() {
        return salario * 12;
        //return salario * 12;
    }

    //Informa aumento
    public void informaAumentoPercentual (double percentual) {
        if (percentual > 0) {
            this.salario = salario * (1 + percentual / 100);
            System.out.println("Aumento de " + percentual + "%");
            System.out.println("Valor do salário após aumento: " + salario);
        } else{
            System.out.println("Valor percentual deverá ser maior que 0!");
        }
    }

    //Informa se funcionário maior de idade
    public void funcionarioMaiorDeIdade (){
        if (idade < 18) {
            System.out.println("Funcionario não atingiu a maioridade");
        } else {
            System.out.println("Funcionario maior de idade");
        }
    }

    //Informa se o funcionário está ativo
    public void funcionarioAtivo () {
        if (ativo) {
            System.out.println("Funcionario ativo");
        } else  {
            System.out.println("Funcionario inativo");
        }
    }

    //Desativar funcionario
    public void desativarFuncionario () {
        ativo = false;
    }

    public void dadosFuncionario () {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Salario: " + salario);
        System.out.println("Ativo: " + ativo);

    }

}
