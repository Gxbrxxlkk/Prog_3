package Prog_3.Aula_7.Ex_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class mensagem_console {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo (sem extensão): ");
        String nomeArquivo = scanner.nextLine();

        try (
            FileInputStream is = new FileInputStream(nomeArquivo + ".txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr)) {

            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {  
            System.err.println("Erro: " + e);
        }
} 
    
}
