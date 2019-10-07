package classes;

public class Lista {

    private No inicio;
    private No fim;
    private int TAM;

    public Lista() {
        this.inicio = null;
        this.fim = null;
        this.TAM = 0;
    }

    public void inicializar() {
        inicio = fim = null;
    }

    public int tamanho() {
        No aux = inicio;
        int cont = 0;

        while (aux != null) {
            cont++;
            aux = aux.getProx();
        }
        return cont;
    }

    public No get(int pos) {
        No aux = inicio;
        for (int i = 0; aux != null && i < pos; i++) {
            aux = aux.getProx();
        }
        return aux;
    }

    public int getInt(No pos) {
        No aux = inicio;
        int i = 0;
        while (aux != pos) {
            aux = aux.getProx();
            i++;
        }
        return i;
    }

    public No getNo(int pos) {
        No aux = inicio;
        int cont = 0;
        while (aux != null && pos != cont) {
            cont++;
            aux = aux.getProx();
        }

        return aux;
    }

    public void inserirNoInicio(int info) {
        No novaCaixa = new No(null, null, info);

        if (inicio == null) {
            inicio = fim = novaCaixa;
        } else {
            inicio.setAnt(novaCaixa);
            novaCaixa.setProx(inicio);
            inicio = novaCaixa;
        }

        TAM++;
    }

    public void inserirNoFinal(int info) {
        No novaCaixa = new No(null, null, info);

        if (fim == null) {
            inicio = fim = novaCaixa;
        } else {
            fim.setProx(novaCaixa);
            novaCaixa.setAnt(fim);
            fim = novaCaixa;
        }

        TAM++;
    }

    public void remover(int info) {

    }

    public void exibir() {
        No aux = inicio;

        while (aux != null) {
            System.out.print(aux.getInfo() + " | ");
            aux = aux.getProx();
        }
    }

    //-------------- Métodos de Pesquisa
    public No busca_exaustiva(int chave) {
        No aux = inicio;

        while (aux != null && aux.getInfo() != chave) {
            aux = aux.getProx();
        }

        return aux;
    }

    public No busca_sentinela(int chave) {
        inserirNoFinal(chave);
        No aux = inicio;

        while (aux.getInfo() != chave) {
            aux = aux.getProx();
        }

        if (fim == aux) {
            return null;
        }
        return aux;
    }

    public No busca_sequencial(int chave) {
        No aux = inicio;

        while (aux != null && chave > aux.getInfo()) {
            aux = aux.getProx();
        }

        return aux;
    }

    private No retornaMeio(No newIni, No newFim) {
        No aux = newIni;
        No newMeio = newIni;
        int count = 0;

        while (aux != newFim) {
            count++;
            aux = aux.getProx();
        }

        for (int i = 0; i < count / 2; i++) {
            newMeio = newMeio.getProx();
        }

        return newMeio;
    }

    public No busca_binaria(int chave) {
        No begin = inicio;
        No end = fim;
        No meio = retornaMeio(begin, end);

        while (begin != meio && chave != meio.getInfo()) {
            if (chave < meio.getInfo()) {
                end = meio;
            } else {
                begin = meio.getProx();
            }

            meio = retornaMeio(begin, end);
        }

        return meio;
    }

    public No busca_binaria2(int chave, No TL) {
        No begin = inicio;
        No end = TL;
        No meio = retornaMeio(begin, end);

        while (begin != meio && chave != meio.getInfo()) {
            if (chave < meio.getInfo()) {
                end = meio;
            } else {
                begin = meio.getProx();
            }

            meio = retornaMeio(begin, end);
        }

        if (chave > meio.getInfo()) {
            return meio.getProx();
        }
        return meio;
    }

