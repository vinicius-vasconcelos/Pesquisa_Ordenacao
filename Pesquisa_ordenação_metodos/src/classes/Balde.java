/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author hiroshi
 */
public class Balde {

    private int[] vet;
    private int TL;

    public Balde() {
        this.vet = new int[10];
        this.TL = 0;
    }

    public int[] getVet() {
        return vet;
    }

    public void setVet(int[] vet) {
        this.vet = vet;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }
    
    public void insere(int chave)
    {
        vet[TL++] = chave;
    }

    public void insercao_direta() {
        int pos, aux;
        
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
    
    /*public int[] concatena()
    {
        int vetor[] = new int[10];
        int tam = 0;
        
        for(int i = 0; i < vet.size();i++)
            vetor[tam++] = vet.get(i);
        
        return vetor;
    }*/
}
