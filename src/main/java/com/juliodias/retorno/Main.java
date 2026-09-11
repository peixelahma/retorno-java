package com.juliodias.retorno;

import com.juliodias.Pagamento.Pagamento;
import com.juliodias.Pagamento.PagamentoCartao;
import com.juliodias.domain.Cliente;
import com.juliodias.domain.Funcionario;
import com.juliodias.domain.Pedido;
import com.juliodias.domain.Produto;
import com.juliodias.notificacao.*;

import java.util.*;

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

        //Cadastrar produto -Com LIST
        Produto produto1 = new Produto(1, "computador");
        Produto produto2 = new Produto(2, "impressora");
        Produto produto3 = new Produto(3, "mouse");

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto1);

        System.out.println("Exercício List");
        System.out.println("Quantidade de produtos cadastrado: " + produtos.size());
        System.out.println("Produto 2: " +  produtos.get(2));
        System.out.println("Produto impressoa está na lista? " + produtos.contains(produto2));
        produtos.remove(2);
        System.out.println("Quantidade de produtos cadastrado: " + produtos.size());


        //Cadastrar produto -Com SET
        Produto produto4 = new Produto(1, "Teclado");
        Produto produto5 = new Produto(2, "Mouse");
        Produto produto6 = new Produto(3, "Monitor");

        Set<Produto> produtosSet = new HashSet<>();
        produtosSet.add(produto4);
        produtosSet.add(produto5);
        produtosSet.add(produto4);
        produtosSet.add(produto6);
        produtosSet.add(produto5);
        System.out.println("Exercício Set");
        System.out.println("Quantidade de produtos cadastrado: " + produtosSet.size());

        System.out.println("Produto impressoa está na lista? " + produtosSet.contains(produto2));
        produtosSet.remove(produto6);
        System.out.println("Quantidade de produtos cadastrado: " + produtosSet.size());

        //Cadastrar produto com MAP
        Produto produto7 = new Produto(1, "Teclado");
        Produto produto8 = new Produto(2, "Mouse");
        Produto produto9 = new Produto(3, "Monitor");

        Map<Integer, Produto> produtosMap = new HashMap<>();
        produtosMap.put(1, produto7);
        produtosMap.put(2, produto8);
        produtosMap.put(3, produto9);
        System.out.println("Exercício sobre Map");
        System.out.println("Item produto dentro do Map: " + produtosMap.get(1).getNome());
        System.out.println("Existe Monitor no Map: " + produtosMap.containsValue(produto9));
        produtosMap.remove(2);
        System.out.println("Qtd de registros do Map: " + produtosMap.size());

        /*
        List → Qdo preciso de itens ordenados e com índice. Unicidade não importa
        Set  → Qdo não posso repetir os dados
        Map  → Cadastro de registro com chave e valor

        Para a parte 6, entendo que o Cliente pode fazer um pedido e cada pedido é único (Daria para usar o Set),
        porém, no Pedido ele pode ter produtos repetidos (usaria o List mesmo).

        Escolha a melhor estrutura:

        A) fila de pedidos onde a ordem de inserção importa.
        R: List

        B) conjunto de permissões onde não pode haver duplicação.
        R: Set

        C) produtos localizados pelo ID.
        R: Map
         */


        Cliente cliente1 = new Cliente("Julio");

        //Criando pedido
        Pedido pedido1 = new Pedido(1);


        //Adicionando produto ao pedido
        pedido1.adicionarProduto(produto1);
        pedido1.adicionarProduto(produto2);

        //Adicionando pedido ao cliente
        cliente1.adicionarPedido(pedido1);

        //Adicionando forma de pagamento
        Pagamento cartao = new PagamentoCartao();
        cartao.adicionarPagamento("cartao");
        pedido1.adicionarTipoPagamento(cartao);

        //listando o pedido
        cliente1.listarPedidos();
    }

    public static void imprimirDadosFuncionario (Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salario: " + funcionario.getSalario());
        System.out.println("Idade: " + funcionario.getIdade());
        System.out.println("Ativo: " + funcionario.isAtivo());
    }

   }
