package metArq_main;

import java.io.FileWriter;
import java.io.PrintWriter;
import metArq_main.arquivo.Arquivo;
import metArq_main.util.Randomizador;

public class MetodosArquivo {

    private static final int TF = 512;

    public static void main(String[] args) {
        double[] compEqua = calculaComp();;
        double[] movEqua = calculaMov();

        int[] vetMed = Randomizador.casoMedio(TF);
        int[] vetPior = Randomizador.piorCaso(TF);
        int[] vetMelhor = Randomizador.melhorCaso(TF);

        String aux;
        aux = "Métodos de Ordenação | Arquivo Ordenado                            | Arquivo em Ordem Reversa                     | Arquivo Randômico"
                + "\n                     | Comp.  | Comp.  |  Mov.  |  Mov.  |  TEMPO  || Comp.  | Comp.  |  Mov.  |  Mov.  |  TEMPO  || Comp.  | Comp.  |  Mov.  |  Mov.  |  TEMPO  "
                + "\n                     | Prog.  | Equa.  |  Prog. |  Equa. |         || Prog.  | Equa.  |  Prog. |  Equa. |         || Prog.  | Equa.  |  Prog. |  Equa. |         "
                + "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";

        //INSERÇÃO DIRETA
        System.out.println("Inserção Direta: EM EXECUÇÃO");
        Arquivo insDir = new Arquivo("Arquivos/InsercaoDiretaMelhor.dat");
        insDir.executaInsDir(vetMelhor);
        aux += "\nInserção Direta      |  " + insDir.getCompProg() + "  |  " + compEqua[0] + "  |  " + insDir.getMovProg() + "  |  " + movEqua[0] + "  |  " + insDir.getTtotal();

        insDir = new Arquivo("Arquivos/InsercaoDiretaPior.dat");
        insDir.executaInsDir(vetPior);
        aux += " || " + insDir.getCompProg() + "  |  " + compEqua[2] + "  |  " + insDir.getMovProg() + "  |  " + movEqua[2] + "  |  " + insDir.getTtotal();

        insDir = new Arquivo("Arquivos/InsercaoDiretaMedio.dat");
        insDir.executaInsDir(vetMed);
        aux += " || " + insDir.getCompProg() + "  |  " + compEqua[1] + "  |  " + insDir.getMovProg() + "  |  " + movEqua[1] + "  |  " + insDir.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Inserção Direta: PRONTO");

        //INSERÇÃO BINÁRIA
        System.out.println("\nInserção Binária: EM EXECUÇÃO");
        Arquivo insBin = new Arquivo("Arquivos/InsercaoBinariaMelhor.dat");
        insBin.executaInsBin(vetMelhor);
        aux += "\nInserção Binária     |  " + insBin.getCompProg() + "  |  " + compEqua[3] + "  |  " + insBin.getMovProg() + "  |  " + movEqua[3] + "  |  " + insBin.getTtotal();

        insBin = new Arquivo("Arquivos/InsercaoBinariaPior.dat");
        insBin.executaInsBin(vetPior);
        aux += " || " + insBin.getCompProg() + "  |  " + compEqua[5] + "  |  " + insBin.getMovProg() + "  |  " + movEqua[5] + "  |  " + insBin.getTtotal();

        insBin = new Arquivo("Arquivos/InsercaoBinariaMedio.dat");
        insBin.executaInsBin(vetMed);
        aux += " || " + insBin.getCompProg() + "  |  " + compEqua[4] + "  |  " + insBin.getMovProg() + "  |  " + movEqua[4] + "  |  " + insBin.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Inserção Binária: PRONTO");

        //SELEÇÃO DIRETA
        System.out.println("\nSeleção Direta: EM EXECUÇÃO");
        Arquivo selDir = new Arquivo("Arquivos/SelecaoDiretaMelhor.dat");
        selDir.executaSeleDir(vetMelhor);
        aux += "\nSeleção Direta       |  " + selDir.getCompProg() + "  |  " + compEqua[6] + "  |  " + selDir.getMovProg() + "  |  " + movEqua[6] + "  |  " + selDir.getTtotal();

        selDir = new Arquivo("Arquivos/SelecaoDiretaPior.dat");
        selDir.executaSeleDir(vetPior);
        aux += " || " + selDir.getCompProg() + "  |  " + compEqua[8] + "  |  " + selDir.getMovProg() + "  |  " + movEqua[8] + "  |  " + selDir.getTtotal();

        selDir = new Arquivo("Arquivos/SelecaoDiretaMedio.dat");
        selDir.executaSeleDir(vetMed);
        aux += " || " + selDir.getCompProg() + "  |  " + compEqua[7] + "  |  " + selDir.getMovProg() + "  |  " + movEqua[7] + "  |  " + selDir.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Seleção Direta: PRONTO");

        //BUBBLE SORT
        System.out.println("\nBubble Sort: EM EXECUÇÃO");
        Arquivo bubble = new Arquivo("Arquivos/BubbleSortMelhor.dat");
        bubble.executaBubble(vetMelhor);
        aux += "\nBubble Sort          |  " + bubble.getCompProg() + "  |  " + compEqua[9] + "  |  " + bubble.getMovProg() + "  |  " + movEqua[9] + "  |  " + bubble.getTtotal();

        bubble = new Arquivo("Arquivos/BubbleSortPior.dat");
        bubble.executaBubble(vetPior);
        aux += " || " + bubble.getCompProg() + "  |  " + compEqua[11] + "  |  " + bubble.getMovProg() + "  |  " + movEqua[11] + "  |  " + bubble.getTtotal();

        bubble = new Arquivo("Arquivos/BubbleSortMedio.dat");
        bubble.executaBubble(vetMed);
        aux += " || " + bubble.getCompProg() + "  |  " + compEqua[10] + "  |  " + bubble.getMovProg() + "  |  " + movEqua[10] + "  |  " + bubble.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Bubble Sort: PRONTO");

        //SHAKE SORT
        System.out.println("\nShake Sort: EM EXECUÇÃO");
        Arquivo shake = new Arquivo("Arquivos/ShakeSortMelhor.dat");
        shake.executaShake(vetMelhor);
        aux += "\nShake Sort           |  " + shake.getCompProg() + "  |  " + compEqua[12] + "  |  " + shake.getMovProg() + "  |  " + movEqua[12] + "  |  " + shake.getTtotal();

        shake = new Arquivo("Arquivos/ShakeSortPior.dat");
        shake.executaShake(vetPior);
        aux += " || " + shake.getCompProg() + "  |  " + compEqua[14] + "  |  " + shake.getMovProg() + "  |  " + movEqua[14] + "  |  " + shake.getTtotal();

        shake = new Arquivo("Arquivos/ShakeSortMedio.dat");
        shake.executaShake(vetMed);
        aux += " || " + shake.getCompProg() + "  |  " + compEqua[13] + "  |  " + shake.getMovProg() + "  |  " + movEqua[13] + "  |  " + shake.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Shake Sort: PRONTO");

        //SHELL SORT
        System.out.println("\nShell Sort: EM EXECUÇÃO");
        Arquivo shell = new Arquivo("Arquivos/ShellSortMelhor.dat");
        shell.executaShell(vetMelhor);
        aux += "\nShell Sort           |  " + shell.getCompProg() + "  |  " + "  -  " + "  |  " + shell.getMovProg() + "  |  " + "  -  " + "  |  " + shell.getTtotal();

        shell = new Arquivo("Arquivos/ShellSortPior.dat");
        shell.executaShell(vetPior);
        aux += " || " + shell.getCompProg() + "  |  " + "  -  " + "  |  " + shell.getMovProg() + "  |  " + "  -  " + "  |  " + shell.getTtotal();

        shell = new Arquivo("Arquivos/ShellSortMedio.dat");
        shell.executaShell(vetMed);
        aux += " || " + shell.getCompProg() + "  |  " + "  -  " + "  |  " + shell.getMovProg() + "  |  " + "  -  " + "  |  " + shell.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Shell Sort: PRONTO");

        //HEAP SORT
        System.out.println("\nHeap Sort: EM EXECUÇÃO");
        Arquivo heap = new Arquivo("Arquivos/HeapSortMelhor.dat");
        heap.executaHeap(vetMelhor);
        aux += "\nHeap Sort            |  " + heap.getCompProg() + "  |  " + "  -  " + "  |  " + heap.getMovProg() + "  |  " + "  -  " + "  |  " + heap.getTtotal();

        heap = new Arquivo("Arquivos/HeapSortPior.dat");
        heap.executaHeap(vetPior);
        aux += " || " + heap.getCompProg() + "  |  " + "  -  " + "  |  " + heap.getMovProg() + "  |  " + "  -  " + "  |  " + heap.getTtotal();

        heap = new Arquivo("Arquivos/HeapSortMedio.dat");
        heap.executaHeap(vetMelhor);
        aux += " || " + heap.getCompProg() + "  |  " + "  -  " + "  |  " + heap.getMovProg() + "  |  " + "  -  " + "  |  " + heap.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Heap Sort: PRONTO");

        //QUICK SORT
        System.out.println("\nQuick Sort: EM EXECUÇÃO");
        Arquivo quick = new Arquivo("Arquivos/QuickSortMelhor.dat");
        quick.executaQuick(vetMelhor);
        aux += "\nQuick Sort           |  " + quick.getCompProg() + "  |  " + "  -  " + "  |  " + quick.getMovProg() + "  |  " + "  -  " + "  |  " + quick.getTtotal();

        quick = new Arquivo("Arquivos/QuickSortPior.dat");
        quick.executaQuick(vetPior);
        aux += " || " + quick.getCompProg() + "  |  " + "  -  " + "  |  " + quick.getMovProg() + "  |  " + "  -  " + "  |  " + quick.getTtotal();

        quick = new Arquivo("Arquivos/QuickSortMedio.dat");
        quick.executaQuick(vetMed);
        aux += " || " + quick.getCompProg() + "  |  " + "  -  " + "  |  " + quick.getMovProg() + "  |  " + "  -  " + "  |  " + quick.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Quick Sort: PRONTO");

        //QUICK SORT PIVOT
        System.out.println("\nQuick Sort Pivot: EM EXECUÇÃO");
        Arquivo quickPivot = new Arquivo("Arquivos/QuickSortPivotMelhor.dat");
        quickPivot.executaQuickPivot(vetMelhor);
        aux += "\nQuick Sort Pivot          |  " + quickPivot.getCompProg() + "  |  " + "  -  " + "  |  " + quickPivot.getMovProg() + "  |  " + "  -  " + "  |  " + quickPivot.getTtotal();

        quickPivot = new Arquivo("Arquivos/QuickSortPivotPior.dat");
        quickPivot.executaQuickPivot(vetPior);
        aux += " || " + quickPivot.getCompProg() + "  |  " + "  -  " + "  |  " + quickPivot.getMovProg() + "  |  " + "  -  " + "  |  " + quickPivot.getTtotal();

        quickPivot = new Arquivo("Arquivos/QuickSortPivotMedio.dat");
        quickPivot.executaQuickPivot(vetMed);
        aux += " || " + quickPivot.getCompProg() + "  |  " + "  -  " + "  |  " + quickPivot.getMovProg() + "  |  " + "  -  " + "  |  " + quickPivot.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Quick Sort Pivot: PRONTO");

        //MERGE SORT
        System.out.println("\nMerge Sort: EM EXECUÇÃO");
        Arquivo merge = new Arquivo("Arquivos/MergeSortMelhor.dat");
        merge.executaMerge(vetMelhor);
        aux += "\nMerge Sort           |  " + merge.getCompProg() + "  |  " + "  -  " + "  |  " + merge.getMovProg() + "  |  " + "  -  " + "  |  " + merge.getTtotal();

        merge = new Arquivo("Arquivos/MergeSortPior.dat");
        merge.executaMerge(vetPior);
        aux += " || " + merge.getCompProg() + "  |  " + "  -  " + "  |  " + merge.getMovProg() + "  |  " + "  -  " + "  |  " + merge.getTtotal();

        merge = new Arquivo("Arquivos/MergeSortMedio.dat");
        merge.executaMerge(vetMed);
        aux += " || " + merge.getCompProg() + "  |  " + "  -  " + "  |  " + merge.getMovProg() + "  |  " + "  -  " + "  |  " + merge.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Merge Sort: PRONTO");

        //COUNT SORT
        System.out.println("\nCount Sort: EM EXECUÇÃO");
        Arquivo count = new Arquivo("Arquivos/CountSortMelhor.dat");
        count.executaCount(vetMelhor);
        aux += "\nCount Sort           |  " + count.getCompProg() + "  |  " + "  -  " + "  |  " + count.getMovProg() + "  |  " + "  -  " + "  |  " + count.getTtotal();

        count = new Arquivo("Arquivos/CountSortPior.dat");
        count.executaCount(vetPior);
        aux += " || " + count.getCompProg() + "  |  " + "  -  " + "  |  " + count.getMovProg() + "  |  " + "  -  " + "  |  " + count.getTtotal();

        count = new Arquivo("Arquivos/CountSortMedio.dat");
        count.executaCount(vetMed);
        aux += " || " + count.getCompProg() + "  |  " + "  -  " + "  |  " + count.getMovProg() + "  |  " + "  -  " + "  |  " + count.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Count Sort: PRONTO");

        //BUCKET SORT
        System.out.println("\nBucket Sort: EM EXECUÇÃO");
        Arquivo bucket = new Arquivo("Arquivos/BucketSortMelhor.dat");
        bucket.executaBucket(vetMelhor);
        aux += "\nBucket Sort           |  " + bucket.getCompProg() + "  |  " + "  -  " + "  |  " + bucket.getMovProg() + "  |  " + "  -  " + "  |  " + bucket.getTtotal();

        bucket = new Arquivo("Arquivos/BucketSortPior.dat");
        bucket.executaBucket(vetPior);
        aux += " || " + bucket.getCompProg() + "  |  " + "  -  " + "  |  " + bucket.getMovProg() + "  |  " + "  -  " + "  |  " + bucket.getTtotal();

        bucket = new Arquivo("Arquivos/BucketSortMedio.dat");
        bucket.executaBucket(vetMed);
        aux += " || " + bucket.getCompProg() + "  |  " + "  -  " + "  |  " + bucket.getMovProg() + "  |  " + "  -  " + "  |  " + bucket.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Bucket Sort: PRONTO");

        //RADIX SORT
        System.out.println("\nRadix Sort: EM EXECUÇÃO");
        Arquivo radix = new Arquivo("Arquivos/RadixSortMelhor.dat");
        radix.executaRadix(vetMelhor);
        aux += "\nRadix Sort           |  " + radix.getCompProg() + "  |  " + "  -  " + "  |  " + radix.getMovProg() + "  |  " + "  -  " + "  |  " + radix.getTtotal();

        radix = new Arquivo("Arquivos/RadixSortPior.dat");
        radix.executaRadix(vetPior);
        aux += " || " + radix.getCompProg() + "  |  " + "  -  " + "  |  " + radix.getMovProg() + "  |  " + "  -  " + "  |  " + radix.getTtotal();

        radix = new Arquivo("Arquivos/RadixSortMedio.dat");
        radix.executaRadix(vetMed);
        aux += " || " + radix.getCompProg() + "  |  " + "  -  " + "  |  " + radix.getMovProg() + "  |  " + "  -  " + "  |  " + radix.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Raix Sort: PRONTO");

        //GNOME SORT
        System.out.println("\nGnome Sort: EM EXECUÇÃO");
        Arquivo gnome = new Arquivo("Arquivos/GnomeSortMelhor.dat");
        gnome.executaGnome(vetMelhor);
        aux += "\nGnome Sort           |  " + gnome.getCompProg() + "  |  " + "  -  " + "  |  " + gnome.getMovProg() + "  |  " + "  -  " + "  |  " + gnome.getTtotal();

        gnome = new Arquivo("Arquivos/GnomeSortPior.dat");
        gnome.executaGnome(vetPior);
        aux += " || " + gnome.getCompProg() + "  |  " + "  -  " + "  |  " + gnome.getMovProg() + "  |  " + "  -  " + "  |  " + gnome.getTtotal();

        gnome = new Arquivo("Arquivos/GnomeSortMedio.dat");
        gnome.executaGnome(vetMed);
        aux += " || " + gnome.getCompProg() + "  |  " + "  -  " + "  |  " + gnome.getMovProg() + "  |  " + "  -  " + "  |  " + gnome.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Gnome Sort: PRONTO");

        //COMB SORT
        System.out.println("\nComb Sort: EM EXECUÇÃO");
        Arquivo comb = new Arquivo("Arquivos/CombSortMelhor.dat");
        comb.executaComb(vetMelhor);
        aux += "\nComb Sort           |  " + comb.getCompProg() + "  |  " + "  -  " + "  |  " + comb.getMovProg() + "  |  " + "  -  " + "  |  " + comb.getTtotal();

        comb = new Arquivo("Arquivos/CombSortPior.dat");
        comb.executaComb(vetPior);
        aux += " || " + comb.getCompProg() + "  |  " + "  -  " + "  |  " + comb.getMovProg() + "  |  " + "  -  " + "  |  " + comb.getTtotal();

        comb = new Arquivo("Arquivos/CombSortMedio.dat");
        comb.executaComb(vetMed);
        aux += " || " + comb.getCompProg() + "  |  " + "  -  " + "  |  " + comb.getMovProg() + "  |  " + "  -  " + "  |  " + comb.getTtotal();
        aux += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("Comb Sort: PRONTO");

        try {
            FileWriter arq = new FileWriter("Resultado.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("%s", aux);
            arq.close();

        } catch (Exception er) {
        }

    }

    public static double[] calculaComp() {
        double[] vet = new double[15];
       
        vet[0] = Math.round(TF - 1);
        vet[1] = Math.round((TF * TF + TF - 2) / 4);
        vet[2] = Math.round((TF * TF + TF - 4) / 4);
  
        vet[3] = vet[4] = vet[5] = Math.round(TF * (Math.log(TF - Math.E)));

        vet[6] = vet[7] = vet[8] = vet[9] = vet[10] = vet[11] = vet[12] = vet[13] = vet[14] = Math.round((TF * TF - TF) / 2);
        return vet;
    }

    public static double[] calculaMov() {
        double[] vet = new double[15];
        
        vet[0] = Math.round(3 * (TF - 1));
        vet[1] = Math.round((TF * TF + 9 * TF - 10) / 4);
        vet[2] = Math.round((TF * TF + 3 * TF - 4) / 2);

        vet[3] = Math.round(3 * (TF - 1));
        vet[4] = Math.round((TF * TF + 9 * TF - 10) / 4);
        vet[5] = Math.round((TF * TF + 3 * TF - 4) / 2);

        vet[6] = Math.round(3 * (TF - 1));
        vet[7] = Math.round(TF * (Math.log(TF) + 0.577216));
        vet[8] = Math.round(TF * TF / 4 + 3 * (TF - 1));

        vet[9] = 0;
        vet[10] = Math.round(3 * (TF * TF - TF) / 2);
        vet[11] = Math.round(3 * (TF * TF - TF) / 4);

        vet[12] = 0;
        vet[13] = Math.round(3 * (TF * TF - TF) / 2);
        vet[14] = Math.round(3 * (TF * TF - TF) / 4);
        return vet;
    }

}
