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
        // Criar um novo cliente
        Cliente cliente = new Cliente() {
            @Override
            public void registrarCompra(double valor) {
                // implementação do método abstrato
            }
        };
        cliente.setIdCliente(1);
        cliente.setNome("João Teste");
        cliente.setEmail("joao@teste.com");
        cliente.setCpf("12345678900");
        cliente.setEndereco("Rua Teste, 123");

        // Salvar no banco
        clienteDAO.salvar(cliente);

        // Buscar o cliente salvo
        Cliente clienteRecuperado = clienteDAO.buscar(1);

        // Verificar se os dados estão corretos
        assertNotNull(clienteRecuperado);
        assertEquals("João Teste", clienteRecuperado.getNome());
        assertEquals("joao@teste.com", clienteRecuperado.getEmail());
        assertEquals("12345678900", clienteRecuperado.getCpf());
        assertEquals("Rua Teste, 123", clienteRecuperado.getEndereco());
        
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