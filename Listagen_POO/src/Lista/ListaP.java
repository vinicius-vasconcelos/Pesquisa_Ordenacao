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
public class ListaP {
    Pilha p;
    
    void push(Lista L)
    {
        Pilha nc;
        if(L == null)
        {
            nc = new Pilha(L);
            p = nc;
        }
        else
        {
            nc = new Pilha(L);
            nc.setProx(p);
            p = nc;
        }
    }
    
    Lista pop()
    {
        Pilha aux;
        Lista auxP;
        if(p == null)
        {
            System.out.println("Nada a ser desempilhado");      
            return null;
        }
        else
        {
            aux = p;
            auxP = aux.getP();
            p.setProx(p.getProx());
            aux = null;
            return auxP;
        }
    }
}