    //-------------- Métodos de Ordenação
    public void insercao_direta() {
        No pos = null;
        int aux = 0;

        for (No i = inicio.getProx(); i != null; i = i.getProx()) {
            aux = i.getInfo();
            pos = i;

            while (pos != inicio && aux < pos.getAnt().getInfo()) {
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

            for (No j = i; j != pos; j = j.getAnt()) {
                j.setInfo(j.getAnt().getInfo());
            }

            pos.setInfo(aux);
        }
    }

    public void selecao_direta() {
        int menor;
        No j, pos;

        for (No i = inicio; i.getProx() != null; i = i.getProx()) {
            menor = i.getInfo();
            pos = i;

            for (j = i.getProx(); j != null; j = j.getProx()) {
                if (j.getInfo() < menor) {
                    menor = j.getInfo();
                    pos = j;
                }
            }
            pos.setInfo(i.getInfo());
            i.setInfo(menor);
        }
    }

    public void bubble_sort() {
        No tl = fim, i = inicio, j = null;
        int aux;

        while (tl.getAnt() != null) {
            while (i.getProx() != null) {
                j = i.getProx();
                if (i.getInfo() > j.getInfo()) {
                    aux = i.getInfo();
                    i.setInfo(j.getInfo());
                    j.setInfo(aux);
                }
                i = i.getProx();
            }
            i = inicio;
            tl = tl.getAnt();
        }
    }

    public void shake_sort() {
        int aux;
        for (No ini = inicio, f = fim; ini != f.getAnt(); ini = ini.getProx()) {
            for (No i = ini; i != f; i = i.getProx()) {
                if (i.getInfo() > i.getProx().getInfo()) {
                    aux = i.getInfo();
                    i.setInfo(i.getProx().getInfo());
                    i.getProx().setInfo(aux);
                }
            }
            for (No j = f; j != ini; j = j.getAnt()) {
                if (j.getInfo() < j.getAnt().getInfo()) {
                    aux = j.getInfo();
                    j.setInfo(j.getAnt().getInfo());
                    j.getAnt().setInfo(aux);
                }
            }
        }
    }

    public void heap_sort() {
        No tl = fim, filhoE = null, filhoD = null, paiNo = null, maiorNo;
        int pai, fe, fd, maiorf, aux, cont = 0, tamanho = tamanho();

        while (tl.getAnt() != null) {
            pai = ((tamanho / 2) - 1);
            while (pai >= 0) {
                fe = pai + pai + 1;
                fd = fe + 1;

                if (fd < tamanho) {
                    filhoE = getNo(fe);
                    filhoD = getNo(fd);

                    if (filhoD.getInfo() > filhoE.getInfo()) {
                        maiorf = fd;
                    } else {
                        maiorf = fe;
                    }
                } else {
                    maiorf = fe;
                }

                paiNo = getNo(pai);
                maiorNo = getNo(maiorf);

                if (maiorNo.getInfo() > paiNo.getInfo()) {
                    aux = paiNo.getInfo();
                    paiNo.setInfo(maiorNo.getInfo());
                    maiorNo.setInfo(aux);
                }
                pai--;
            }
            aux = tl.getInfo();
            tl.setInfo(inicio.getInfo());
            inicio.setInfo(aux);
            tl = tl.getAnt();
            tamanho--;
        }
    }

    public void shell_sort() {
        int dist = 4;
        int temp;
        int i, j, k;
        No naux1, naux2, naux3, naux4;
        No aux = inicio;
        while (dist > 0) {
            for (i = 0; i < dist; i++) {
                for (j = i; j + dist < tamanho(); j++) {
                    naux1 = aux;
                    naux2 = naux1.getProx();

                    while (naux2 != null) {
                        if (naux1.getInfo() > naux2.getInfo()) {
                            temp = naux1.getInfo();
                            naux1.setInfo(naux2.getInfo());
                            naux2.setInfo(temp);

                            naux3 = naux2;
                            naux4 = naux3.getAnt();
                            while (naux4 != null && naux3 != null) {
                                if (naux3.getInfo() < naux4.getInfo()) {
                                    temp = naux4.getInfo();
                                    naux4.setInfo(naux3.getInfo());
                                    naux3.setInfo(temp);
                                }
                                naux3 = naux3.getAnt();
                                naux4 = naux3.getAnt();
                            }
                        }

                        naux1 = naux1.getProx();
                        naux2 = naux1.getProx();
                    }
                }
            }
            dist /= 2;
        }
    }

    public void quick_sort() {
        quick_sort_sp(0, TAM - 1);
    }

    private void quick_sort_sp(int ini, int fim) {
        No i = get(ini);
        No j = get(fim);
        int aux;

        while (getInt(i) < getInt(j)) {

            while (getInt(i) < getInt(j) && i.getInfo() <= j.getInfo()) {
                i = i.getProx();
            }
            if (i != j) {
                aux = i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
            }

            while (getInt(i) < getInt(j) && j.getInfo() >= i.getInfo()) {
                j = j.getAnt();
            }
            if (i != j) {
                aux = i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
            }
        }

        if (ini < getInt(i.getAnt())) {
            quick_sort_sp(ini, getInt(i.getAnt()));
        }
        if (getInt(j.getProx()) < fim) {
            quick_sort_sp(getInt(i.getProx()), fim);
        }
    }

    public void quick_sort_pivot() {
        quickP(0, TAM - 1);
    }

    private void quickP(int ini, int fim) {
        No i = get(ini);
        No j = get(fim);
        No pivot = get((ini + fim) / 2);
        int aux;

        while (getInt(i) <= getInt(j)) {
            while (i.getInfo() < pivot.getInfo()) {
                i = i.getProx();
            }

            while (j.getInfo() > pivot.getInfo()) {
                j = j.getAnt();
            }

            if (getInt(i) <= getInt(j)) {
                aux = i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);

                i = i.getProx();
                j = j.getAnt();
            }
        }

        if (ini < getInt(j)) {
            quickP(ini, getInt(j.getProx()));
        }
        if (getInt(i) < fim) {
            quickP(getInt(i), fim);
        }
    }

