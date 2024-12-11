package com.ecommerceFICR.Model.produtosetor;

public class ProdutoConcreto extends Produto {

    public ProdutoConcreto(int idProduto, String nome, String categoria, String descricao, double preco, int quantidade) {
        super(idProduto, nome, categoria, descricao, preco, quantidade);
    }

    @Override
    public double calcularDesconto() {
        // Exemplo simples de cálculo de desconto (pode ser modificado conforme necessidade)
        return getPreco() * 0.10; // 10% de desconto
    }
}
