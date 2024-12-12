package com.ecommerceFICR;

import com.ecommerceFICR.Model.clientes.Cliente;
import com.ecommerceFICR.Model.clientes.ClienteDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteDAOTest {
    private ClienteDAO clienteDAO;
    private Connection conexao;

    @BeforeEach
    void setUp() {
        conexao = ConexaoFactory.getConexao();
        clienteDAO = new ClienteDAO(conexao);
    }

    @Test
    void testCriarEBuscarCliente() {
        Cliente cliente = new Cliente() {
            @Override
            public void registrarCompra(double valor) {
                // implementação do método abstrato
            }
        };
        cliente.setIdCliente(1);
        cliente.setNome("Maria Silva");
        cliente.setEmail("maria@email.com");
        cliente.setCpf("12345678901");
        cliente.setEndereco("Rua das Flores, 123");

        clienteDAO.salvar(cliente);

        Cliente clienteRecuperado = clienteDAO.buscar(1);

        assertNotNull(clienteRecuperado);
        assertEquals("Maria Silva", clienteRecuperado.getNome());
        assertEquals("maria@email.com", clienteRecuperado.getEmail());
        assertEquals("12345678901", clienteRecuperado.getCpf());
        assertEquals("Rua das Flores, 123", clienteRecuperado.getEndereco());
        
        System.out.println("Cliente criado e recuperado com sucesso!");
        System.out.println("Nome: " + clienteRecuperado.getNome());
        System.out.println("Email: " + clienteRecuperado.getEmail());
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
    // rest of the file remains the same 