    public void merge_sort() {

        int seq = 1;
        Lista particao1 = new Lista(), particao2 = new Lista();
        while (seq < TAM) {
            particao(particao1, particao2, TAM);
            fusao(particao1, particao2, seq);
            seq *= 2;
        }
    }

    private void particao(Lista particao1, Lista particao2, int s) {

        particao1.inicializar();
        particao2.inicializar();
        No aux1 = inicio;
        No aux2 = get(s / 2);
        while (aux1 != null && aux2 != null) {
            particao1.inserirNoFinal(aux1.getInfo());
            aux1 = aux1.getProx();

            particao2.inserirNoFinal(aux2.getInfo());
            aux2 = aux2.getProx();
        }

        while (aux1 != null) {
            particao1.inserirNoFinal(aux1.getInfo());
            aux1 = aux1.getProx();
        }
        while (aux2 != null) {
            particao2.inserirNoFinal(aux2.getInfo());
            aux2 = aux2.getProx();
        }
    }

    private void fusao(Lista particao1, Lista particao2, int seq) {
        int aux_seq = seq;
        int i = 0, j = 0, c = 0;
        while (c < TAM) {
            while (i < seq && j < seq) {
                if (particao1.get(i).getInfo() < particao2.get(j).getInfo()) {
                    get(c++).setInfo(particao1.get(i++).getInfo());
                } else {
                    get(c++).setInfo(particao2.get(j++).getInfo());
                }
            }
            while (i < seq) {
                get(c++).setInfo(particao1.get(i++).getInfo());
            }
            while (j < seq) {
                get(c++).setInfo(particao2.get(j++).getInfo());
            }
            seq += aux_seq;
        }
    }

    public void merge_sort2() {
        Lista aux = new Lista();
        criaLista(0, TAM, aux);
        merge(aux, 0, TAM - 1);
    }

    private void criaLista(int ini, int fm, Lista l) {
        int pos = ini;
        int fim = fm;
        No aux = get(pos);
        while (aux != null && pos < fim) {
            l.inserirNoFinal(aux.getInfo());
            aux = aux.getProx();
            pos++;
        }
    }

