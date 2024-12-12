package com.ecommerceFICR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommercedb";
    private static final String USUARIO = "root";  // substitua pelo seu usuário do MySQL
    private static final String SENHA = "deuscura1";        // substitua pela sua senha do MySQL

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
} 