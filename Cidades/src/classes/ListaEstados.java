package classes;

public class ListaEstados {
    private NoEstado inicio;
    private NoEstado fim;

    public ListaEstados() {
        this.inicio = null;
        this.fim = null;
    }
    
    public void inicializar() {
        inicio = fim = null;
    }

    public void inserir(String novoEstado, String novaCidade) {
        
        NoEstado auxPontEstado = buscar(novoEstado);
        
        if(auxPontEstado == null) { //inserir estado
            NoEstado newNoEstado = new NoEstado(null, null, new ListaCidades(), novoEstado);
            
            if(inicio == null) //lista vazia
                inicio = fim = newNoEstado;
            else { //ultima caixa
                fim.setProx(newNoEstado);
                newNoEstado.setAnt(fim);
                fim = newNoEstado;
            }
           newNoEstado.getCidades().inserir(novaCidade);
                
        } else { 
            
            if(novoEstado.compareToIgnoreCase(auxPontEstado.getInfo()) != 0) { 
                NoEstado newNoEstado = new NoEstado(null, null, new ListaCidades(), novoEstado);
                
                if(auxPontEstado.getAnt()== null) { //inserindo no início
                    auxPontEstado.setAnt(newNoEstado);
                    newNoEstado.setProx(auxPontEstado);
                    inicio = newNoEstado;

                } else { //inserindo no meio
                    newNoEstado.setProx(auxPontEstado);
                    auxPontEstado.getAnt().setProx(newNoEstado);
                    newNoEstado.setAnt(auxPontEstado.getAnt());
                    auxPontEstado.setAnt(newNoEstado);
                }
                newNoEstado.getCidades().inserir(novaCidade);
            } else //estado já existente
                auxPontEstado.getCidades().inserir(novaCidade);
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
   
        while(auxEst != null) {
            System.out.println(auxEst.getInfo());
            auxEst.getCidades().exibirCidades();
            auxEst = auxEst.getProx();
        }
    }
    
    public NoEstado buscarEstado(String info) {
        NoEstado aux = inicio;
        
        while(aux != null && info.compareToIgnoreCase(aux.getInfo()) > 0)
            aux = aux.getProx();
        
        if(aux != null && info.compareToIgnoreCase(aux.getInfo()) == 0)
            return aux;
        return null;
    }
    
    public NoCidade buscarCidade(String info) {
       NoEstado auxEst = inicio;
       NoCidade cid = null;
   
        while(auxEst != null) {
            cid = auxEst.getCidades().buscarCidade(info);
            auxEst = auxEst.getProx();
        }
         if(cid != null && info.compareToIgnoreCase(cid.getInfo()) == 0)
            return cid;
        return null;
       
    }
    
    
    /*public boolean buscaPar(String estado, String cidade) {
        if(buscaEstado(estado) != null)
            if(buscaCidade(cidade) != null)
                return true;
        
        return false;
    }*/
}
