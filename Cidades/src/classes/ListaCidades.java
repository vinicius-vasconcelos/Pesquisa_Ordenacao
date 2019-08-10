package classes;

public class ListaCidades {
    
    public void inserir(NoEstado estado, NoCidade novaCidade) {
        
        if(estado.getCidade() == null)
            estado.setCidade(novaCidade);
        else {
           if(!buscar(estado.getCidade(), novaCidade.getInfo())) {
               novaCidade.setBaixo(estado.getCidade());
               estado.setCidade(novaCidade);
           }
        }
    }
    
    private boolean buscar(NoCidade inicio, String info) {
        NoCidade aux = inicio;
        while(aux.getBaixo() != null && info.compareToIgnoreCase(aux.getInfo()) != 0)
            aux = aux.getBaixo();
       
        if(info.compareToIgnoreCase(aux.getInfo()) == 0)
            return true;
        return false;
    }
}
