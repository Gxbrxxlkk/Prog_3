package Prog_3.Aula_3.Ex_5;

public class Calculadora {
    

    public int somar(int a, int b) {
        return a+b;
    }
    public double somar(double a, double b) {
        return a+b;
    }
    public int somar(int a, int b, int c) {
        return a+b+c;
    }

    public static void main(String[] args) {
        
        Calculadora calc = new Calculadora();
        System.out.println("Soma de 45 + 22: " + calc.somar(45,22) + "\nSoma de 45.45 + 22.22: " + calc.somar(45.45,22.22) + "\nSoma de 45 + 22 + 16: " + calc.somar(45,22,16));
    }

}
