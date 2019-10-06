/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import java.util.Stack;

/**
 *
 * @author hiroshi
 */
public class Listagen {

    private No L;
    private String cadeia = "";

    public Listagen() {
        this.L = null;
    }

    public String getcadeia() {
        return cadeia;
    }

    No nula(No L) {
        if (L == null) {
            return null;
        }
        return L;
    }

    private String getAtomo(int pos, String entrada) {
        String aux = "";
        while (pos < entrada.length() && Character.isLetter(entrada.charAt(pos))) {
            System.out.println("" + entrada.charAt(pos));
            aux += entrada.charAt(pos) + "";
            pos++;
        }
        return aux;
    }

    public boolean atomo(No L) {
        if (L instanceof Atomo) {
            return true;
        }
        return false;
    }

    public Atomo criaT(String info) {
        return new Atomo(info);
    }

    public No Cons(Lista H, Lista T) {
        if (atomo(T)) {
            System.out.println("Erro");
            return null;
        } else {
            return new Lista(H, T);
        }
    }

    No head(Lista L) {
        return ((Lista) L).getCabeca();
    }

    No tail(Lista L) {
        return ((Lista) L).getCauda();
    }

    Boolean Atomo(No L) {
        if (L instanceof Atomo) {
            return true;
        }
        return false;
    }

    public void Construir(String entrada) {
        String aux;
        No ultimo = null;
        Stack pilha = new Stack();

        for (int i = 0; i < entrada.length(); i++) {
            if (L == null) {
                if (entrada.charAt(i) == '[') {
                    L = Cons(null, null);
                    ultimo = L;
                    pilha.push(ultimo);
                } else {
                    System.out.println("Há um atomo no inicio da lista");
                }
            } else {
                if (entrada.charAt(i) == '[') {
                    ((Lista) ultimo).setCabeca(Cons(null, null));
                    pilha.push(ultimo);
                    ultimo = ((Lista) ultimo).getCabeca();
                }
                if (entrada.charAt(i) == ',') {
                    ((Lista) ultimo).setCauda(Cons(null, null));
                    ultimo = ((Lista) ultimo).getCauda();
                }
                if (Character.isLetter(entrada.charAt(i))) {
                    aux = "";
                    while (i < entrada.length() && Character.isLetter(entrada.charAt(i))) {
                        aux += entrada.charAt(i++) + "";
                    }
                    ((Lista) ultimo).setCabeca(criaT(aux));
                    i--;
                }
                if (entrada.charAt(i) == ']') {
                    ultimo = ((Lista) pilha.pop());
                }
            }
        }
    }

    public void printa() {
        print_recursive(((Lista) L));
    }

    public void print_recursive(No L) {
        if (L instanceof Atomo) {
            cadeia += (((Atomo) L).getInfo());
        } else {
            cadeia += "[";
            while (nula(L) != null && !Atomo(L)) {
                print_recursive((((Lista) L).getCabeca()));
                L = tail(((Lista) L));
                if (L != null) {
                    cadeia += ",";
                }
            }
            cadeia += "]";
        }
    }

    /*public void exibe() {
        Stack pilha = new Stack();
        pilha.push((Lista) L);
        No aux = null;
        String str = "";
        
        while (!pilha.isEmpty()) {
            aux = ((Lista) pilha.pop());
            while (nula(aux) != null && !Atomo(aux)) {
                System.out.println("[");
                pilha.push(((Lista)aux));
                aux = (((Lista)aux).getCabeca());
            }
            if(Atomo(aux))
            {
                System.out.println(""+(((Atomo)aux).getInfo()));
                aux = (((Lista)pilha.pop()));
            }
            
            aux = tail(((Lista)aux));
            if(aux != null)
                System.out.println(",");
            else
                aux = (((Lista)pilha.pop()));
        }
        System.out.println(""+str);
    }*/
}
