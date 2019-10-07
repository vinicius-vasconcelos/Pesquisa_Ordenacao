package metArq_main.arquivo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class Arquivo {

    private String nomearquivo;
    private RandomAccessFile arquivo;
    private RandomAccessFile aux;
    private int compProg;
    private int movProg;
    private double tini;
    private double tfinal;
    private double ttotal;

    public Arquivo(String nomearquivo) {
        try {
            compProg = movProg = 0;
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e) {
        }
    }

    public void truncate(long pos) {
        try {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc) {
        }
    }

    public boolean eof() {
        boolean retorno = false;
        try {
            if (arquivo.getFilePointer() == arquivo.length()) {
                retorno = true;
            }
        } catch (IOException e) {
        }
        return (retorno);
    }

    private int filesize() {
        try {
            return (int) (arquivo.length() / Registro.length());
        } catch (IOException ex) {
        }
        return -1;
    }

    private int filesizeAux() {
        try {
            return (int) (aux.length() / Registro.length());
        } catch (IOException ex) {
        }
        return -1;
    }

    public void inserirRegNoFinal(Registro reg) {
        seekArq(filesize());
        reg.gravaNoArq(arquivo);
    }

    public void exibirArq() {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof()) {
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos) {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos) {
        try {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e) {
        }
    }

    public void seekAux(int pos) {
        try {
            aux.seek(pos * Registro.length());
        } catch (IOException e) {
        }
    }

    public void leArq1() {
        int codigo, idade;
        String nome;
        codigo = Entrada.leInteger("Digite o código");
        while (codigo != 0) {
            inserirRegNoFinal(new Registro(codigo));
            codigo = Entrada.leInteger("Digite o código");
        }
    }

    public void leArq(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            inserirRegNoFinal(new Registro(vet[i]));
        }
    }

    public void inserirAux(int num) {
        Registro reg = new Registro(num);
        seekArq(filesizeAux());
        reg.gravaNoArq(aux);
    }

    public void swap(int i, int j) {
        Registro temp = new Registro();
        Registro rj = new Registro();
        seekArq(i);
        temp.leDoArq(arquivo);
        seekArq(j);
        rj.leDoArq(arquivo);
        seekArq(i);
        rj.gravaNoArq(arquivo);
        seekArq(j);
        temp.gravaNoArq(arquivo);
    }

    public int getCompProg() {
        return compProg;
    }

    public int getMovProg() {
        return movProg;
    }

    public double getTtotal() {
        return ttotal;
    }

    /*----------------------- Métodos */
    public void insercao_direta() {
        tini = System.currentTimeMillis();
        int tl = filesize();
        int pos;
        Registro aux = new Registro();
        Registro vet = new Registro();
        for (int i = 1; i < tl; i++) {
            pos = i;
            seekArq(i);
            aux.leDoArq(arquivo);
            seekArq(pos - 1);
            vet.leDoArq(arquivo);

            compProg++;
            while (pos > 0 && aux.getCodigo() < vet.getCodigo()) {
                compProg++;
                movProg++;

                seekArq(pos);
                vet.gravaNoArq(arquivo);

                pos--;
                seekArq(pos - 1);
                vet.leDoArq(arquivo);
            }
            seekArq(pos);
            aux.gravaNoArq(arquivo);
            movProg++;
        }
        tfinal = System.currentTimeMillis();
    }

    public void insercao_binaria() {
        tini = System.currentTimeMillis();
        int tl = filesize();
        Registro aux = new Registro();
        Registro vet = new Registro();
        int pos;
        for (int i = 1; i < tl; i++) {
            seekArq(i);
            aux.leDoArq(arquivo);
            pos = busca_binaria(aux, i);
            for (int j = i; j > pos; j--) {
                seekArq(j - 1);
                vet.leDoArq(arquivo);
                seekArq(j);
                vet.gravaNoArq(arquivo);
                movProg++;
            }
            seekArq(pos);
            aux.gravaNoArq(arquivo);
            movProg++;
        }
        tfinal = System.currentTimeMillis();
    }

    private int busca_binaria(Registro elem, int tl) {
        int ini = 0, fim = tl - 1, meio = tl / 2;
        Registro vet = new Registro();
        seekArq(meio);
        vet.leDoArq(arquivo);

        compProg++;
        while (ini < fim && elem.getCodigo() != vet.getCodigo()) {
            compProg++;
            if (elem.getCodigo() < vet.getCodigo()) {
                fim = meio - 1;
            } else {
                ini = meio + 1;
            }

            meio = (ini + fim) / 2;

            seekArq(meio);
            vet.leDoArq(arquivo);
        }
        compProg++;
        if (elem.getCodigo() < vet.getCodigo()) {
            return meio;
        }
        return meio + 1;
    }

    public void selecao_direta() {
        tini = System.currentTimeMillis();
        Registro menor = new Registro();
        Registro vet = new Registro();
        int posMenor;
        int tl = filesize();
        for (int i = 0; i < tl - 1; i++) {
            seekArq(i);
            menor.leDoArq(arquivo);
            posMenor = i;
            for (int j = i + 1; j < tl; j++) {
                seekArq(j);
                vet.leDoArq(arquivo);
                compProg++;
                if (menor.getCodigo() > vet.getCodigo()) {
                    seekArq(j);
                    menor.leDoArq(arquivo);
                    posMenor = j;
                }
            }
            seekArq(i);
            vet.leDoArq(arquivo);
            seekArq(posMenor);
            vet.gravaNoArq(arquivo);
            seekArq(i);
            menor.gravaNoArq(arquivo);
            movProg += 2;
        }
        tfinal = System.currentTimeMillis();
    }

    public void bubble_sort() {
        tini = System.currentTimeMillis();
        Registro vet = new Registro(), vet1 = new Registro();
        int tl = filesize();
        for (int tl1 = tl; tl1 > 1; tl1--) {
            for (int i = 0; i < tl1 - 1; i++) {
                seekArq(i);
                vet.leDoArq(arquivo);
                seekArq(i + 1);
                vet1.leDoArq(arquivo);
                compProg++;
                if (vet.getCodigo() > vet1.getCodigo()) {
                    movProg += 2;
                    swap(i, i + 1);
                }
            }
        }
        tfinal = System.currentTimeMillis();
    }

    public void shake_sort() {
        tini = System.currentTimeMillis();
        Registro vet1 = new Registro();
        Registro vet2 = new Registro();
        int tl = filesize();
        for (int inicio = 0, fim = tl - 1; inicio < fim; inicio++) {
            for (int i = inicio; i < fim; i++) {
                seekArq(i);
                vet1.leDoArq(arquivo);
                seekArq(i + 1);
                vet2.leDoArq(arquivo);
                compProg++;
                if (vet1.getCodigo() > vet2.getCodigo()) {
                    movProg += 2;
                    swap(i, i + 1);
                }
            }
            fim--;

            for (int i = fim; i > inicio; i--) {
                seekArq(i);
                vet1.leDoArq(arquivo);
                seekArq(i - 1);
                vet2.leDoArq(arquivo);
                compProg++;
                if (vet1.getCodigo() < vet2.getCodigo()) {
                    movProg += 2;
                    swap(i, i - 1);
                }
            }
        }
        tfinal = System.currentTimeMillis();
    }

    public void heap_sort() {
        tini = System.currentTimeMillis();
        Registro vet1 = new Registro();
        Registro vet2 = new Registro();
        int fd, fe, maiorf, pai, tl2;
        int tl = filesize();
        tl2 = tl;
        while (tl2 > 1) {
            pai = tl2 / 2 - 1;
            while (pai >= 0) {
                fe = 2 * pai + 1;
                fd = fe + 1;
                maiorf = fe;

                seekArq(fe);
                vet1.leDoArq(arquivo);
                seekArq(fd);
                vet2.leDoArq(arquivo);

                compProg++;
                if (fd < tl2 && vet1.getCodigo() < vet2.getCodigo()) {
                    maiorf = fd;
                }

                seekArq(maiorf);
                vet1.leDoArq(arquivo);
                seekArq(pai);
                vet2.leDoArq(arquivo);

                compProg++;
                if (vet1.getCodigo() > vet2.getCodigo()) {
                    movProg += 2;
                    swap(pai, maiorf);
                }
                pai--;
            }
            movProg += 2;
            swap(0, tl2 - 1);
            tl2--;
        }
        tfinal = System.currentTimeMillis();
    }

    public void shell_sort() {
        tini = System.currentTimeMillis();
        Registro vet1 = new Registro();
        Registro vet2 = new Registro();
        int tl = filesize();
        int i, j, k, dist;
        for (dist = 4; dist > 0; dist /= 2) {
            for (i = 0; i < dist; i++) {
                for (j = i; j + dist < tl; j += dist) {
                    seekArq(j);
                    vet1.leDoArq(arquivo);
                    seekArq(j + dist);
                    vet2.leDoArq(arquivo);
                    compProg++;
                    if (vet1.getCodigo() > vet2.getCodigo()) {
                        movProg += 2;
                        swap(j, j + dist);
                        k = j;
                        seekArq(k);
                        vet1.leDoArq(arquivo);
                        seekArq(k - dist);
                        vet2.leDoArq(arquivo);
                        compProg++;
                        while (k - dist >= i && vet1.getCodigo() < vet2.getCodigo()) {
                            compProg++;
                            movProg += 2;
                            swap(k, k - dist);
                            k -= dist;
                            seekArq(k);
                            vet1.leDoArq(arquivo);
                            seekArq(k - dist);
                            vet2.leDoArq(arquivo);
                        }

                    }
                }
            }
        }
        tfinal = System.currentTimeMillis();
    }

    public void quick_iterativo() {
        tini = System.currentTimeMillis();
        int l = 0;
        int h = filesize() - 1;
        int[] stack = new int[h - l + 1];
        int top = -1;
        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            h = stack[top--];
            l = stack[top--];

            int p = particao(l, h);

            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
        tfinal = System.currentTimeMillis();
    }

    private int particao(int low, int high) {
        int i = low - 1;
        Registro pivo = new Registro();
        Registro vet = new Registro();
        seekArq(high);
        pivo.leDoArq(arquivo);

        for (int j = low; j < high; j++) {
            seekArq(j);
            vet.leDoArq(arquivo);
            compProg++;
            if (vet.getCodigo() <= pivo.getCodigo()) {
                i++;
                movProg += 2;
                swap(i, j);
            }
        }
        movProg += 2;
        swap(high, i + 1);
        return i + 1;
    }

    public void quick_sort_pivot() {
        QuickSCP(0, filesize() - 1);
    }

    public void QuickSCP(int ini, int fim) {
        Registro regI = new Registro();
        Registro regJ = new Registro();
        Registro pivo = new Registro();
        int i = ini;
        int j = fim;
        int valor = (ini + fim) / 2;
        seekArq(valor);
        pivo.leDoArq(arquivo);
        compProg++;
        while (i < j) {
            seekArq(i);
            regI.leDoArq(arquivo);
            compProg++;
            while (regI.getCodigo() < pivo.getCodigo()) {
                i++;
                seekArq(i);
                regI.leDoArq(arquivo);
                compProg++;
            }
            seekArq(j);
            regJ.leDoArq(arquivo);
            compProg++;
            while (regJ.getCodigo() > pivo.getCodigo()) {
                j--;
                seekArq(j);
                regJ.leDoArq(arquivo);
                compProg++;
            }
            seekArq(i);
            regJ.gravaNoArq(arquivo);
            movProg++;
            seekArq(j);
            regI.gravaNoArq(arquivo);
            movProg++;
            i++;
            j--;
            compProg++;
        }
        compProg++;
        if (ini < j) {
            QuickSCP(ini, j);
        }
        compProg++;
        if (i < fim) {
            QuickSCP(i, fim);
        }
    }

    public void merge_sort() {
        tini = System.currentTimeMillis();
        try {
            aux = new RandomAccessFile("Arquivos/AuxMerge.dat", "rw");
            merge_rec(aux, 0, filesize() - 1);
        } catch (IOException er) {
        }
        tfinal = System.currentTimeMillis();
    }

    private void merge_rec(RandomAccessFile aux, int esq, int dir) {
        int meio;
        if (esq < dir) {
            meio = (esq + dir) / 2;
            merge_rec(aux, esq, meio);
            merge_rec(aux, meio + 1, dir);
            fusao(aux, esq, meio, meio + 1, dir);
        }
    }

    private void fusao(RandomAccessFile aux, int ini1, int fim1, int ini2, int fim2) {
        Registro veti = new Registro();
        Registro vetj = new Registro();

        int k = 0, i = ini1, j = ini2;
        while (i <= fim1 && j <= fim2) {
            seekArq(i);
            veti.leDoArq(arquivo);
            seekArq(j);
            vetj.leDoArq(arquivo);
            compProg++;
            if (veti.getCodigo() < vetj.getCodigo()) {
                seekAux(k);
                veti.gravaNoArq(aux);
                movProg++;
                i++;
            } else {
                seekAux(k);
                vetj.gravaNoArq(aux);
                movProg++;
                j++;
            }
            k++;
        }

        while (i <= fim1) {
            seekArq(i);
            veti.leDoArq(arquivo);
            seekAux(k);
            veti.gravaNoArq(aux);
            i++;
            k++;
            movProg++;
        }

        while (j <= fim2) {
            seekArq(j);
            vetj.leDoArq(arquivo);
            seekAux(k);
            vetj.gravaNoArq(aux);
            j++;
            k++;
            movProg++;
        }

        for (int l = 0; l < k; l++) {
            seekAux(l);
            veti.leDoArq(aux);
            seekArq(l + ini1);
            veti.gravaNoArq(arquivo);
            movProg++;
        }
    }

    public void count_sort() {
        int TL = filesize();
        int maior;
        int menor;
        int i;
        int pos;
        Registro reg = new Registro();
        seekArq(0);

        reg.leDoArq(arquivo);
        maior = reg.getCodigo();
        menor = reg.getCodigo();
        for (i = 1; i < TL; i++) {
            reg.leDoArq(arquivo);
            compProg++;
            if (maior < reg.getCodigo()) {
                maior = reg.getCodigo();
            }
            compProg++;
            if (menor > reg.getCodigo()) {
                menor = reg.getCodigo();
            }
        }
        int aux[] = new int[maior + 1];

        for (i = 0; i < maior + 1; i++) {
            aux[i] = 0;
        }

        for (i = 0; i < TL; i++) {
            seekArq(i);
            reg.leDoArq(arquivo);
            pos = reg.getCodigo();
            aux[pos - menor] += 1;
        }

        for (i = 1; i < maior + 1; i++) {
            aux[i] += aux[i - 1];
        }
        int vet[] = new int[TL];

        for (i = 0; i < TL; i++) {
            seekArq(i);
            reg.leDoArq(arquivo);
            pos = reg.getCodigo();
            vet[aux[pos] - 1] = pos;
        }

        seekArq(0);
        for (i = 0; i < TL; i++) {
            //reg.setNumero(vet[i]);
            reg.gravaNoArq(arquivo);
        }
    }

    public void bucket_sort() {
        Registro reg1 = new Registro();
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        int divisor;
        int TL = filesize();
        int j;
        int vet[] = new int[TL];
        int maior, menor;

        for (int i = 0; i < 10; i++) {
            lista.add(new ArrayList<>());
        }

        seekArq(0);
        reg1.leDoArq(arquivo);
        maior = reg1.getCodigo();
        menor = reg1.getCodigo();
        for (int i = 1; i < TL; i++) {
            seekArq(i);
            reg1.leDoArq(arquivo);
            compProg++;
            if (maior < reg1.getCodigo()) {
                maior = reg1.getCodigo();
            }
            compProg++;
            if (menor > reg1.getCodigo()) {
                menor = reg1.getCodigo();
            }
        }
        divisor = (int) ((maior + 1) * 100) / 10;

        for (int i = 0; i < TL; i++) {
            seekArq(i);
            reg1.leDoArq(arquivo);
            j = reg1.getCodigo() / divisor;
            lista.get(j).add(reg1.getCodigo());
        }
        for (int i = 0; i < 10; i++) {
            Collections.sort(lista.get(i));
        }
        int pos = 0;
        for (int i = 0; i < 10; i++) {
            for (int x = 0; x < lista.get(i).size(); x++) {
                vet[pos] = lista.get(i).get(x);
                pos++;
            }
        }
        for (int i = 0; i < TL; i++) {
            movProg++;
            seekArq(i);
//            reg1.setNumero(vet[i]);
            reg1.gravaNoArq(arquivo);
        }
    }

    public void radix_sort() {
        Registro reg1 = new Registro();
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        int num;
        int TL = filesize();
        int pos = 0;
        int maiorNum = 0;
        int vet[] = new int[TL];
        String numero;
        for (int i = 0; i < 10; i++) {
            lista.add(new ArrayList<>());
        }
        for (int i = 0; i < TL; i++) {
            seekArq(i);
            reg1.leDoArq(arquivo);
            numero = "" + reg1.getCodigo();
            compProg++;
            if (i == 0) {
                maiorNum = numero.length();
            }
            compProg++;
            if (maiorNum < numero.length()) {
                maiorNum = numero.length();
            }
        }
        for (int i = 0; i < TL; i++) {
            seekArq(i);
            reg1.leDoArq(arquivo);
            numero = "" + reg1.getCodigo();
            for (int j = numero.length(); j < maiorNum; j++) {
                numero = "0" + numero;
            }
            num = Integer.parseInt("" + numero.charAt(pos));
            lista.get(num).add(Integer.parseInt(numero));
        }
        int lugar = 0;
        for (int i = 0; i < 10; i++) {
            for (int x = 0; x < lista.get(i).size(); x++) {
                movProg++;
                num = lista.get(i).get(x);
                vet[lugar] = num;
                lugar++;
            }
            lista.get(i).clear();
        }
        for (pos = 1; pos < maiorNum; pos++) {

            for (int i = 0; i < TL; i++) {
                numero = "" + vet[i];
                for (int j = numero.length(); j < maiorNum; j++) {
                    numero = "0" + numero;
                }
                num = Integer.parseInt("" + numero.charAt(pos));
                lista.get(num).add(Integer.parseInt(numero));
            }
            lugar = 0;
            for (int i = 0; i < 10; i++) {
                for (int x = 0; x < lista.get(i).size(); x++) {
                    movProg++;
                    num = lista.get(i).get(x);
                    vet[lugar] = num;
                    lugar++;
                }
                lista.get(i).clear();
            }
        }
        for (int i = 0; i < TL; i++) {
            movProg++;
            seekArq(i);
//            reg1.setNumero(vet[i]);
            reg1.gravaNoArq(arquivo);
        }
    }

    public void gnome_sort() {
        int TL = filesize();
        int j;

        Registro reg = new Registro();
        Registro reg2 = new Registro();
        seekArq(0);
        for (int gnomo = 0; gnomo < TL - 1; gnomo++) {
            seekArq(gnomo);
            reg.leDoArq(arquivo);
            reg2.leDoArq(arquivo);
            compProg++;
            if (reg.getCodigo() > reg2.getCodigo()) {
                movProg++;
                seekArq(gnomo);
                reg2.gravaNoArq(arquivo);
                reg.gravaNoArq(arquivo);
                gnomo = -1;
                j = gnomo - 1;

                seekArq(j);
                reg.leDoArq(arquivo);
                reg2.leDoArq(arquivo);
                compProg++;
                while (j > 0 && reg.getCodigo() < reg2.getCodigo()) {
                    movProg++;
                    seekArq(gnomo);
                    reg2.gravaNoArq(arquivo);
                    reg.gravaNoArq(arquivo);
                    gnomo = -1;
                    j = gnomo - 1;
                    j--;
                }
            }
        }
    }

    public void comb_sort() {
        int TL = filesize();
        Registro reg = new Registro();
        Registro reg2 = new Registro();
        seekArq(0);
        int gap = TL;

        while (gap >= 1) {
            for (int i = 0; i < TL; i++) {
                if (i + gap < TL) {
                    seekArq(i);
                    reg.leDoArq(arquivo);
                    seekArq(i + gap);
                    reg2.leDoArq(arquivo);
                    compProg++;
                    if (reg.getCodigo() > reg2.getCodigo()) {
                        seekArq(i);
                        reg2.gravaNoArq(arquivo);
                        seekArq(i + gap);
                        reg.gravaNoArq(arquivo);
                        movProg++;
                    }
                }
            }
            gap = (int) (gap / 1.3);
        }
    }

    public void executaInsDir(int[] vet) {
        leArq(vet);
        insercao_direta();
        ttotal = tfinal - tini;
    }

    public void executaInsBin(int[] vet) {
        //exibirArq(); 
        insercao_binaria();
        ttotal = tfinal - tini;
    }

    public void executaSeleDir(int[] vet) {
        leArq(vet);
        selecao_direta();
        ttotal = tfinal - tini;
    }

    public void executaBubble(int[] vet) {
        leArq(vet);
        bubble_sort();
        ttotal = tfinal - tini;
    }

    public void executaShake(int[] vet) {
        leArq(vet);
        shake_sort();
        ttotal = tfinal - tini;
    }

    public void executaHeap(int[] vet) {
        leArq(vet);
        heap_sort();
        ttotal = tfinal - tini;
    }

    public void executaShell(int[] vet) {
        leArq(vet);
        shell_sort();
        ttotal = tfinal - tini;
    }

    public void executaQuick(int[] vet) {
        leArq(vet);
        quick_iterativo();
        ttotal = tfinal - tini;
    }

    public void executaQuickPivot(int[] vet) {
        leArq(vet);
        quick_sort_pivot();
        ttotal = tfinal - tini;
    }

    public void executaMerge(int[] vet) {
        leArq(vet);
        merge_sort();
        ttotal = tfinal - tini;
    }

    public void executaCount(int[] vet) {
        leArq(vet);
        count_sort();
        ttotal = tfinal - tini;
    }

    public void executaBucket(int[] vet) {
        leArq(vet);
        bucket_sort();
        ttotal = tfinal - tini;
    }

    public void executaRadix(int[] vet) {
        leArq(vet);
        radix_sort();
        ttotal = tfinal - tini;
    }

    public void executaGnome(int[] vet) {
        leArq(vet);
        gnome_sort();
        ttotal = tfinal - tini;
    }

    public void executaComb(int[] vet) {
        leArq(vet);
        comb_sort();
        ttotal = tfinal - tini;
    }
}
