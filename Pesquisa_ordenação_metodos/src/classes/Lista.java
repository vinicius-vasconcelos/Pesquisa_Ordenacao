package classes;

public class Lista {
    private No inicio;
    private No fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void inicializar() {
        inicio = fim = null;
    }
    
    public void inserirNoInicio(int info) {
        No novaCaixa = new No(null, null, info);
        
        if(inicio == null)
            inicio = fim = novaCaixa;
        else {
            inicio.setAnt(novaCaixa);
            novaCaixa.setProx(inicio);
            inicio = novaCaixa;
        }
    }
    
    public void inserirNoFinal(int info) {
       No novaCaixa = new No(null, null, info);
        
        if(fim == null)
            inicio = fim = novaCaixa;
        else {
            fim.setProx(novaCaixa);
            novaCaixa.setAnt(fim);
            fim = novaCaixa;
        } 
    }
    
     public void remover(int info) {
        
    }
    
    public void exibir() {
        No aux = inicio;
        
        while(aux != null) {
            System.out.print(aux.getInfo() + " | ");
            aux = aux.getProx();
        }
    }
    
    //-------------- Métodos de Pesquisa
    public No busca_exaustiva(int chave) {
        No aux = inicio;
        
        while(aux != null && aux.getInfo() != chave)
            aux = aux.getProx();
       
        return aux;
    }
    
    public No busca_sentinela(int chave) {
        inserirNoFinal(chave);
        No aux = inicio;
        
        while(aux.getInfo() != chave)
            aux = aux.getProx();
        
        if(fim == aux)
            return null;
        return aux;
    }
    
    public No busca_sequencial(int chave) {
        No aux = inicio;
        
        while(aux != null && chave > aux.getInfo())
            aux = aux.getProx();
        
        return aux;
    }
    
    private No retornaMeio(No newIni, No newFim) {
        No aux = newIni;
        No newMeio = newIni;
        int count = 0;
        
        while(aux != newFim) {
            count++;
            aux = aux.getProx();
        }
        
        for (int i = 0; i < count / 2; i++) 
            newMeio = newMeio.getProx();
        
        return newMeio;
    }
    
    public No busca_binaria(int chave) {
        No begin = inicio;
        No end =  fim;
        No meio = retornaMeio(begin, end);
        
        while(begin != meio && chave != meio.getInfo()) {
            if(chave < meio.getInfo())
                end = meio;
            else
                begin = meio.getProx();
            
            meio = retornaMeio(begin, end);
        }
       
        return meio;
    }
    
    public No busca_binaria2(int chave, No TL) {
        No begin = inicio;
        No end =  TL;
        No meio = retornaMeio(begin, end);
        
        while(begin != meio && chave != meio.getInfo()) {
            if(chave < meio.getInfo())
                end = meio;
            else
                begin = meio.getProx();
            
            meio = retornaMeio(begin, end);
        }   
       
        if(chave > meio.getInfo())
            return meio.getProx();
        return meio;
    }
    
    //-------------- Métodos de Ordenação
    
    public void insercao_direta() {
        No pos = null;
        int aux = 0;
        
        for(No i = inicio.getProx(); i != null; i = i.getProx()) {
            aux = i.getInfo();
            pos = i;
            
            while(pos != inicio && aux < pos.getAnt().getInfo()) {
                pos.setInfo(pos.getAnt().getInfo());
                pos = pos.getAnt();
            }
            
            pos.setInfo(aux);
        }
    }
    
     public void insercao_binaria() {
        No pos = null;
        int aux = 0;
        
        for (No i = inicio.getProx(); i != null; i = i.getProx()) {
            aux = i.getInfo();
            pos = busca_binaria2(aux, i);
            
            for (No j = i; j != pos; j = j.getAnt()) 
                j.setInfo(j.getAnt().getInfo());
            
            pos.setInfo(aux);
        }
    }
     
     public void selecao_direta() {
       int menor;
       No j, pos;

       for (No i = inicio; i.getProx() != null ; i = i.getProx()) {
           menor = i.getInfo();
           pos = i;

           for (j = i.getProx(); j != null; j= j.getProx()){
               if(j.getInfo() < menor){
                   menor = j.getInfo();
                   pos = j;
               }
           }
           pos.setInfo(i.getInfo());
           i.setInfo(menor);
       }
   }
    
}
