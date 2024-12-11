package com.ecommerceFICR.Controller;

import com.ecommerceFICR.Interface.CadastroCliente;
import com.ecommerceFICR.Model.clientes.ClienteConcreto;

import java.util.Scanner;

public class ClienteController {
    private final CadastroCliente repositorioClientes;
    private final Scanner input;

    public ClienteController(CadastroCliente repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
        this.input = new Scanner(System.in);
    }

    public void cadastrarCliente() {
        System.out.println("Digite os dados do cliente:");
        System.out.print("ID: ");
        int idCliente = input.nextInt();
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("CPF: ");
        String cpf = input.next();
        System.out.print("Endereço: ");
        String endereco = input.next();
        System.out.print("Email: ");
        String email = input.next();

        ClienteConcreto novoCliente = new ClienteConcreto(idCliente, nome, cpf, endereco, email);
        repositorioClientes.cadastrarCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void atualizarCliente() {
        System.out.print("Digite o ID do cliente a ser atualizado: ");
        int idCliente = input.nextInt();
        var cliente = repositorioClientes.buscarClientePorId(idCliente);

        if (cliente != null) {
            System.out.print("Novo nome: ");
            cliente.setNome(input.next());
            repositorioClientes.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void listarTodos() {
        System.out.println("Lista de Clientes:");
        repositorioClientes.listarTodos().forEach(System.out::println);
    }

    public void removerCliente() {
        System.out.print("Digite o ID do cliente a ser deletado: ");
        int idCliente = input.nextInt();
        repositorioClientes.removerCliente(idCliente);
        System.out.println("Cliente deletado com sucesso!");
    }

    public void buscarClientePorID() {
        System.out.print("Digite o ID do cliente: ");
        int idCliente = input.nextInt();
        var cliente = repositorioClientes.buscarClientePorId(idCliente);

        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}
