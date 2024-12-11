package com.ecommerceFICR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexao {
    public static void main(String[] args) {
        Connection conexao = null;
        try {
            // Carregar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Corrigir a string de conexão
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "deuscura1");

            // Executar a consulta
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM clientes");

            // Iterar pelos resultados
            while (rsCliente.next()) {
                System.out.println("Nome: " + rsCliente.getString("nome"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro de conexão ou execução de SQL: " + e.getMessage());
        } finally {
            // Fechar a conexão com o banco
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
