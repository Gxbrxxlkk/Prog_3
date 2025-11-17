package Prog_3.Aula_5.Ex_1;

public class ex1 {
 
    public double divisao(int numerador, int denominador) throws ArithmeticException {
        try {
            return (double) (numerador / denominador);
        }
        catch (ArithmeticException a) {
            System.err.println("Erro de divisão, divisão por 0");
        }
    } 
    public static void main(String[] args) {
        
    }
}
