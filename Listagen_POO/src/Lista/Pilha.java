/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

/**
 *
 * @author hiroshi
 */
public class Pilha {
    private Lista p;
    private Pilha prox;

    public Pilha(Lista p) {
        this.p = p;
        this.prox = null;
    }

    public Lista getP() {
        return p;
    }

    public void setP(Lista p) {
        this.p = p;
    }

    public Pilha getProx() {
        return prox;
    }

    public void setProx(Pilha prox) {
        this.prox = prox;
    }
    
    
}
