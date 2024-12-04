package usagePath;

public class Contato {
    private int id;
    private String telefone;
    private String email;

    public Contato(int id, String telefone, String email) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarContato() {
        // Implementação para mostrar os detalhes do contato
    }
}
