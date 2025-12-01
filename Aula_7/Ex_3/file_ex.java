package Prog_3.Aula_7.Ex_3;

import java.util.Scanner;
import java.io.File;

public class file_ex {
    
    public static void main(String[] args) {
        System.out.println("Insira um caminho para o arquivo: ");
        Scanner scanner = new Scanner(System.in);
        String caminho = scanner.nextLine();
        System.out.println("Caminho do arquivo: " + caminho);
        scanner.close();

        File a = new File(caminho);
        if (a.exists()) {
            System.out.println("O arquivo existe.");
            if (a.isFile()) {
                System.out.println("É um arquivo.");
            } else if (a.isDirectory()) {
                System.out.println("É um diretório.");
            }
            System.out.println("Tamanho do arquivo em bytes: " + a.length());
            System.out.println("Caminho absoluto: " + a.getAbsolutePath());
        } else {
            System.out.println("O arquivo nao existe.");
        }
    }
}