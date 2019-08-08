package classes;

public class NoEstado extends No{
    private NoCidade proxCidade;

    public NoEstado(NoCidade proxCidade, No ant, No prox, String info) {
        super(ant, prox, info);
        this.proxCidade = proxCidade;
    }

    public NoCidade getProxCidade() {
        return proxCidade;
    }

    public void setProxCidade(NoCidade proxCidade) {
        this.proxCidade = proxCidade;
    }
}
