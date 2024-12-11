package com.ecommerceFICR.Model.clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection conexao;
    
    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
        criarTabelaSeNaoExistir();
    }
    
    private void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS clientes (
                id_cliente INT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL,
                cpf VARCHAR(11) NOT NULL,
                endereco VARCHAR(200) NOT NULL
            )
        """;
        
        try (Statement stmt = conexao.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela de clientes", e);
        }
    }
    
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (id_cliente, nome, email, cpf, endereco) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEndereco());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente", e);
        }
    }
    
    public Cliente buscar(int id) {
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente() {
                    @Override
                    public void registrarCompra(double valor) {
                        // Implementação necessária
                    }
                };
                
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                
                return cliente;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente", e);
        }
    }
}
