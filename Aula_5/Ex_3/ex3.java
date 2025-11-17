package Prog_3.Aula_5.Ex_3;

public class ex3 {
    
    public int seuNumero(String texto) throws NumberFormatException {

        try {

            int numero = Integer.parseInt(texto);
            
            System.out.println("Seu numero é: " + numero);
            return numero;

        }
        catch (NumberFormatException n) {

            System.err.println("Deu erro");
            
        }
        finally {
            System.out.println("Programa encerrado");
        }
    }

    public static void main(String[] args) {
        
    }
}
