package classes;

public class NoCidade {
    private NoCidade baixo;
    private NoCidade cima;
    private String info;

    public NoCidade(NoCidade baixo, NoCidade cima, String info) {
        this.baixo = baixo;
        this.cima = cima;
        this.info = info;
    }

    public NoCidade getBaixo() {
        return baixo;
    }

    public void setBaixo(NoCidade baixo) {
        this.baixo = baixo;
    }

    public NoCidade getCima() {
        return cima;
    }

    public void setCima(NoCidade cima) {
        this.cima = cima;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
