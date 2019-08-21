package classes;

public class NoEstado{
    private NoEstado ant;
    private NoEstado prox;
    private String info;
    private ListaCidades cidades;

    public NoEstado(NoEstado ant, NoEstado prox, ListaCidades cidades, String info) {
        this.ant = ant;
        this.prox = prox;
        this.cidades = cidades;
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

    public ListaCidades getCidades() {
        return cidades;
    }

    public void setCidades(ListaCidades cidades) {
        this.cidades = cidades;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
