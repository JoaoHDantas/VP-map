package usagePath;

import java.util.List;

public class Admin {
    private String cargo;
    private List<String> permissoes;

    public Admin() {
    }

    public Admin(String cargo, List<String> permissoes) {
        this.cargo = cargo;
        this.permissoes = permissoes;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
    }

    public void aprovarPixel(Pixel pixel) {
        pixel.setAprovado(true);
    }

    public void rejeitarPixel(Pixel pixel) {
        pixel.setAprovado(false);
    }
}
