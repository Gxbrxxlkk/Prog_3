package Prog_3.Aula_5.Ex_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ex3 a = new ex3();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira um texto para virar numero: ");
        String texto = scanner.next();

        a.seuNumero(texto);

    }
}