    private void merge(Lista aux, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            merge(aux, esq, meio);
            merge(aux, meio + 1, dir);
            fusao2(aux, esq, meio, meio + 1, dir);
        }
    }

    private void fusao2(Lista aux, int ini1, int fim1, int ini2, int fim2) {
        int c = 0, i = ini1, j = ini2;
        while (i <= fim1 && j <= fim2) {
            if (get(i).getInfo() < get(j).getInfo()) {
                aux.get(c++).setInfo(get(i++).getInfo());
            } else {
                aux.get(c++).setInfo(get(j++).getInfo());
            }
        }
        while (i <= fim1) {
            aux.get(c++).setInfo(get(i++).getInfo());
        }
        while (j <= fim2) {
            aux.get(c++).setInfo(get(j++).getInfo());
        }
        for (i = 0; i < c; i++) {
            get(ini1 + i).setInfo(aux.get(i).getInfo());
        }
    }

    public void count_sort() {
        int max = maiorLista();
        int min = menorLista();
        int size = TAM;
        int range = max - min + 1;
        No aux;

        int count[] = new int[range];

        Lista saida = new Lista();

        try {
            for (int i = 0; i < size; i++)//inica lista
            {
                saida.inserirNoFinal(0);
            }
            aux = inicio;
            for (int i = 0; i < size; i++, aux = aux.getProx()) {
                count[aux.getInfo() - min]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            aux = fim;
            for (int i = size - 1; i >= 0; i--) {
                saida.set(count[aux.getInfo() - min] - 1, aux.getInfo());
                count[aux.getInfo() - min]--;
                aux = aux.getAnt();
            }
            aux = inicio;
            No auxSaida = saida.inicio;
            while (aux != null && auxSaida != null) {
                aux.setInfo(auxSaida.getInfo());
                aux = aux.getProx();
                auxSaida = auxSaida.getProx();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Integer maiorLista() {
        Integer maior = (TAM > 0) ? -9999 : null;
        for (int i = 0; i < TAM; i++) {
            if (maior < get(i).getInfo()) {
                maior = get(i).getInfo();
            }
        }
        return maior;
    }

    private Integer menorLista() {
        Integer menor = (TAM > 0) ? 9999 : null;
        for (int i = 0; i < TAM; i++) {
            if (menor > get(i).getInfo()) {
                menor = get(i).getInfo();
            }
        }
        return menor;
    }

    private void set(int index, int info) {
        No a = get(index);
        if (a != null) {
            a.setInfo(info);
        }
    }

    public void bucket_sort(int baldes) {
        int Nmax = (maiorLista() - 1) / baldes;
        int aux;
        No naux;
        Lista[] balde = new Lista[Nmax];
        for (int i = 0; i < balde.length; i++) {
            balde[i] = new Lista();
        }
        naux = inicio;
        while (naux != null) {
            aux = naux.getInfo();
            balde[(aux - 1) / (Nmax + 1)].inserirNoInicio(aux);
            naux = naux.getProx();
        }
        for (int i = 0; i < balde.length; i++) {
            insercao_direta_Bucket(balde[i]);
        }
        inicializar();
        No auxn;
        for (int j = 0; j < balde.length; j++) {
            auxn = balde[j].inicio;
            while (auxn != null) {
                inserirNoFinal(auxn.getInfo());
                auxn = auxn.getProx();
            }
        }
    }

    private void insercao_direta_Bucket(Lista balde) {
        No pos = null;
        int aux = 0;

        for (No i = balde.inicio; i != null; i = i.getProx()) {
            aux = i.getInfo();
            pos = i;

            while (pos != balde.inicio && aux < pos.getAnt().getInfo()) {
                pos.setInfo(pos.getAnt().getInfo());
                pos = pos.getAnt();
            }

            pos.setInfo(aux);
        }
    }

    public void radix_sort() {
        int m = maiorLista();
        for (int exp = 1; m / exp > 0; exp *= 10) {
            count_sort_raix(exp);
        }
    }

    private void count_sort_raix(int exp) {
        int size = TAM;
        int range = 10;

        int count[] = new int[range];

        Lista saida = new Lista();

        for (int i = 0; i < size; i++) {
            saida.inserirNoFinal(0);
        }

        for (int i = 0; i < size; i++) {
            count[(get(i).getInfo() / exp) % range]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            saida.set(count[(get(i).getInfo() / exp) % range] - 1, get(i).getInfo());
            count[(get(i).getInfo() / exp) % range]--;
        }
        No a1 = inicio;
        No a2 = saida.inicio;
        while (a2 != null) {
            a1.setInfo(a2.getInfo());
            a1 = a1.getProx();
            a2 = a2.getProx();
        }
    }

    public void comb_sort() {
        boolean trocou = false;
        int size = TAM;
        int gap = size;
        No aux1;
        No aux2;
        int a;
        while (gap != 1 || trocou) {
            gap = (gap * 10) / 13;
            gap = (gap < 1) ? 1 : gap;

            trocou = false;
            for (int i = 0; i < size - gap; i++) {
                aux1 = get(i);
                aux2 = get(i + gap);
                if (aux1.getInfo() > aux2.getInfo()) {
                    a = aux1.getInfo();
                    aux1.setInfo(aux2.getInfo());
                    aux2.setInfo(a);
                    trocou = true;
                }
            }
        }
    }

    public void gnome_sort() {
        int size = TAM;
        int temp;
        No aux;
        No aux2;
        int index = 0;

        while (index < size) {
            if (index == 0) {
                index++;
            }
            aux = get(index);
            aux2 = get(index - 1);
            if (aux.getInfo() >= aux2.getInfo()) {
                index++;
            } else {
                temp = aux.getInfo();
                aux.setInfo(aux2.getInfo());
                aux2.setInfo(temp);
                index--;
            }
        }
    }

    public void tim_sort() {
        int n = tamanho();
        int tim_tam = 32;

        for (int i = 0; i < n; i += tim_tam) {
            tim_sort_insertion(i, Math.min((i + 31), (n - 1)));
        }

        for (int size = tim_tam; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                merge_tim(left, mid, right);
            }
        }

    }

    private void tim_sort_insertion(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = getNo(i).getInfo();
            int j = i - 1;
            while (getNo(j) != null && getNo(j).getInfo() > temp && j >= left) {
                getNo(j + 1).setInfo(getNo(j).getInfo());
                j--;
            }
            getNo(j + 1).setInfo(temp);
        }
    }
 

    private void merge_tim(int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        for (int x = 0; x < len1; x++) {
            left[x] = getNo(l + x).getInfo();
        }

        for (int x = 0; x < len2; x++) {
            right[x] = getNo(m + l + x).getInfo();
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                getNo(k).setInfo(left[i]);
                i++;
            } else {
                getNo(k).setInfo(right[j]);
                j++;
            }
            k++;
        }

        while (i < len1) {
            getNo(k).setInfo(left[i]);
            k++;
            i++;
        }

        while (j < len2) {
            getNo(k).setInfo(right[j]);
            k++;
            j++;
        }
    }
}
