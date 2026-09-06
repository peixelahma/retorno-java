package com.juliodias.retorno;

import com.juliodias.domain.Funcionario;
import com.juliodias.notificacao.*;

public class Main {

    public static void main(String[] args) {
        double salarioAnual;

        try {
            Funcionario funcionario1 = new Funcionario("Julio", 44, 10000, false);
            imprimirDadosFuncionario(funcionario1);
            salarioAnual = funcionario1.calcularSalarioAnual();
            System.out.println("Salário anual: " + salarioAnual);

            if (funcionario1.aumentarPercentualSalario(10)) {
                System.out.println("Aumento salarial");
                System.out.println("Salário mensal após aumento salarial:" + funcionario1.getSalario());
            } else {
                System.out.println("Percentual de aumento salarial deve ser maior que 0");
            }

            if (funcionario1.funcionarioMaiorDeIdade()) {
                System.out.println("Funcionário maior de idade");
            } else {
                System.out.println("Funcionário não atingiu a maioridade");
            }
            funcionario1.ativarFuncionario();

            if (funcionario1.funcionarioAtivo()) {
                System.out.println("Funcionário Ativo !");
            } else {
                System.out.println("Funcionário Inativo !");
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Não foi possível criar o funcionário: " + e.getMessage());
        }



        System.out.println();
        try {
            Funcionario funcionario2 = new Funcionario("Ana", 45, 7000, true);
            imprimirDadosFuncionario(funcionario2);
            salarioAnual = funcionario2.calcularSalarioAnual();
            System.out.println("Salário anual: " + salarioAnual);

            if (funcionario2.aumentarPercentualSalario(-5)) {
                System.out.println("Aumento salarial");
                System.out.println("Salário mensal após aumento salarial:" + funcionario2.getSalario());
            } else {
                System.out.println("Percentual de aumento salarial deve ser maior que 0");
            }

            if (funcionario2.funcionarioMaiorDeIdade()) {
                System.out.println("Funcionário maior de idade");
            } else {
                System.out.println("Funcionário não atingiu a maioridade");
            }


            if (funcionario2.funcionarioAtivo()) {
                System.out.println("Funcionário Ativo !");
            } else {
                System.out.println("Funcionário Inativo !");
            }

            if (funcionario2.desativarFuncionario()) {
                System.out.println("Funcionário desativado !");
            } else {
                System.out.println("Funcionario já estava inativo");
            }

            if (funcionario2.funcionarioAtivo()) {
                System.out.println("Funcionário Ativo !");
            } else {
                System.out.println("Funcionário Inativo !");
            }

            if (funcionario2.ativarFuncionario()) {
                System.out.println("Funcionário ativado !");
            } else {
                System.out.println("Funcionario já estava inativo");
            }

            if (funcionario2.funcionarioAtivo()) {
                System.out.println("Funcionário Ativo !");
            } else {
                System.out.println("Funcionário Inativo !");
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Não foi possível criar o funcionário: " + e.getMessage());
        }


        try {
            Funcionario funcionario3 = new Funcionario("Carlos", 23, -1000, true);
            imprimirDadosFuncionario(funcionario3);
        } catch(IllegalArgumentException e) {
            System.out.println("Não foi possível criar o funcionário: " + e.getMessage());
        }

        //Envio de Notificação
        Notificacao email = new EmailNotificacao();
        ProcessadorNotificacao processador = new ProcessadorNotificacao(email);
        processador.processar("Notificação enviada por email");

        Notificacao sms = new SmsNotificacao();
        processador = new ProcessadorNotificacao(sms);
        processador.processar("Notificação enviada por SMS");

        Notificacao push = new PushNotificacao();
        processador = new ProcessadorNotificacao(push);
        processador.processar("Notificação enviada por Push");

    }

    public static void imprimirDadosFuncionario (Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salario: " + funcionario.getSalario());
        System.out.println("Idade: " + funcionario.getIdade());
        System.out.println("Ativo: " + funcionario.isAtivo());
    }

   }
