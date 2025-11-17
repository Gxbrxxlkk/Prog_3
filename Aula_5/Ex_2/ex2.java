package Prog_3.Aula_5.Ex_2;


public class ex2 {
    
    public double calculaRaiz(int numero) throws IllegalArgumentException {

        try {
            return (double) Math.sqrt(numero);
        }
        catch (IllegalArgumentException i) {
            System.err.println("Exceção lançada, não é possivel receber numeros negativos");
        }
        return numero; 
    }

    public static void main(String[] args) {
        
    }

}
