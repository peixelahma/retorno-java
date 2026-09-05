package com.juliodias.retorno;

import com.juliodias.domain.Funcionario;

public class Main {

    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario("Julio", 44, 10000, true);
        funcionario1.dadosFuncionario();
        double salarioAnual = funcionario1.calcularSalarioAnual();
        System.out.println("Salário anual: " + salarioAnual);
        funcionario1.informaAumentoPercentual( 10);
        funcionario1.funcionarioMaiorDeIdade();
        funcionario1.funcionarioAtivo();

        System.out.println();
        Funcionario funcionario2 = new Funcionario("Ana", 45, 7000, true);
        funcionario2.dadosFuncionario();
        salarioAnual = funcionario2.calcularSalarioAnual();
        System.out.println("Salário anual: " + salarioAnual);
        funcionario2.informaAumentoPercentual( 20);
        funcionario2.funcionarioMaiorDeIdade();
        funcionario2.funcionarioAtivo();

        funcionario2.desativarFuncionario();
        System.out.println("Verificar situação do funcionario: " );
        funcionario2.funcionarioAtivo();


    }   
   }