import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PixelTest {
    private usagePath.Pixel pixel;

    @BeforeEach
    void setUp() {
        // Configura o ambiente para os testes
        pixel = new usagePath.Pixel("PixelTest", "Descrição de teste", "AgenteTest", "HabilidadeTest");
    }

    @Test
    void testGettersAndSetters() {
        // Testando os getters e setters
        pixel.setNome("NovoNome");
        pixel.setDescricao("Nova descrição");
        pixel.setAgente("Novo Agente");
        pixel.setHabilidade("Nova Habilidade");
        pixel.setAprovado(true);

        assertEquals("NovoNome", pixel.getNome());
        assertEquals("Nova descrição", pixel.getDescricao());
        assertEquals("Novo Agente", pixel.getAgente());
        assertEquals("Nova Habilidade", pixel.getHabilidade());
        assertTrue(pixel.isAprovado());
    }

    @Test
    void testExibirDetalhesAprovado() {
        // Testando exibição de detalhes quando aprovado
        pixel.setAprovado(true);

        // Verificar se os detalhes estão sendo exibidos corretamente
        // Em um teste real, você usaria alguma técnica para capturar o `System.out.println`.
        // Aqui estamos apenas verificando o comportamento do método.
        assertDoesNotThrow(() -> pixel.exibirDetalhes());
    }

    @Test
    void testExibirDetalhesNaoAprovado() {
        // Testando exibição de detalhes quando não aprovado
        pixel.setAprovado(false);

        // Verificar se a mensagem correta é exibida
        // Aqui novamente, apenas verificamos que o método não lança exceções
        assertDoesNotThrow(() -> pixel.exibirDetalhes());
    }
}
