package estados_cidades;

import classes.ListaEstados;

public class Estados_Cidades {

    public static void main(String[] args) {
        ListaEstados cabEstado = new ListaEstados();
        
        cabEstado.inserir("São Paulo");
        cabEstado.inserir("zarana");
        
        cabEstado.exibir();
      
        
    }
    
}
