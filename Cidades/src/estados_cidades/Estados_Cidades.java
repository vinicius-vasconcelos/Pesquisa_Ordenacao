package estados_cidades;

import classes.ListaEstados;

public class Estados_Cidades {

    public static void main(String[] args) {
        ListaEstados cabEstado = new ListaEstados();
        
        cabEstado.inserir("Sao Paulo", "Assis");
        cabEstado.inserir("Parana", "Londrina");
        //cabEstado.inserir("Rio de janeiro", "Jacarepagua");
        cabEstado.inserir("Sao Paulo", "Andradina");
        cabEstado.inserir("Parana", "maringa");
        //cabEstado.inserir("Acre", "maringa");
        
       cabEstado.exibir();
      
        
    }
    
}
