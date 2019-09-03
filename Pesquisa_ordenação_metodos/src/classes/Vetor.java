package classes;

public class Vetor {
    private int vet[];
    private int TL;

    public Vetor() {
        this.vet = new int[100];
        this.TL = 0;
    }

    public int getTL() {
        return TL;
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
    
    public int busca_sequencial(int chave) {
        int pos = 0;
        
        while(pos < TL && chave > vet[pos])
            pos++;
        
        if(pos < TL && chave == vet[pos])
            return pos;
        return pos + TL;
    }
    
    public int busca_binaria(int chave) {
        int inicio = 0;
        int fim = TL;
        int meio = fim/2;
        
        while(inicio < meio && chave != vet[meio]) {
            
            if(chave < vet[meio])
                fim = meio;
            else
                inicio = meio + 1;
            
    
            meio = (inicio + fim) / 2;
        }
        
        if(chave == vet[meio])
            return meio;
        if(chave > vet[meio])
            return meio + TL + 1;
        return meio + TL;
    }
    
    public int busca_binaria2(int chave, int TL) {
        int inicio = 0;
        int fim = TL;
        int meio = fim/2;
        
        while(inicio < meio && chave != vet[meio]) {
            
            if(chave < vet[meio])
                fim = meio;
            else
                inicio = meio + 1;
            
    
            meio = (inicio + fim) / 2;
        }
       
        if(chave > vet[meio])
            return meio + 1;
        return meio;
    }
    
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
    
    public void insercao_binaria() {
        int pos, aux;
        
        for (int i = 1; i < TL; i++) {
            aux = vet[i];
            pos = busca_binaria2(aux, i);
            
            for (int j = i; j > pos; j--) 
                vet[j] = vet[j-1];
            
            vet[pos] = aux;
        }
    }
    
    public void selecao_direta() {
        int menor, j, pos;
        
        for (int i = 0; i < TL - 1; i++) {
            menor = vet[i];
            pos = i;
            
            for (j = i + 1; j < TL; j++){
                if(vet[j] < menor){
                    menor = vet[j];
                    pos = j;
                }
            }
            vet[pos] = vet[i];
            vet[i] = menor;     
        }
    }
    
    public void bubble_sort() {
        int TL2 = TL;
        int aux;
        
        while(TL2 > 1) {
            for(int i = 0; i < TL2-1; i++)
                if(vet[i] > vet[i+1]){
                    aux = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = aux;
                }
            TL2--;
        }
    }
    
    public void shake_sort() {
        int inicio = 0;
        int fim = TL;
        int aux, i;
        
        while(inicio < fim) {
            for(i = inicio; i < fim-1; i++)
                if(vet[i] > vet[i+1]){
                    aux = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = aux;
                }
            fim--;
            
            for(i = fim; i > inicio; i--)
                  if(vet[i] < vet[i-1]){
                      aux = vet[i];
                      vet[i] = vet[i-1];
                      vet[i-1] = aux;
                  }
            inicio++;
        }
    }
    
    public void heap_sort() {
        int aux, pai, FE, FD, maiorF;
        int TL2 = TL;
        
        while(TL2 > 1) {
            
            for(pai = (TL2/2) - 1; pai >= 0; pai --){
                FE = pai + pai + 1;
                FD = FE + 1;
                maiorF = FE;
                
                if(FD < TL2 && vet[FD] > vet[FE])
                    maiorF = FD;
                
                if(vet[maiorF] > vet[pai]){
                      aux = vet[pai];
                      vet[pai] = vet[maiorF];
                      vet[maiorF] = aux;
                  }    
            }
            
            aux = vet[0];
            vet[0] = vet[TL2-1];
            vet[TL2-1] = aux;
            TL2--;
        }
    }
}
