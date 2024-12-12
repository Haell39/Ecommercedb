package com.ecommerceFICR.Repository;

import com.ecommerceFICR.Model.produtosetor.Produto;
import com.ecommerceFICR.Model.produtosetor.ProdutoConcreto;

import java.sql.*;

// ... resto do código do DAO permanece igual ... 
public class ProdutoDAO {
    private Connection conexao;
    
    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
        criarTabelaSeNaoExistir();
    }
    
    private void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS produtos (
                id_produto INT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                categoria VARCHAR(50) NOT NULL,
                preco DOUBLE NOT NULL,
                quantidade_estoque INT NOT NULL,
                descricao TEXT
            )
        """;
        
        try (Statement stmt = conexao.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela de produtos", e);
        }
    }
    
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (id_produto, nome, categoria, preco, quantidade_estoque, descricao) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, produto.getIdProduto());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getCategoria());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getQuantidadeEstoque());
            stmt.setString(6, produto.getDescricao());
            
            stmt.executeUpdate();
            System.out.println("Produto salvo com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto", e);
        }
    }
    
    public ProdutoConcreto buscar(int id) {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ProdutoConcreto(
                    rs.getInt("id_produto"),
                    rs.getString("nome"),
                    rs.getString("categoria"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade_estoque")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto", e);
        }
    }
} 