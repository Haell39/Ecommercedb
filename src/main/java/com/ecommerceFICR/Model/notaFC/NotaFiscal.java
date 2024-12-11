package com.ecommerceFICR.Model.notaFC;

import com.ecommerceFICR.Interface.Pagamento;
import com.ecommerceFICR.Model.produtosetor.ProdutoConcreto;
import java.util.List;

public class NotaFiscal {
    private List<ProdutoConcreto> produtos;

    public NotaFiscal(List<ProdutoConcreto> produtos) {
        this.produtos = produtos;
    }

    public double calcularValorTotal() {
        return produtos.stream()
                .mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
                .sum();
    }

    public void realizarPagamento(Pagamento pagamento) {
        double valorTotal = calcularValorTotal();
        pagamento.processarPagamento(valorTotal); // Passa o valor total da nota fiscal para o pagamento
    }

    public List<ProdutoConcreto> getProdutos() {
        return produtos;
    }
}
