package com.juliodias.retorno;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.juliodias.common.utils.StatusPedido;
import com.juliodias.domain.*;
import com.juliodias.pagamento.Pagamento;
import com.juliodias.pagamento.PagamentoCartao;
import com.juliodias.repository.Repositorio;
import com.juliodias.notificacao.*;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        double salarioAnual;

        try {
            Funcionario funcionario1 = new Funcionario("Julio", 44, 10000, false);
            imprimirDadosFuncionario(funcionario1);
            salarioAnual = funcionario1.calcularSalarioAnual();
            System.out.println("Salário anual: " + salarioAnual);

            /*if (funcionario1.aumentarPercentualSalario(10)) {
                System.out.println("Aumento salarial");
                System.out.println("Salário mensal após aumento salarial:" + funcionario1.getSalario());
            } else {
                System.out.println("Percentual de aumento salarial deve ser maior que 0");
            }*/

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

            /*if (funcionario2.aumentarPercentualSalario(-5)) {
                System.out.println("Aumento salarial");
                System.out.println("Salário mensal após aumento salarial:" + funcionario2.getSalario());
            } else {
                System.out.println("Percentual de aumento salarial deve ser maior que 0");
            }*/

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

        //Criar repositorio Produto
        Repositorio<Produto> repositorioProduto = new Repositorio<Produto>();
        repositorioProduto.adicionar(produto1);
        repositorioProduto.adicionar(produto2);
        repositorioProduto.adicionar(produto3);
        repositorioProduto.adicionar(produto4);

        System.out.println( "Item buscado: " + repositorioProduto.buscar(2).getNome());
        repositorioProduto.remover(produto3);
        System.out.println("Quantidade: " + repositorioProduto.quantidade());
        produtos = repositorioProduto.listar();
        for (Produto p : produtos) {
            System.out.println(p.getNome());
        }

        Cliente cliente1 = new Cliente("Julio");
        Cliente cliente2 = new Cliente("Ana");

        //Criar repositorio Cliente
        Repositorio<Cliente> repositorioCliente = new Repositorio<Cliente>();
        repositorioCliente.adicionar(cliente1);
        repositorioCliente.adicionar(cliente2);

        System.out.println( "Item buscado: " + repositorioCliente.buscar(1).getNome());
        repositorioCliente.remover(cliente2);
        System.out.println("Quantidade: " + repositorioCliente.quantidade());
        List<Cliente> clientes = repositorioCliente.listar();
        for (Cliente c : clientes) {
            System.out.println(c.getNome());
        }


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

        //Dia 13 - Lambda
        List<Produto> produtosList = new ArrayList<>();

        // 5 produtos com preços diferentes
        produto1.setPreco(1234);
        produto2.setPreco(5678);
        produto3.setPreco(789);
        produto4.setPreco(900);
        produto5.setPreco(1200);


        produtosList.add(produto1);
        produtosList.add(produto2);
        produtosList.add(produto3);
        produtosList.add(produto4);
        produtosList.add(produto5);

        //Parte 1 - impimir o nome
        //produtosList.forEach( produto -> System.out.println(produto.getNome()));

        //Parte 2 - imprimir nome e preço de cada produto

        produtosList.forEach( produto -> {
            System.out.print(produto.getNome());
            System.out.println(" R$" + produto.getPreco());
        });
        System.out.println("***********");

        //Parte 3 - Ordenar por preço via lambda
        produtosList.sort(Comparator.comparing(Produto::getPreco));

        produtosList.forEach(produto -> {
            System.out.print(produto.getNome());
            System.out.println(" R$" + produto.getPreco());
        });
        System.out.println("***********");

        //Parte 4 - Ordenar por nome
        produtosList.sort(Comparator.comparing(Produto::getNome, String.CASE_INSENSITIVE_ORDER));

        produtosList.forEach(produto -> {
            System.out.println(produto.getNome());
        });

        System.out.println("***********");

        //Parte 5 - Comparar duas formas de pensar
        List<Produto> ordenacao3 = new ArrayList<>(produtosList);
        boolean trocado;
        do {
            trocado = false;
            for (int i = 1; i < ordenacao3.size(); i++) {
                Produto atual = ordenacao3.get(i - 1);
                Produto proximo = ordenacao3.get(i);
                if (atual.getPreco() > proximo.getPreco()) {
                    // troca
                    ordenacao3.set(i - 1, proximo);
                    ordenacao3.set(i, atual);
                    trocado = true;
                }
            }
        } while (trocado);
        for(Produto produto:ordenacao3) {
            System.out.println(produto.getPreco());
        }
        System.out.println();
        //Outra forma
        produtosList.sort(Comparator.comparing(Produto::getPreco));
        produtosList.forEach(produto -> {
            System.out.println(produto.getPreco());
        });
        System.out.println();

        //Parte 6 - Criar uma regra própria
        produtosList.sort(Comparator.comparing(Produto::getNome, String.CASE_INSENSITIVE_ORDER).reversed().thenComparing(Produto::getPreco));
        produtosList.forEach(produto -> {
            System.out.print(produto.getNome());
            System.out.println(" R$ " + produto.getPreco());
        });

        System.out.println();
        //Parte 7 - Desafio
        produtosList.forEach(produtoA -> {
            if (produtoA.getPreco() > 1000) {
                System.out.println(produtoA.getNome() + " -> R$ " + produtoA.getPreco());
            }
        });

        //Dia 14 - Stream
        System.out.println("\n *** Dia 14 *** \n");
        //Parte 1 - produtos com preço maior que R$ 1.000. e O resultado deve conter apenas os produtos que atendem à condição, sem alterar a lista original
        System.out.println("Mais que 1000");
        List<Produto> produtosFiltrados = produtosList.stream()
                .filter(preco -> preco.getPreco() > 1000)
                .toList();
        produtosFiltrados.forEach(produto -> {
            System.out.print(produto.getNome());
            System.out.println(" R$ " + produto.getPreco());
        });

        //Parte 2 - prodtos menores que 1000
        System.out.println("\n Menos que 1000");
        produtosFiltrados = produtosList.stream()
                .filter(preco -> preco.getPreco() < 1000)
                .toList();
        produtosFiltrados.forEach(produto -> {
            System.out.print(produto.getNome());
            System.out.println(" R$ " + produto.getPreco());
        });

        //Parte 3 - Obter os nomes com map
        System.out.println("\n Utilização de map");
        List<String> produtosFiltrado = produtosList.stream()
                .map(Produto::getNome)
                .collect(Collectors.toList());
        System.out.println("ProdutosFiltrado: " + produtosFiltrado);

        //Parte 4 - obtenha os nomes dos produtos com preço maior que R$ 1.000
        System.out.println("\n Utilização de filter e de map");
        produtosFiltrado = produtosList.stream()
                .filter(preco -> preco.getPreco() > 1000)
                .map(Produto::getNome)
                .collect(Collectors.toList());
        System.out.println("ProdutosFiltrado: " + produtosFiltrado);

        //Parte 5 - Ordenação do maior para o menor e o inverso - preço
        System.out.println("\n Ordenação - menor para o maior preço");
        List<Produto> produtosOrdenado = produtosList.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList();
        produtosOrdenado.forEach(produto -> {
            System.out.print(produto.getNome());
            System.out.println(" R$ " + produto.getPreco());
        });

        System.out.println("\n Ordenação - maior para o menor preço");
        produtosOrdenado = produtosList.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList()
                .reversed();
        produtosOrdenado.forEach(produto -> {
            System.out.print(produto.getNome());
            System.out.println(" R$ " + produto.getPreco());
        });

        //Parte 6 - Obtenha os nomes dos produtos com preço acima de determinado valor, ordenados pelo preço.
        produtosFiltrado = produtosList.stream()
                .filter(produto -> produto.getPreco() > 800)
                .sorted(Comparator.comparing(Produto::getPreco))
                .map(Produto::getNome)
                .toList();
        System.out.println("Aplicado filtros da Pipeline: " + produtosFiltrado);

        System.out.println("**** Dia 15 **** \n");
        //Dia 15 - Revisão dos conceitos aprendidos até aqui -Consulta de produtos
        //Consulta - todos os produtos acima de 1000
        produtosFiltrados = produtosList.stream()
                .filter(produto -> produto.getPreco() > 1000)
                .toList();
        System.out.println("Produtos acima de 1.000 : ");
        for (Produto produtoA : produtosFiltrados) {
            System.out.println(produtoA.getNome());
        }

        //Consulta - todos os produtos acima de 1000 e devolve apenas os nomes
        produtosFiltrado = produtosList.stream()
                .filter(produto -> produto.getPreco() > 1000)
                .map(Produto::getNome)
                .toList();
        System.out.println("Produtos acima de 1.000 : ");
        System.out.println(produtosFiltrado);

        //Consulta Ordenada - menor para o maior
        produtosFiltrado = produtosList.stream()
                .filter(produto -> produto.getPreco() > 1000)
                .sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .map(Produto::getNome)
                .toList();
        System.out.println("Produtos acima de 1.000 Ordenados do menor para o maior: ");
        System.out.println(produtosFiltrado);

        //Consulta Ordenada - maior para o menor
        produtosFiltrado = produtosList.stream()
                .filter(produto -> produto.getPreco() > 1000)
                .sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .map(Produto::getNome)
                .toList()
                .reversed();
        System.out.println("Produtos acima de 1.000 Ordenados do menor para o maior: ");
        System.out.println(produtosFiltrado);

        //Listar produtosList para saber se modificou a lista
        System.out.println("Conteúdo da Lista original: ");
        for(Produto produtoA : produtosList) {
            System.out.println(produtoA.getNome() +  " R$ " + produtoA.getPreco());
        }

        //Parte 8 - Obtenha a lista do repositório e faça pelo menos uma das consultas anteriores utilizando essa lista.
        Repositorio<Produto> produtoRepositorioStream = new Repositorio<>();

        produtoRepositorioStream.adicionar(produto1);
        produtoRepositorioStream.adicionar(produto2);
        produtoRepositorioStream.adicionar(produto3);
        produtoRepositorioStream.adicionar(produto4);
        produtoRepositorioStream.adicionar(produto5);

        System.out.println("Lista de Produtos do Repositório");
        produtosFiltrado = produtoRepositorioStream.listar().stream()
                .filter(produto -> produto.getPreco() < 1300)
                .sorted( (p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()) )
                .map(Produto::getNome)
                .toList();
        System.out.println(produtosFiltrado);


        //Dia 16 - Records
        System.out.println("\n Dia 16 - Records");
        ProductRecord produtoRecord1 = new ProductRecord(1L, "mesa", 1200);
        ProductRecord produtoRecord2 = new ProductRecord(2L,"cadeira", 980);

        System.out.println("Produtos de uma classe record: " + produtoRecord1.nome());
        System.out.println("Produtos de uma classe record: " + produtoRecord2.nome());

        System.out.println(produtoRecord1);

        ProductRecord produtoRecord3 = new ProductRecord(1L, "mesa", 1200);


        System.out.println("Produtos iguais ? R: " + produtoRecord3.equals(produtoRecord1));
        //System.out.println(produtoRecord3.preco() == produtoRecord1.preco());

        //productRecord produtoRecord4 = new productRecord(4L, "mesa", -9);

        System.out.println("Preço do produto é caro:  " + produtoRecord3.precoCaro() );


        //Dia 17 - Exception
        System.out.println("Dia 17 - Exceptions");

        try {
            Funcionario func1 = new Funcionario("Julio", 45, 40000, true);
            Funcionario func2 = new Funcionario("Cezar", 45, -40000, true);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Funcionario func3 = new Funcionario("Julio", 45, 40000, true);
            System.out.println("Antes do aumento: " + func3.getSalario());
            func3.aumentarPercentualSalario(20);
            System.out.println("Depois do aumento1: " + func3.getSalario());
            func3.aumentarPercentualSalario(-10);
            System.out.println("Depois do aumento2: " + func3.getSalario());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Funcionario func4 = new Funcionario("Ana", 45, -20000, true);
            System.out.println("Antes do aumento: " + func4.getSalario());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar o funcionario: " + e.getMessage());
        }
        try{
            Funcionario func5 = new Funcionario("Julia", 33, 20000, true);
            func5.aumentarPercentualSalario(-15);
        } catch (IllegalArgumentException e1) {
            System.out.println("Erro ao aumentar o salario: " + e1.getMessage());
        }

        try {
            ProductRecord produtoRecord4 = new ProductRecord(1L, "Fone", -120);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Produto de um record: " + e.getMessage());
        }

        //Dia 18 - Enums
        System.out.println("\n dia 18 - Enums");

        Pedido  pedido = new Pedido(10);
        System.out.println("Status do pedido    : " + pedido.getStatusPedido());
        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);

        //Pagar Pedido
        try {
            pedido.pagarPedido();
            System.out.println("Status do pedido    : " + pedido.getStatusPedido());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        }

        //Enviar Pedido
        try {
            pedido.enviarPedido();
            System.out.println("Status do pedido    : " + pedido.getStatusPedido());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());;
        }

        //Entregar Pedido
        try {
            pedido.entregarPedido();
            System.out.println("Status do pedido    : " + pedido.getStatusPedido());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        }

        //Transições inválidas
        System.out.println("Transições inválidas");
        Pedido  pedido2 = new Pedido(11);
        pedido2.adicionarProduto(produto1);
        // CRIADO -> ENVIADO
        try{
            pedido2.enviarPedido();
            System.out.println("Status do pedido2    : " + pedido.getStatusPedido());
        }catch (IllegalStateException e) {
            System.out.println(e.getMessage());;
        }


    }

    public static void imprimirDadosFuncionario (Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salario: " + funcionario.getSalario());
        System.out.println("Idade: " + funcionario.getIdade());
        System.out.println("Ativo: " + funcionario.isAtivo());
    }

   }
