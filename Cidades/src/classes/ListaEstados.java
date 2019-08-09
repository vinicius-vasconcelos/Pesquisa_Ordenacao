package classes;

public class ListaEstados extends Lista{
    private NoEstado inicio;
    private NoEstado fim;

    public ListaEstados() {
        this.inicio = null;
        this.fim = null;
    }
    
    @Override
    public void inicializar() {
    }

    @Override
    public void inserir(String info) {
        NoEstado novoEstado = new NoEstado(null, null, null, info);
        
        if(inicio == null)
            inicio = fim = novoEstado;
        else {
            NoEstado pos = buscar(info);
            
            if(pos == null) { //ultima caixa
                fim.setProx(novoEstado);
                novoEstado.setAnt(fim);
                fim = novoEstado;
            } else {
                if(info.compareToIgnoreCase(pos.getInfo()) == 1){
                    pos.getProx().setAnt(novoEstado);
                    novoEstado.setProx(pos.getProx());
                    pos.setProx(novoEstado);
                    novoEstado.setAnt(pos);
                }
            }
        }
    }
    public NoEstado buscar(String info) {
        NoEstado aux = inicio;
        
        while(aux != null && info.compareToIgnoreCase(aux.getInfo()) == -1)
            aux = aux.getProx();
        
        return aux;
    }

    @Override
    public void exibir() {
        NoEstado aux = inicio;
        
        while(aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }
}
