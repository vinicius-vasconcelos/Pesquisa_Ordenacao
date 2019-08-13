package classes;

public class ListaEstados {
    private NoEstado inicio;
    private NoEstado fim;
    private ListaCidades cabCidades;

    public ListaEstados() {
        this.inicio = null;
        this.fim = null;
    }
    
    public void inicializar() {
        inicio = fim = null;
    }

    public void inserir(String estado, String cidade) {
        NoEstado novoEstado = new NoEstado(null, null, null, estado);
        NoEstado auxEst = null;
        
        if(inicio == null) {
            inicio = fim = novoEstado;
            
            cabCidades = new ListaCidades();
            inicio.setCidade(cabCidades);
            cabCidades.inserir(inicio, cidade);
        }
        else {
            NoEstado pos = buscar(estado);
            
            if(pos == null) { //ultima caixa
                fim.setProx(novoEstado);
                novoEstado.setAnt(fim);
                fim = novoEstado;
               
                cabCidades = new ListaCidades();
                fim.setCidade(cabCidades);
                cabCidades.inserir(fim, cidade);
            } else {
                if(estado.compareToIgnoreCase(pos.getInfo()) != 0) {
                    if(pos.getAnt()== null) {
                        pos.setAnt(novoEstado);
                        novoEstado.setProx(pos);
                        inicio = novoEstado;
                      
                        cabCidades = new ListaCidades();
                        inicio.setCidade(cabCidades);
                        cabCidades.inserir(inicio, cidade);
                    } else {
                        novoEstado.setProx(pos);
                        pos.getAnt().setProx(novoEstado);
                        novoEstado.setAnt(pos.getAnt());
                        pos.setAnt(novoEstado);
                        
                        cabCidades = new ListaCidades();
                        pos.setCidade(cabCidades);
                        cabCidades.inserir(pos, cidade);
                    }
                    
                } else  pos.getCidade().inserir(pos, cidade);
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
            
            auxCid = auxEst.getCidade().getInicio();
            while(auxCid != null) {
                System.out.println("\t" + auxCid.getInfo());
                auxCid = auxCid.getBaixo();
            }
            auxEst = auxEst.getProx();
        }
    }
    
    public NoEstado buscaEstado(String info) {
        NoEstado aux = inicio;
        
        while(aux != null && info.compareToIgnoreCase(aux.getInfo()) > 0)
            aux = aux.getProx();
        
        if(aux != null && info.compareToIgnoreCase(aux.getInfo()) == 0)
            return aux;
        return null;
    }
    
    public NoCidade buscaCidade(String info) {
        NoEstado aux = inicio;
        NoCidade auxCid = null;
        
        while(aux != null) {
            auxCid = aux.getCidade().getInicio();
            while(auxCid != null && info.compareToIgnoreCase(auxCid.getInfo()) > 0)
                auxCid = auxCid.getBaixo();
            
            aux = aux.getProx();
            
            if(auxCid != null && info.compareToIgnoreCase(auxCid.getInfo()) == 0)
                aux = null;
        }
  
        if(auxCid != null && info.compareToIgnoreCase(auxCid.getInfo()) == 0)
            return auxCid;
        return null;
    }
    
    
    public boolean buscaPar(String estado, String cidade) {
        if(buscaEstado(estado) != null)
            if(buscaCidade(cidade) != null)
                return true;
        
        return false;
    }
}
