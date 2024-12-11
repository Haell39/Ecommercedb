



import com.ecommerceFICR.Model.clientes.Cliente;
import com.ecommerceFICR.Model.clientes.ClienteDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteDAOTest {
    private ClienteDAO clienteDAO;

    @BeforeEach
    void setUp() {
        clienteDAO = new ClienteDAO();
    }

    @AfterEach
    void tearDown() {
        clienteDAO.closeEntityManager();
    }

    @Test
    void testCreateAndFind() {
        Cliente cliente = new Cliente(1, "João da Silva", "123.456.789-00", "Rua ABC, 123", "joao@example.com");
        clienteDAO.create(cliente);

        Cliente foundCliente = clienteDAO.find(1);
        assertNotNull(foundCliente);
        assertEquals(cliente.getIdCliente(), foundCliente.getIdCliente());
        assertEquals(cliente.getNome(), foundCliente.getNome());
        assertEquals(cliente.getCpf(), foundCliente.getCpf());
        assertEquals(cliente.getEndereco(), foundCliente.getEndereco());
        assertEquals(cliente.getEmail(), foundCliente.getEmail());
    }

    // Adicione mais testes para as operações de update e delete
}