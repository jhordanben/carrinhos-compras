package br.com.improving.main;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.improving.carrinho.CarrinhoCompras;
import br.com.improving.carrinho.CarrinhoComprasFactory;
import br.com.improving.carrinho.Produto;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        CarrinhoComprasFactory factory = new CarrinhoComprasFactory();

        System.out.println("Digite o identificador do cliente: ");
        String identificacaoCliente = scanner.nextLine();
        CarrinhoCompras carrinho = factory.criar(identificacaoCliente);

        while (true) {

            System.out.println("Digite o nome do produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.println("Digite o código do produto: ");
            Long codigo = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Digite a descrição do produto: ");
            String descricao = scanner.nextLine();

            // validar se os dados são válidos
            if (nomeProduto == null || nomeProduto.isEmpty() || descricao == null || descricao.isEmpty()) {
                System.out.println("Nome e descrição não podem ser vazios.");
                continue;
            }

            System.out.println("Digite o preço unitário do produto: ");
            BigDecimal valorUnitario = scanner.nextBigDecimal();

            System.out.println("Digite a quantidade do produto: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            // criando e adicionando o produto no carrinho
            Produto produto = new Produto(nomeProduto, codigo, descricao);
            carrinho.adicionarItem(produto, valorUnitario, quantidade);

            // perguntar se o usuário quer continuar ou sair do loop
            System.out.println("Deseja continuar adicionando produtos? (S/N)");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
        }

        // exibir o valor total do carrinho
        System.out.println("Valor total do carrinho do cliente " + identificacaoCliente + ": " + carrinho.getValorTotal());

        // exibir o ticket médio
        BigDecimal ticketMedio = factory.getValorTicketMedio();
        System.out.println("Ticket médio: " + ticketMedio);

        // invalidar o carrinho do cliente
        boolean invalidado = factory.invalidar(identificacaoCliente);
        System.out.println("Carrinho do cliente " + identificacaoCliente + " invalidado: " + invalidado);

        // calcular e exibir o ticket médio após a invalidação
        ticketMedio = factory.getValorTicketMedio();
        System.out.println("Ticket médio após a invalidação: " + ticketMedio);

        scanner.close();
    }
}
