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
        ProdutoConcreto produto = new ProdutoConcreto(
            200,
            "Notebook Dell",
            "Eletrônicos",
            "Notebook Dell i7 16GB",
            4999.99,
            5
        );

        produtoDAO.salvar(produto);

        ProdutoConcreto produtoRecuperado = (ProdutoConcreto) produtoDAO.buscar(200);

        assertNotNull(produtoRecuperado);
        assertEquals("Notebook Dell", produtoRecuperado.getNome());
        assertEquals(4999.99, produtoRecuperado.getPreco());
        assertEquals(5, produtoRecuperado.getQuantidadeEstoque());
        
        System.out.println("Produto criado e recuperado com sucesso!");
        System.out.println("Nome: " + produtoRecuperado.getNome());
        System.out.println("Preço: R$" + produtoRecuperado.getPreco());
    }

    @Test
    void testAdicionarVariosProdutos() {
        // Produto 1
        ProdutoConcreto produto1 = new ProdutoConcreto(
            201,
            "Monitor Gaming",
            "Eletrônicos",
            "Monitor 144Hz 27 polegadas",
            1999.99,
            3
        );
        produtoDAO.salvar(produto1);

        // Produto 2
        ProdutoConcreto produto2 = new ProdutoConcreto(
            202,
            "Teclado Mecânico",
            "Periféricos",
            "Teclado RGB Switch Blue",
            299.99,
            10
        );
        produtoDAO.salvar(produto2);

        System.out.println("Produtos adicionados com sucesso!");
        System.out.println("Produto 1: " + produto1.getNome() + " - R$" + produto1.getPreco());
        System.out.println("Produto 2: " + produto2.getNome() + " - R$" + produto2.getPreco());
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