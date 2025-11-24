package Prog_3.Aula_6.Ex_2;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hash_set hash = new Hash_set();

        while (true) {
            System.out.println("Insira uma palavra");
            String palavra = scanner.nextLine();

            if (palavra.equals("fim")) {
                break;
            } else {
                hash.insere(palavra);
            }
        }

        //Mostra o hash
        hash.print_hash();

        //Mostra se tem java no hash
        System.out.println("Tem Java escrito? " + hash.tem_java());

    }
}
