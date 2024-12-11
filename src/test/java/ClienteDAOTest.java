

import com.ecommerceFICR.Model.clientes.Cliente;
import com.ecommerceFICR.Model.clientes.ClienteDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDAOTest {

    private ClienteDAO clienteDAO;

    @BeforeEach
    public void setUp() {
        clienteDAO = new ClienteDAO();
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
