package pesquisa_ordenação;

import classes.Lista;
import classes.No;
import classes.Vetor;

public class Pesquisa_ordenação {

    public static void main(String[] args) {
       Vetor vet =  new Vetor();
        
        vet.inserir(2);
        vet.inserir(100);
        vet.inserir(8);
        vet.inserir(1);
        vet.inserir(904);
        vet.inserir(105);
        vet.inserir(120);
        vet.inserir(800);
        vet.inserir(15);
        
        System.out.println("Vetor desordenado: \n");
        vet.exibir();
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por INSERÇÃO DIRETA: \n");
        vet.insercao_direta();
        vet.exibir();
        
        System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por INSERÇÃO BINÁRIA: \n");
        vet.insercao_binaria();
        vet.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por SELEÇÃO DIRETA: \n");
        vet.selecao_direta();
        vet.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por BUBBLE SORT: \n");
        vet.bubble_sort();
        vet.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por SHAKE SORT: \n");
        vet.shake_sort();
        vet.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por SHAKE SORT: \n");
        vet.heap_sort();
        vet.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por GNOME SORT: \n");
        vet.gnome_sort();
        vet.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por COMB SORT: \n");
        vet.comb_sort();
        vet.exibir();*/
        
        System.out.println("\n--------------------------\n");
        System.out.println("Vetor ordenado por RADIX SORT: \n");
        vet.radix_sort();
        vet.exibir();
        
        
        
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
        
    
       
        
        
        
        
        
        
        /*Lista cab = new Lista();
        
        cab.inserirNoInicio(2);
        cab.inserirNoInicio(10);
        cab.inserirNoInicio(0);
        cab.inserirNoInicio(1);
        cab.inserirNoInicio(4);
        cab.inserirNoInicio(15);
        cab.inserirNoInicio(12);
        cab.inserirNoInicio(8);
        cab.inserirNoInicio(5);
        
        cab.inserirNoFinal(1);
        cab.inserirNoFinal(2);
        cab.inserirNoFinal(3);
        
        System.out.println("Lista desordenado: \n");
        cab.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Lista ordenada por INSERÇÃO DIRETA: \n");
        cab.insercao_direta();
        cab.exibir();*/
        
        /*System.out.println("\n--------------------------\n");
        System.out.println("Lista ordenada por INSERÇÃO BINÁRIA: \n");
        cab.insercao_binaria();
        cab.exibir();
        
        System.out.println("\n--------------------------\n");
        System.out.println("Lista ordenada por SELEÇÃO DIRETA: \n");
        cab.selecao_direta();
        cab.exibir();*/
        
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