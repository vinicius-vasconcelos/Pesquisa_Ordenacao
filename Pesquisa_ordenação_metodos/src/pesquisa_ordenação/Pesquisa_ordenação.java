package pesquisa_ordenação;

import classes.Lista;
import classes.Vetor;

public class Pesquisa_ordenação {

    public static void main(String[] args) {
        Vetor vet =  new Vetor();
        
        vet.inserir(2);
        vet.inserir(10);
        vet.inserir(0);
        vet.inserir(1);
        vet.inserir(3);
        
        System.out.println("Vetor desordenado: \n");
        vet.exibir();
        
        System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado: \n");
        vet.insercao_direta();
        vet.exibir();
        
        
        /*System.out.println("\n--------------------------\n");
        int chave = 15;
        int pos = vet.busca_exaustiva(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        
        /*System.out.println("\n--------------------------\n");
        int chave = 20;
        int pos = vet.busca_sentinela(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        /*Lista cab = new Lista();
        
        cab.inserirNoInicio(1);
        cab.inserirNoInicio(2);
        cab.inserirNoInicio(3);
        
        cab.inserirNoFinal(1);
        cab.inserirNoFinal(2);
        cab.inserirNoFinal(3);
        
        cab.exibir();*/
    }
    
}
