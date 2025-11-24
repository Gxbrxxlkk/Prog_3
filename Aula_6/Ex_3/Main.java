package Prog_3.Aula_6.Ex_3;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Hash_map hash_map = new Hash_map();

        hash_map.insere("Gabriel", 19);
        hash_map.insere("Bruno", 16);
        hash_map.insere("Joao", 19);
        hash_map.insere("Victoria", 19);
        hash_map.insere("Braz", 23);

        while (true) {
            
            System.out.println("Insira um nome, digite fim para parar de inserir: ");
            String nome = scanner.nextLine();
            System.out.println("Insira a idade: ");
            Integer idade = scanner.nextInt();

            if (nome.equals("fim")) {
                break;
            } else hash_map.insere(nome, idade);
        }   

        hash_map.print_hash_map();

        //usando nome para descobri a idade
        hash_map.descobre_idade("Gabriel");

        //removendo alguem pelo nome e printando
        hash_map.remove("Joao");
        hash_map.print_hash_map();

    }

}
