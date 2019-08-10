package classes;

public class NoCidade {
    private NoCidade baixo;
    private String info;

    public NoCidade(NoCidade baixo, String info) {
        this.baixo = baixo;
        this.info = info;
    }

    public NoCidade getBaixo() {
        return baixo;
    }

    public void setBaixo(NoCidade baixo) {
        this.baixo = baixo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
