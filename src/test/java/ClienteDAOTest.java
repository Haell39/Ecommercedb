import com.ecommerceFICR.Model.clientes.Cliente;
import com.ecommerceFICR.Model.clientes.ClienteDAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDAOTest {

    private ClienteDAO clienteDAO;
    private Connection conexao;

    @BeforeEach
    public void setUp() {
        conexao = ConexaoFactory.getConexao();
        clienteDAO = new ClienteDAO(conexao);
        
        limparTabelaCliente();
    }

    @AfterEach
    public void tearDown() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void limparTabelaCliente() {
        try {
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate("DELETE FROM clientes");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSalvarCliente() {
        Cliente cliente = new Cliente() {
            @Override
            public void registrarCompra(double valor) {
                
            }
        };
        cliente.setIdCliente(1);
        cliente.setNome("Manuel");
        cliente.setEmail("manuel@email.com");
        cliente.setCpf("12345644900");
        cliente.setEndereco("Rua das lolo");

        clienteDAO.salvar(cliente);

        Cliente clienteBuscado = clienteDAO.buscar(1);
        assertNotNull(clienteBuscado);
        assertEquals(cliente.getNome(), clienteBuscado.getNome());
    }
}
