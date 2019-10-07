package metArq_main.util;

import java.util.ArrayList;
import java.util.Collections;

public class Randomizador {

    public static int[] piorCaso(int tf) {
        int vet[] = new int[tf];
        int tl = tf;
        for (int i = 0; i < tf; i++) {
            vet[i] = --tl;
        }
        return vet;
    }

    public static int[] melhorCaso(int tf) {
        int vet[] = new int[tf];
        for (int i = 0; i < tf; i++) {
            vet[i] = i;
        }
        return vet;
    }

    public static int[] casoMedio(int tf) {
        int vetor[] = new int[tf];
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < tf; i++) {
            lista.add(i);
        }

        Collections.shuffle(lista);
        for (int i = 0; i < tf; i++) {
            vetor[i] = lista.get(i);
        }
        return vetor;
    }
}
