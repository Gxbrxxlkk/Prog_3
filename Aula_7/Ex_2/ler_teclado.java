package Prog_3.Aula_7.Ex_2;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ler_teclado {
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintStream ps = new PrintStream("saida.txt");

        while (true) {
            String palavra = s.nextLine();
            if (palavra.equals("FIM")) {
                break;
            }
            ps.println(palavra);
        }
        ps.close();
        s.close();
    }
}
