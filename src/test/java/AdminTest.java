import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    private usagePath.Admin admin;
    private usagePath.Pixel pixel;

    @BeforeEach
    void setUp() {
        // Configuração inicial antes de cada teste
        List<String> permissoes = new ArrayList<>();
        permissoes.add("GERENCIAR_PIXELS");
        permissoes.add("VISUALIZAR_RELATORIOS");

        admin = new usagePath.Admin("Gerente", permissoes);
        pixel = new usagePath.Pixel("PixelTest", "Descrição de teste", "AgenteTest", "HabilidadeTest");
    }

    @Test
    void testGetters() {
        // Testando os métodos getters
        assertEquals("Gerente", admin.getCargo());
        assertEquals(2, admin.getPermissoes().size());
        assertTrue(admin.getPermissoes().contains("GERENCIAR_PIXELS"));
    }

    @Test
    void testSetters() {
        // Testando os métodos setters
        List<String> novasPermissoes = new ArrayList<>();
        novasPermissoes.add("EDITAR_PIXELS");
        admin.setCargo("Supervisor");
        admin.setPermissoes(novasPermissoes);

        assertEquals("Supervisor", admin.getCargo());
        assertEquals(1, admin.getPermissoes().size());
        assertTrue(admin.getPermissoes().contains("EDITAR_PIXELS"));
    }

    @Test
    void testAprovarPixel() {
        // Testando o método aprovarPixel
        admin.aprovarPixel(pixel);
        assertTrue(pixel.isAprovado());
    }

    @Test
    void testRejeitarPixel() {
        // Testando o método rejeitarPixel
        admin.rejeitarPixel(pixel);
        assertFalse(pixel.isAprovado());
    }
}
