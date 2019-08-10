package classes;

public class Vetor {
    private int vet[];
    private int TL;

    public Vetor() {
        this.vet = new int[100];
        this.TL = 0;
    }
    
    public void exibir() {
        for (int i = 0; i < TL; i++)
            System.out.print(vet[i] + "  |  ");
    }
    
    public void inserir(int valor) {
        vet[TL] = valor;
        TL++;
    }
    
    //-------------- Métodos de Pesquisa
    public int busca_exaustiva(int chave) {
        int pos = 0;

        while(pos < TL && vet[pos] != chave)
          pos++;

        if(pos < TL)
          return pos;
        return -1;
    }
    
   public int busca_sentinela(int chave) {
       int pos = 0;
       vet[++TL] = chave;
       TL++;

        while(vet[pos] != chave)
          pos++;

        TL--;
        
        if(pos != TL)
          return pos;
        return -1;
    }
    
    /*public int busca_sequencial(int chave) {
        
    }
    
    public int busca_binaria() {
        
    }*/
    
    //-------------- Métodos de Ordenação
    
    public void insercao_direta() {
        int pos = 0;
        int aux = 0;
        
        for(int i = 1; i < TL; i++) {
            aux = vet[i];
            pos = i;
           
            while(pos > 0 && aux < vet[pos-1]) {
                vet[pos] = vet[pos-1];
                pos--;
            }
            
            vet[pos] = aux;
        }
    }
}
