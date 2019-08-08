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
            No pos = buscar(info);
        }
    }

    @Override
    public No buscar(String info) {
        NoEstado aux = inicio;
        
        /*while(aux != null && info < aux.getInfo())
            aux = aux.getProx();*/
        
        return null;
    }

    @Override
    public void exibir() {
    }
}
