package usagePath;

public class Pixel {
    private String nome;
    private String descricao;
    private String agente;
    private String habilidade;
    private boolean isAprovado;

    public Pixel(String nome, String descricao, String agente, String habilidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.agente = agente;
        this.habilidade = habilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public boolean isAprovado() {
        return isAprovado;
    }

    public void setAprovado(boolean estado) {
        this.isAprovado = estado;
    }

    public void exibirDetalhes() {

        if (isAprovado){
            System.out.println("Pixel: " + this.nome +
                    "\nDescrição: " + this.descricao +
                    "\nAgente: " + this.agente +
                    "\nHabilidade: " + this.habilidade +
                    "\n-=-=-=-=-=-=-=-=-=-");
        } else {
            System.out.println("Pixel necessita de aprovação.");
        }

    }
}

