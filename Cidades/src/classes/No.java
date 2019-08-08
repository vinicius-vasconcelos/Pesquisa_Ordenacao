package classes;

public abstract class No {
    private No ant;
    private No prox;
    private String info;

    public No(No ant, No prox, String info) {
        this.ant = ant;
        this.prox = prox;
        this.info = info;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
