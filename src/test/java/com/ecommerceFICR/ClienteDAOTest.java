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
            public void registrarCompra(double valor) {}
        };
        cliente.setIdCliente(200);
        cliente.setNome("Maria Silva");
        cliente.setEmail("maria@email.com");
        cliente.setCpf("12345678901");
        cliente.setEndereco("Rua das Flores, 123");

        clienteDAO.salvar(cliente);

        Cliente clienteRecuperado = clienteDAO.buscar(200);

        assertNotNull(clienteRecuperado);
        assertEquals("Maria Silva", clienteRecuperado.getNome());
        assertEquals("maria@email.com", clienteRecuperado.getEmail());
        assertEquals("12345678901", clienteRecuperado.getCpf());
        assertEquals("Rua das Flores, 123", clienteRecuperado.getEndereco());
        
        System.out.println("Cliente criado e recuperado com sucesso!");
        System.out.println("Nome: " + clienteRecuperado.getNome());
        System.out.println("Email: " + clienteRecuperado.getEmail());
    }

    @Test
    void testAdicionarVariosClientes() {
        // Cliente 1
        Cliente cliente1 = new Cliente() {
            @Override
            public void registrarCompra(double valor) {}
        };
        cliente1.setIdCliente(201);
        cliente1.setNome("Ana Silva");
        cliente1.setEmail("ana@email.com");
        cliente1.setCpf("11122233344");
        cliente1.setEndereco("Rua A, 123");
        clienteDAO.salvar(cliente1);

        // Cliente 2
        Cliente cliente2 = new Cliente() {
            @Override
            public void registrarCompra(double valor) {}
        };
        cliente2.setIdCliente(202);
        cliente2.setNome("Carlos Santos");
        cliente2.setEmail("carlos@email.com");
        cliente2.setCpf("22233344455");
        cliente2.setEndereco("Rua B, 456");
        clienteDAO.salvar(cliente2);

        System.out.println("Clientes adicionados com sucesso!");
        System.out.println("Cliente 1: " + cliente1.getNome());
        System.out.println("Cliente 2: " + cliente2.getNome());
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