package usagePath;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Contato contato;
    private String nickname;
    private List<Pixel> pixels = new ArrayList<>();

    public Usuario(Contato contato, String nickname, List<Pixel> pixels) {
        this.contato = contato;
        this.nickname = nickname;
        this.pixels = pixels;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    public void adicionarPixel(Pixel pixel) {

            pixels.add(pixel);
    }
}
