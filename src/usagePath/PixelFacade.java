package usagePath;

import java.util.ArrayList;
import java.util.List;

public class PixelFacade {
    private List<String> pixels;

    public PixelFacade() {
        this.pixels = new ArrayList<>();
    }

    public void criarPixel(String nome, String descricao, String agente, String habilidade) {
        if (nome.isEmpty() || descricao.isEmpty() || agente.isEmpty() || habilidade.isEmpty()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
        }

        String pixelDetalhes = String.format("Nome: %s, Agente: %s, Habilidade: %s", nome, agente, habilidade);
        pixels.add(pixelDetalhes);
    }

    public List<String> getPixels() {
        return pixels;
    }
}
