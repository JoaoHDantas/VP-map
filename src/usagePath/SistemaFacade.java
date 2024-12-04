package usagePath;

public class SistemaFacade {
    private Usuario usuario;
    private Admin admin;

    public SistemaFacade(Usuario usuario, Admin admin) {
        this.usuario = usuario;
        this.admin = admin;
    }

    public void criarPixel(String nome, String descricao, String agente, String habilidade) {
        Pixel pixel = new Pixel(nome, descricao, agente, habilidade);
        usuario.adicionarPixel(pixel);
    }

    public void aprovarPixel(Pixel pixel) {
        admin.aprovarPixel(pixel);
    }

    public void rejeitarPixel(Pixel pixel) {
        admin.rejeitarPixel(pixel);
    }

    public void visualizarPixel(Pixel pixel) {
        pixel.exibirDetalhes();
    }
}
