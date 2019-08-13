package classes;

public class ListaCidades {
    
    private NoCidade inicio;
    private NoCidade fim;

    public ListaCidades() {
        this.inicio = null;
        this.fim = null;
    }

    public NoCidade getInicio() {
        return inicio;
    }

    public void setInicio(NoCidade inicio) {
        this.inicio = inicio;
    }

    public NoCidade getFim() {
        return fim;
    }

    public void setFim(NoCidade fim) {
        this.fim = fim;
    }
    
    
    
    public void inserir(NoEstado estado, String infoNovaCidade) {
        NoCidade novaCidade = new NoCidade(null, null, infoNovaCidade);
        
        if(estado.getCidade() == null) {
            inicio = fim = novaCidade;
            estado.setCidade(this);
        } else {
            NoCidade pos = buscar(infoNovaCidade);
            
            if(pos == null) { //ultima caixa
                fim.setBaixo(novaCidade);
                novaCidade.setCima(fim);
                fim = novaCidade;
            } else {
                if(infoNovaCidade.compareToIgnoreCase(pos.getInfo()) != 0) {
                    if(pos.getCima()== null) {
                        pos.setCima(novaCidade);
                        novaCidade.setBaixo(pos);
                        inicio = novaCidade;
                    } else {
                        novaCidade.setBaixo(pos);
                        pos.getCima().setBaixo(novaCidade);
                        novaCidade.setCima(pos.getCima());
                        pos.setCima(novaCidade);
                    }
                }
            }
        }
    }
    
    private NoCidade buscar(String info) {
        NoCidade aux = inicio;
        
        while(aux != null && info.compareToIgnoreCase(aux.getInfo()) > 0)
            aux = aux.getBaixo();
        return aux;
    }
    
}
