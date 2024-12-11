package com.ecommerceFICR.Model.produtosetor;

public abstract class Produto {
    private int idProduto;
    private String nome;
    private String categoria;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(int idProduto, String nome, String categoria, String descricao, double preco, int quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método abstrato para calcular o desconto do produto
    public abstract double calcularDesconto();

    @Override
    public String toString() {
        return "Produto ID: " + idProduto + ", Nome: " + nome + ", Categoria: " + categoria + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}
