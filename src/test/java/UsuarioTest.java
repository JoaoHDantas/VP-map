import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    private usagePath.Usuario usuario;
    private usagePath.Contato contato;
    private usagePath.Pixel pixel1;
    private usagePath.Pixel pixel2;

    @BeforeEach
    void setUp() {
        // Configuração inicial antes de cada teste
        contato = new usagePath.Contato(1, "1234-5678", "teste@exemplo.com");
        List<usagePath.Pixel> pixelList = new ArrayList<>();
        pixel1 = new usagePath.Pixel("Pixel1", "Descrição1", "Agente1", "Habilidade1");
        pixel2 = new usagePath.Pixel("Pixel2", "Descrição2", "Agente2", "Habilidade2");
        pixelList.add(pixel1);

        usuario = new usagePath.Usuario(contato, "UserTest", pixelList);
    }

    @Test
    void testGetters() {
        // Testando os métodos getters
        assertEquals(contato, usuario.getContato());
        assertEquals("UserTest", usuario.getNickname());
        assertEquals(1, usuario.getPixels().size());
        assertTrue(usuario.getPixels().contains(pixel1));
    }

    @Test
    void testSetters() {
        // Testando os métodos setters
        usagePath.Contato novoContato = new usagePath.Contato(2, "9876-5432", "novo@exemplo.com");
        usuario.setContato(novoContato);
        usuario.setNickname("NewNickname");

        List<usagePath.Pixel> novaLista = new ArrayList<>();
        novaLista.add(pixel2);
        usuario.setPixels(novaLista);

        assertEquals(novoContato, usuario.getContato());
        assertEquals("NewNickname", usuario.getNickname());
        assertEquals(1, usuario.getPixels().size());
        assertTrue(usuario.getPixels().contains(pixel2));
    }

    @Test
    void testAdicionarPixel() {
        // Testando o método adicionarPixel
        usuario.adicionarPixel(pixel2);

        assertEquals(2, usuario.getPixels().size());
        assertTrue(usuario.getPixels().contains(pixel2));
    }
}
