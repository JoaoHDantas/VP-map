import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PixelFacadeTest {
    private usagePath.PixelFacade pixelFacade;

    @BeforeEach
    void setUp() throws SQLException {
        pixelFacade = new usagePath.PixelFacade();

        // Limpa a tabela antes de cada teste
        try (Connection conexao = usagePath.ConexaoBanco.getConexao()) {
            String sql = "DELETE FROM pixels";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.executeUpdate();
            }
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        // Limpa a tabela após cada teste
        try (Connection conexao = usagePath.ConexaoBanco.getConexao()) {
            String sql = "DELETE FROM pixels";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.executeUpdate();
            }
        }
    }

    @Test
    void testCriarPixel() {
        // Dados para o pixel
        String nome = "PixelTest";
        String descricao = "Descrição de teste";
        String agente = "AgenteTest";
        String habilidade = "HabilidadeTest";

        // Executa o método criarPixel
        pixelFacade.criarPixel(nome, descricao, agente, habilidade);

        // Recupera os pixels do banco para validar
        List<String> pixels = pixelFacade.getPixels();

        // Valida que há exatamente 1 pixel no banco
        assertEquals(1, pixels.size(), "Deve haver exatamente 1 pixel no banco");

        // Valida que o nome do pixel é igual ao esperado
        String pixelInfo = pixels.get(0);
        boolean contemNome = pixelInfo.contains(nome);
        assertEquals(true, contemNome, "O nome do pixel criado deve estar na lista");
    }
}
