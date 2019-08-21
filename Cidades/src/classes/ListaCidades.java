package classes;

public class ListaCidades {
    
    private NoCidade inicio;
    private NoCidade fim;

    public ListaCidades() {
        this.inicio = null;
        this.fim = null;
    }

    /*public NoCidade getInicio() {
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
    }*/
    
    public void inserir(String infoNovaCidade) {
      NoCidade auxPontNoCidade = buscar(infoNovaCidade);
      
      if(auxPontNoCidade == null) { //inserir cidade
            NoCidade newNoCidade = new NoCidade(null, null, infoNovaCidade);
            
            if(inicio == null) //lista vazia
                inicio = fim = newNoCidade;
            else { //ultima caixa
                fim.setBaixo(newNoCidade);
                newNoCidade.setCima(fim);
                fim = newNoCidade;
            }
                
        }else {  
            if(infoNovaCidade.compareToIgnoreCase(auxPontNoCidade.getInfo()) != 0) { 
                NoCidade newNoCidade = new NoCidade(null, null, infoNovaCidade);
                
                if(auxPontNoCidade.getCima()== null) { //inserindo no início
                    auxPontNoCidade.setCima(newNoCidade);
                    newNoCidade.setBaixo(auxPontNoCidade);
                    inicio = newNoCidade;

                } else { //inserindo no meio
                    newNoCidade.setBaixo(auxPontNoCidade);
                    auxPontNoCidade.getCima().setBaixo(newNoCidade);
                    newNoCidade.setCima(auxPontNoCidade.getCima());
                    auxPontNoCidade.setCima(newNoCidade);
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
    
    
    public void exibirCidades() {
        NoCidade auxCid = inicio;
        
        while(auxCid != null) {
            System.out.println("\t" + auxCid.getInfo());
            auxCid = auxCid.getBaixo();
        }
    }
    
    public NoCidade buscarCidade(String info) {
        NoCidade aux = inicio;
        
        while(aux != null && info.compareToIgnoreCase(aux.getInfo()) > 0)
            aux = aux.getBaixo();
        
        if(aux != null && info.compareToIgnoreCase(aux.getInfo()) == 0)
            return aux;
        return null;
    }
    
}
