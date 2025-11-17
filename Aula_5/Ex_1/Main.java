package Prog_3.Aula_5.Ex_1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        ex1 a = new ex1();

        do {
            try {

                System.out.println("Insira o numerador: ");
                int numerador = scanner.nextInt();
                System.out.println("Insira o denominador: ");
                int denominador = scanner.nextInt();


                double resultado = a.divisao(numerador, denominador);
                System.out.println("Resultado de " + numerador + "dividido por " + denominador + " = " + resultado);
                flag = false;
            }
            catch (InputMismatchException i) {
                System.err.println("Erro de tipo, insira um valor válido (inteiro): ");
                scanner.nextLine();
            }

        } while (flag);
    }
}
