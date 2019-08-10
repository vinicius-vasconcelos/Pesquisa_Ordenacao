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
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }
    
    //-------------- Métodos de Pesquisa
    /*public int busca_exaustiva(int chave) {
    }
    
    public int busca_sentinela(int chave) {
    }
    
    public int busca_sequencial(int chave) {
    }
    
    public int busca_binaria() {
    }
    
    //-------------- Métodos de Ordenação
    
    public void insercao_direta() {
       
    }*/
    
}
