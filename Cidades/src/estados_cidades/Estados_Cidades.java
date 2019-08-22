package estados_cidades;

import classes.ListaEstados;

public class Estados_Cidades {

    public static void main(String[] args) {
        ListaEstados cabEstado = new ListaEstados();
        
        /*cabEstado.inserir("e", "Assis");
        cabEstado.inserir("b", "Londrina");
        cabEstado.inserir("e", "Andradina");
        cabEstado.inserir("c", "maringa");
        
        cabEstado.inserir("f", "Rio Branco");
        cabEstado.inserir("a", "Santos");*/
        
        cabEstado.inserir("Parana", "Londrina");
        cabEstado.inserir("Parana", "Arapongas");
        cabEstado.inserir("Santa Catarina", "Joinville");
        cabEstado.inserir("Santa Catarina", "Blumenau");
        cabEstado.inserir("São Paulo", "Marilia");
        cabEstado.inserir("Parana", "Apucarana");
        cabEstado.inserir("Parana", "maringa");
        cabEstado.inserir("São Paulo", "Assis");
        cabEstado.inserir("São Paulo", "Presidente Prudente");
       
        
        cabEstado.exibir();
       
        System.out.println("\n-------------------------------\n");
        System.out.println(cabEstado.buscarEstado("São Paulo"));
        
        System.out.println("\n-------------------------------\n");
        System.out.println(cabEstado.buscarCidade("maringa"));
        
        System.out.println("\n-------------------------------\n");
        System.out.println(cabEstado.buscaPar("São Paulo", "Assis"));   
    }
}
