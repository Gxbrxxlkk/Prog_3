package Prog_3.Aula_6.Ex_1;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        lista_array lista = new lista_array();


        //inserção de 10 inteiros pelo o usuario
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println("Insira o " + (i+1) + " numero: ");
            int numero = scanner.nextInt();
            lista.insere(numero);
        }

        //mostrando todos os elementos da lista
        lista.print_lista();

        //mostrando a soma e a média
        lista.calculos();

        //removendo pares e exibindo
        lista.remove_pares();
        lista.print_lista();

    }

}
