import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class ConexaoFactoryTest {
    
    @Test
    public void testConexao() {
        try (Connection conexao = ConexaoFactory.getConexao()) {
            assertNotNull(conexao);
            assertTrue(conexao.isValid(1));
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }
} 