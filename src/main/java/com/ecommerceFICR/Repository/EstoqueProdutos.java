package com.ecommerceFICR.Repository;

import com.ecommerceFICR.Interface.EstoqueProdutosGeral;
import com.ecommerceFICR.Model.produtosetor.Produto;

import java.util.ArrayList;
import java.util.List;

public class EstoqueProdutos implements EstoqueProdutosGeral {
    private List<Produto> produtos;

    public EstoqueProdutos() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public Produto buscarProdutoPorId(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void atualizarProduto(Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getIdProduto() == produtoAtualizado.getIdProduto()) {
                produtos.set(i, produtoAtualizado);
                return;
            }
        }
    }

    @Override
    public void removerProduto(int idProduto) {
        produtos.removeIf(produto -> produto.getIdProduto() == idProduto);
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }
}