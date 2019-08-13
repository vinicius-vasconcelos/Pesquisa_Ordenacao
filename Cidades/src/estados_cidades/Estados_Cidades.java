package estados_cidades;

import classes.ListaEstados;

public class Estados_Cidades {

    public static void main(String[] args) {
        ListaEstados cabEstado = new ListaEstados();
        
        /*cabEstado.inserir("Sao Paulo", "Assis");
        cabEstado.inserir("Parana", "Londrina");
        cabEstado.inserir("Sao Paulo", "Andradina");
        cabEstado.inserir("Parana", "maringa");
        
        cabEstado.inserir("Acre", "Rio Branco");
        cabEstado.inserir("Sao Paulo", "Santos");*/
        
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
        System.out.println(cabEstado.buscaEstado("São Paulo"));
        
        System.out.println("\n-------------------------------\n");
        System.out.println(cabEstado.buscaCidade("Blumenau"));
        
        System.out.println("\n-------------------------------\n");
        System.out.println(cabEstado.buscaPar("Parana", "Assis"));
        
    }
    
}
