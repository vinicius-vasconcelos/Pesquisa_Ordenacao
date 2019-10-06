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
                            while (naux4 != null && naux3 != null)//faz a volta até não achar elementos fora do lugar
                            {
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
        quick_sort_sp(inicio, fim);
    }

    private void quick_sort_sp(No ini, No fim) {
        No i = ini, j = fim;
        int temp;
        No ni, nj;

        while (i != j) {
            ni = i;
            nj = j;
            while (i != j && ni.getInfo() <= nj.getInfo()) {
                i.getProx();
                ni = ni.getProx();
            }

            temp = nj.getInfo();
            nj.setInfo(ni.getInfo());
            ni.setInfo(temp);

            while (i != j && nj.getInfo() >= ni.getInfo()) {
                j.getAnt();
                nj = nj.getAnt();
            }

            temp = nj.getInfo();
            nj.setInfo(ni.getInfo());
            ni.setInfo(temp);

        }
        if (ini != i.getAnt()) {
            quick_sort_sp(ini, i.getAnt());
        }
        if (j.getProx() != fim) {
            quick_sort_sp(j.getProx(), fim);
        }
    }

    public void quick_sort_pivot() {
        quickP(0, TAM);
    }

    private void quickP(int ini, int fim) {
        int pivo = get((ini + fim) / 2).getInfo();
        int i = ini, j = fim;
        int temp;
        No auxi, auxj;

        while (i < j) {
            auxi = get(i);
            auxj = get(j);
            while (auxi.getInfo() < pivo) {
                i++;
                auxi = auxi.getProx();
            }
            while (auxj.getInfo() > pivo) {
                j--;
                auxj = auxj.getAnt();
            }
            if (i <= j) {
                temp = auxi.getInfo();
                auxi.setInfo(auxj.getInfo());
                auxj.setInfo(temp);
            }
        }
        
        if (ini < j) {
            quickP(ini, j);
        }
        if (i < fim) {
            quickP(i, fim);
        }
    }

}
