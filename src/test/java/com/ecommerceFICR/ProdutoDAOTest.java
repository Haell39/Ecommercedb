package com.ecommerceFICR;

import com.ecommerceFICR.Model.produtosetor.ProdutoConcreto;
import com.ecommerceFICR.Repository.ProdutoDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoDAOTest {
    private ProdutoDAO produtoDAO;
    private Connection conexao;

    @BeforeEach
    void setUp() {
        conexao = ConexaoFactory.getConexao();
        produtoDAO = new ProdutoDAO(conexao);
    }

    @Test
    void testCriarEBuscarProduto() {
        // Criar um novo produto
        ProdutoConcreto produto = new ProdutoConcreto(
            1,
            "Notebook Gamer",
            "Eletrônicos",
            "Notebook Gamer Intel i7, 16GB RAM",
            3999.99,
            10
        );

        // Salvar no banco
        produtoDAO.salvar(produto);

        // Buscar o produto salvo
        ProdutoConcreto produtoRecuperado = (ProdutoConcreto) produtoDAO.buscar(1);

        // Verificar se os dados estão corretos
        assertNotNull(produtoRecuperado);
        assertEquals("Notebook Gamer", produtoRecuperado.getNome());
        assertEquals(3999.99, produtoRecuperado.getPreco());
        assertEquals(10, produtoRecuperado.getQuantidadeEstoque());
        assertEquals("Notebook Gamer Intel i7, 16GB RAM", produtoRecuperado.getDescricao());
        
        System.out.println("Produto criado e recuperado com sucesso!");
        System.out.println("Nome: " + produtoRecuperado.getNome());
        System.out.println("Preço: R$" + produtoRecuperado.getPreco());
        System.out.println("Estoque: " + produtoRecuperado.getQuantidadeEstoque());
    }

    @AfterEach
    void tearDown() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 