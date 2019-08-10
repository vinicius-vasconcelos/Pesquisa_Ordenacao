package classes;

public class ListaEstados {
    private NoEstado inicio;
    private NoEstado fim;
    private ListaCidades cabCidades;

    public ListaEstados() {
        this.inicio = null;
        this.fim = null;
        cabCidades = new ListaCidades();
    }
    
    public void inicializar() {
        inicio = fim = null;
    }

    public void inserir(String estado, String cidade) {
        NoEstado novoEstado = new NoEstado(null, null, null, estado);
        
        if(inicio == null) {
            inicio = fim = novoEstado;
            cabCidades.inserir(inicio, new NoCidade(null, cidade));
        }
        else {
            NoEstado pos = buscar(estado);
            
            if(pos == null) { //ultima caixa
                fim.setProx(novoEstado);
                novoEstado.setAnt(fim);
                fim = novoEstado;
                
               cabCidades.inserir(fim, new NoCidade(null, cidade));
            } else {
                if(estado.compareToIgnoreCase(pos.getInfo()) != 0) {
                    if(pos.getAnt()== null) {
                        pos.setAnt(novoEstado);
                        novoEstado.setProx(pos);
                        inicio = novoEstado;
                        
                       cabCidades.inserir(inicio, new NoCidade(null, cidade));
                    } else {
                        novoEstado.setProx(pos);
                        pos.getAnt().setProx(novoEstado);
                        novoEstado.setAnt(pos.getAnt());
                        pos.setAnt(novoEstado);
                        
                        cabCidades.inserir(novoEstado, new NoCidade(null, cidade)); 
                    }
                }
            }
        }
    }
    
    private NoEstado buscar(String info) {
        NoEstado aux = inicio;
        
        while(aux != null && info.compareToIgnoreCase(aux.getInfo()) > 0)
            aux = aux.getProx();
        return aux;
    }

    public void exibir() {
        NoEstado auxEst = inicio;
        NoCidade auxCid = null;
        
        while(auxEst != null) {
            System.out.println(auxEst.getInfo());
            
            auxCid = auxEst.getCidade();
            while(auxCid != null) {
                System.out.println("\t" + auxCid.getInfo());
                auxCid = auxCid.getBaixo();
            }
            auxEst = auxEst.getProx();
        }
    }
}
