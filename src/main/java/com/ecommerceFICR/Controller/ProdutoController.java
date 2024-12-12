package com.ecommerceFICR.Controller;

import com.ecommerceFICR.Interface.EstoqueProdutosGeral;
import com.ecommerceFICR.Model.produtosetor.ProdutoConcreto;

import java.util.Scanner;

public class ProdutoController {
    private final EstoqueProdutosGeral estoqueProdutos;
    private final Scanner input;

    public ProdutoController(EstoqueProdutosGeral estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
        this.input = new Scanner(System.in);
    }

    public void cadastrarProduto() {
        System.out.println("Digite os dados do produto:");
        System.out.print("ID: ");
        int idProduto = input.nextInt();
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("Categoria: ");
        String categoria = input.next();
        System.out.print("Descrição: ");
        String descricao = input.next();
        System.out.print("Preço: ");
        double preco = input.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = input.nextInt();

        ProdutoConcreto novoProduto = new ProdutoConcreto(idProduto, nome, categoria, descricao, preco, quantidade);
        estoqueProdutos.adicionarProduto(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void atualizarProduto() {
        System.out.print("Digite o ID do produto a ser atualizado: ");
        int idProduto = input.nextInt();
        var produto = estoqueProdutos.buscarProdutoPorId(idProduto);

        if (produto != null) {
            System.out.print("Novo nome: ");
            produto.setNome(input.next());
            System.out.print("Nova quantidade: ");
            produto.setQuantidadeEstoque(input.nextInt());
            estoqueProdutos.atualizarProduto(produto);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void listarTodos() {
        System.out.println("Lista de Produtos:");
        estoqueProdutos.listarTodos().forEach(System.out::println);
    }

    public void removerProduto() {
        System.out.print("Digite o ID do produto a ser deletado: ");
        int idProduto = input.nextInt();
        estoqueProdutos.removerProduto(idProduto);
        System.out.println("Produto deletado com sucesso!");
    }

    public void buscarProdutoPorId() {
        System.out.print("Digite o ID do produto: ");
        int idProduto = input.nextInt();
        var produto = estoqueProdutos.buscarProdutoPorId(idProduto);

        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}
