package com.ecommerceFICR.View;

import com.ecommerceFICR.Controller.ClienteController;
import com.ecommerceFICR.Controller.ProdutoController;
import com.ecommerceFICR.Interface.CadastroCliente;
import com.ecommerceFICR.Interface.EstoqueProdutosGeral;
import com.ecommerceFICR.Repository.EstoqueProdutos;
import com.ecommerceFICR.Repository.RepositorioCliente;

import java.util.Scanner;

public class Ecommerce {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EstoqueProdutosGeral estoqueProdutos = new EstoqueProdutos();
        CadastroCliente repositorioClientes = new RepositorioCliente();

        ProdutoController produtoController = new ProdutoController(estoqueProdutos);
        ClienteController clienteController = new ClienteController(repositorioClientes);

        MenuEcommerce menu = new MenuEcommerce();
        String continuar;
        int opcao;

        do {
            menu.menuPrincipal();
            opcao = input.nextInt();

            switch (opcao) {
                case 1:  // Gerenciar Produtos
                    gerenciarProdutos(input, menu, produtoController);
                    break;
                case 2:  // Gerenciar Clientes
                    gerenciarClientes(input, menu, clienteController);
                    break;
                case 3:  // Sair
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:  // Opção inválida
                    System.out.println("Opção inválida. Tente novamente!");
            }

            System.out.print("\nDeseja continuar? (sim/não): ");
            continuar = input.next();
        } while (continuar.equalsIgnoreCase("sim"));
    }

    private static void gerenciarProdutos(Scanner input, MenuEcommerce menu, ProdutoController produtoController) {
        int opProduto;
        boolean voltarAoMenuPrincipal = false;

        while (!voltarAoMenuPrincipal) {
            menu.menuProdutos();
            opProduto = input.nextInt();
            switch (opProduto) {
                case 1 -> produtoController.cadastrarProduto();
                case 2 -> produtoController.atualizarProduto();
                case 3 -> produtoController.listarTodos();
                case 4 -> produtoController.removerProduto();
                case 5 -> produtoController.buscarProdutoPorId();
                case 6 -> voltarAoMenuPrincipal = true;  // Voltar ao menu principal
                default -> System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }

    private static void gerenciarClientes(Scanner input, MenuEcommerce menu, ClienteController clienteController) {
        int opCliente;
        boolean voltarAoMenuPrincipal = false;

        while (!voltarAoMenuPrincipal) {
            menu.menuClientes();
            opCliente = input.nextInt();
            switch (opCliente) {
                case 1 -> clienteController.cadastrarCliente();
                case 2 -> clienteController.atualizarCliente();
                case 3 -> clienteController.listarTodos();
                case 4 -> clienteController.removerCliente();
                case 5 -> clienteController.buscarClientePorID();
                case 6 -> voltarAoMenuPrincipal = true;  // Voltar ao menu principal
                default -> System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }
}