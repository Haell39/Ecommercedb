package com.ecommerceFICR.Model.produtosetor;

public abstract class Produto {
    private int idProduto;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;
    private String descricao;

    public Produto() {}

    public Produto(int idProduto, String nome, String categoria, String descricao, double preco, int quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidade;
    }

    // Método abstrato que deve ser implementado pelas classes filhas
    public abstract double calcularDesconto();

    // Getters e Setters
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
