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
        for (int i = 0; i < TL; i++) {
            System.out.print(vet[i] + "  |  ");
        }
    }

    public void inserir(int valor) {
        vet[TL] = valor;
        TL++;
    }

    //-------------- Métodos de Pesquisa
    public int busca_exaustiva(int chave) {
        int pos = 0;

        while (pos < TL && vet[pos] != chave) {
            pos++;
        }

        if (pos < TL) {
            return pos;
        }
        return -1;
    }

    public int busca_sentinela(int chave) {
        int pos = 0;
        vet[++TL] = chave;
        TL++;

        while (vet[pos] != chave) {
            pos++;
        }

        TL--;

        if (pos != TL) {
            return pos;
        }
        return -1;
    }

    public int busca_sequencial(int chave) {
        int pos = 0;

        while (pos < TL && chave > vet[pos]) {
            pos++;
        }

        if (pos < TL && chave == vet[pos]) {
            return pos;
        }
        return pos + TL;
    }

    public int busca_binaria(int chave) {
        int inicio = 0;
        int fim = TL;
        int meio = fim / 2;

        while (inicio < meio && chave != vet[meio]) {

            if (chave < vet[meio]) {
                fim = meio;
            } else {
                inicio = meio + 1;
            }

            meio = (inicio + fim) / 2;
        }

        if (chave == vet[meio]) {
            return meio;
        }
        if (chave > vet[meio]) {
            return meio + TL + 1;
        }
        return meio + TL;
    }

    public int busca_binaria2(int chave, int TL) {
        int inicio = 0;
        int fim = TL;
        int meio = fim / 2;

        while (inicio < meio && chave != vet[meio]) {

            if (chave < vet[meio]) {
                fim = meio;
            } else {
                inicio = meio + 1;
            }

            meio = (inicio + fim) / 2;
        }

        if (chave > vet[meio]) {
            return meio + 1;
        }
        return meio;
    }

    //-------------- Métodos de Ordenação
    public void insercao_direta() {
        int pos = 0;
        int aux = 0;

        for (int i = 1; i < TL; i++) {
            aux = vet[i];
            pos = i;

            while (pos > 0 && aux < vet[pos - 1]) {
                vet[pos] = vet[pos - 1];
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

            for (int j = i; j > pos; j--) {
                vet[j] = vet[j - 1];
            }

            vet[pos] = aux;
        }
    }

    public void selecao_direta() {
        int menor, j, pos;

        for (int i = 0; i < TL - 1; i++) {
            menor = vet[i];
            pos = i;

            for (j = i + 1; j < TL; j++) {
                if (vet[j] < menor) {
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

        while (TL2 > 1) {
            for (int i = 0; i < TL2 - 1; i++) {
                if (vet[i] > vet[i + 1]) {
                    aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                }
            }
            TL2--;
        }
    }

    public void shake_sort() {
        int inicio = 0;
        int fim = TL;
        int aux, i;

        while (inicio < fim) {
            for (i = inicio; i < fim - 1; i++) {
                if (vet[i] > vet[i + 1]) {
                    aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                }
            }
            fim--;

            for (i = fim; i > inicio; i--) {
                if (vet[i] < vet[i - 1]) {
                    aux = vet[i];
                    vet[i] = vet[i - 1];
                    vet[i - 1] = aux;
                }
            }
            inicio++;
        }
    }

    public void heap_sort() {
        int aux, pai, FE, FD, maiorF;
        int TL2 = TL;

        while (TL2 > 1) {

            for (pai = (TL2 / 2) - 1; pai >= 0; pai--) {
                FE = pai + pai + 1;
                FD = FE + 1;
                maiorF = FE;

                if (FD < TL2 && vet[FD] > vet[FE]) {
                    maiorF = FD;
                }

                if (vet[maiorF] > vet[pai]) {
                    aux = vet[pai];
                    vet[pai] = vet[maiorF];
                    vet[maiorF] = aux;
                }
            }

            aux = vet[0];
            vet[0] = vet[TL2 - 1];
            vet[TL2 - 1] = aux;
            TL2--;
        }
    }

    public void shell_sort() {
        int i, j, k, aux;
        int dist = 4;

        while (dist > 0) {
            for (i = 0; i < dist; i++) {
                for (j = i; j + dist < TL; j = j + dist) {
                    if (vet[j] > vet[j + dist]) {
                        aux = vet[j];
                        vet[j] = vet[j + dist];
                        vet[j + dist] = aux;
                        k = j;

                        while (k - dist >= 0 && vet[k] < vet[k - dist]) {
                            aux = vet[k];
                            vet[k] = vet[k - dist];
                            vet[k - dist] = aux;
                            k = k - dist;
                        }
                    }
                }
            }

            dist = dist / 2;
        }
    }

    public void quick_sort() {
        quick_sort_sp(0, TL - 1);
    }

    private void quick_sort_sp(int ini, int fim) {
        int i = ini;
        int j = fim;
        int aux;

        while (i < j) {
            while (i < j && vet[i] <= vet[j]) {
                i++;
            }
            if (i < j) {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }

            while (i < j && vet[j] >= vet[i]) {
                j--;
            }
            if (i < j) {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }
        }

        if (ini < i - 1) {
            quick_sort_sp(ini, i - 1);
        }
        if (j + 1 < fim) {
            quick_sort_sp(i + 1, fim);
        }
    }

    public void quick_sort_pivot() {
        quick_sort_pv(0, TL - 1);
    }

    private void quick_sort_pv(int ini, int fim) {
        int i = ini;
        int j = fim;
        int pivot = vet[(i + j) / 2];
        int aux;

        while (i < j) {
            while (vet[i] < pivot) {
                i++;
            }
 
            while (vet[j] > pivot) {
                j--;
            }
            
            if(i <= j) {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
                
                i++;
                j++;
            }
        }

        if (ini < j) {
            quick_sort_pv(ini, j);
        }
        if (i < fim) {
            quick_sort_pv(i, fim);
        }
    }
    
    public void merge_sort() {
        int vet1[] = new int [TL/2];
        int vet2[] = new int [TL/2];
        int seq = 1;
        
        //while(seq < TL) {
            //particao(vet1, vet2);
    }

    public void gnome_sort() {
        int aux, i, j;

        for (i = 0; i < TL - 1; i++) {
            if (vet[i] > vet[i + 1]) {
                aux = vet[i];
                vet[i] = vet[i + 1];
                vet[i + 1] = aux;

                j = i;
                while (j > 0 && vet[j] < vet[j - 1]) {
                    aux = vet[j];
                    vet[j] = vet[j - 1];
                    vet[j - 1] = aux;
                    j--;
                }

            }
        }
    }

    public void comb_sort() {
        int aux;
        int gap = (int) (TL / 1.3);

        while (gap > 0) {
            for (int i = 0; i + gap < TL; i++) {
                if (vet[i] > vet[i + gap]) {
                    aux = vet[i];
                    vet[i] = vet[i + gap];
                    vet[i + gap] = aux;
                }
            }
            gap /= 1.3;
        }
    }

    public void radix_sort() {
        int vetAux[] = new int[TL];
        int vetCount[] = new int[10];
        int maiorVet = 0;
        int div = 1;
        int pos, pos2;

        for (int i = 0; i < TL; i++) {
            if (vet[i] > maiorVet) {
                maiorVet = vet[i];
            }
        }

        while ((maiorVet / div) > 0) {

            for (int i = 0; i < TL; i++) {
                vetCount[(vet[i] / div) % 10]++;
            }

            for (int i = 0; i < vetCount.length - 1; i++) {
                vetCount[i + 1] = vetCount[i] + vetCount[i + 1];
            }

            for (int i = TL - 1; i >= 0; i--) {
                pos = (vet[i] / div) % 10;
                vetCount[pos]--;
                pos2 = vetCount[pos];
                vetAux[pos2] = vet[i];
            }

            for (int i = 0; i < TL; i++) {
                vet[i] = vetAux[i];
            }

            div *= 10;

            for (int i = 0; i < vetCount.length; i++) {
                vetCount[i] = 0;
            }
        }
    }

}
