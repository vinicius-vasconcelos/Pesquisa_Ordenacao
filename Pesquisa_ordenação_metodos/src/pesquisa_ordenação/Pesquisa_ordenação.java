package pesquisa_ordenação;

import classes.Lista;
import classes.No;
import classes.Vetor;

public class Pesquisa_ordenação {

    public static void main(String[] args) {
       /* Vetor vet =  new Vetor();
        
        vet.inserir(2);
        vet.inserir(10);
        vet.inserir(0);
        vet.inserir(1);
        vet.inserir(4);
        
        System.out.println("Vetor desordenado: \n");
        vet.exibir();
        
        System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado: \n");
        vet.insercao_direta();
        vet.exibir();
        
        System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado: \n");
        vet.insercao_binaria();
        vet.exibir();*/
        
        
        /*System.out.println("\n--------------------------\n");
        int chave = 15;
        int pos = vet.busca_exaustiva(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        
        /*System.out.println("\n--------------------------\n");
        int chave = 20;
        int pos = vet.busca_sentinela(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        /*System.out.println("\n--------------------------\n");
        int chave = 9;
        int pos = vet.busca_sequencial(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        /*System.out.println("\n--------------------------\n");
        int chave = 11;
        int pos = vet.busca_binaria(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Lista cab = new Lista();
        
        cab.inserirNoInicio(2);
        cab.inserirNoInicio(10);
        cab.inserirNoInicio(0);
        cab.inserirNoInicio(1);
        cab.inserirNoInicio(4);
        
        /*cab.inserirNoFinal(1);
        cab.inserirNoFinal(2);
        cab.inserirNoFinal(3);*/
        
        System.out.println("Lista desordenado: \n");
        cab.exibir();
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Lista ordenado: \n");
        cab.insercao_direta();
        cab.exibir();*/
        
        System.out.println("\n--------------------------\n");
        System.out.println("Lista ordenado: \n");
        cab.insercao_binaria();
        cab.exibir();
        
        /*System.out.println("\n--------------------------\n");
        int chave = 2;
        No pos = cab.busca_exaustiva(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        /*System.out.println("\n--------------------------\n");
        int chave = 1;
        No pos = cab.busca_sentinela(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        /*System.out.println("\n--------------------------\n");
        int chave = 1;
        No pos = cab.busca_sentinela(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        /*System.out.println("\n--------------------------\n");
        int chave = 11;
        No pos = cab.busca_sequencial(chave);
        System.out.println("valor: " + chave + " na pos: " + pos);*/
        
        /*System.out.println("\n--------------------------\n");
        int chave = 5;
        No pos = cab.busca_binaria(chave);
        System.out.println("valor: " + chave + " na pos: " + pos.getInfo());*/
    }
    
}
