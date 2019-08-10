package classes;

public class NoEstado{
    private NoEstado ant;
    private NoEstado prox;
    private NoCidade cidade;
    
    private String info;

    public NoEstado(NoEstado ant, NoEstado prox, NoCidade cidade, String info) {
        this.ant = ant;
        this.prox = prox;
        this.cidade = cidade;
        this.info = info;
    }

    public NoEstado getAnt() {
        return ant;
    }

    public void setAnt(NoEstado ant) {
        this.ant = ant;
    }

    public NoEstado getProx() {
        return prox;
    }

    public void setProx(NoEstado prox) {
        this.prox = prox;
    }

    public NoCidade getCidade() {
        return cidade;
    }

    public void setCidade(NoCidade cidade) {
        this.cidade = cidade;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
