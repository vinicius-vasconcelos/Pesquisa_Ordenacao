/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenpoo;

import Lista.Listagen;

/**
 *
 * @author hiroshi
 */
public class ListaGenPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Listagen lista = new Listagen();
        //lista.Construir("[[a,b]]");
        lista.Construir("[aa,[bb,cc],[dd,[ee],ff,gg],hh, vv,[kk,[kg]]]");
        
        lista.printa();
        System.out.println(""+lista.getcadeia());
    }
}
