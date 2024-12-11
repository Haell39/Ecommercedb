package com.ecommerceFICR.Interface;

import com.ecommerceFICR.Model.produtosetor.Produto;
import java.util.List;

public interface EstoqueProdutosGeral {
    void adicionarProduto(Produto produto);
    Produto buscarProdutoPorId(int idProduto);
    void atualizarProduto(Produto produto);
    void removerProduto(int idProduto);
    List<Produto> listarTodos();
}