import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {
    private usagePath.Contato contato;

    @BeforeEach
    void setUp() {
        // Configura um objeto Contato para os testes
        contato = new usagePath.Contato(1, "1234-5678", "teste@exemplo.com");
    }

    @Test
    void testGetters() {
        // Testa os métodos getters
        assertEquals(1, contato.getId());
        assertEquals("1234-5678", contato.getTelefone());
        assertEquals("teste@exemplo.com", contato.getEmail());
    }

    @Test
    void testSetters() {
        // Testa os métodos setters
        contato.setId(2);
        contato.setTelefone("8765-4321");
        contato.setEmail("novoemail@exemplo.com");

        assertEquals(2, contato.getId());
        assertEquals("8765-4321", contato.getTelefone());
        assertEquals("novoemail@exemplo.com", contato.getEmail());
    }

    @Test
    void testMostrarContato() {
        // Teste para o método mostrarContato
        // Neste caso, apenas verificamos que ele não lança exceções
        assertDoesNotThrow(() -> contato.mostrarContato());
    }
}
