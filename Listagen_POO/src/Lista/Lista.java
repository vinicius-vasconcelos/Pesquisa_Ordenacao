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
public class Lista extends No{
    private No cabeca;
    private No cauda;

    public Lista(No cabeca, No cauda) {
        this.cabeca = cabeca;
        this.cauda = cauda;
    }

    public No getCabeca() {
        return cabeca;
    }

    public void setCabeca(No cabeca) {
        this.cabeca = cabeca;
    }

    public No getCauda() {
        return cauda;
    }

    public void setCauda(No cauda) {
        this.cauda = cauda;
    }
    
    
}
