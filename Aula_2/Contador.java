package Prog_3.Aula_2;

public class Contador {
    
    public Contador() {
        contador++;
    }

    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();

        mostrarTotal();
    }
    //declaração de atributo
    public static int contador;

    //declaração de método
    public static void mostrarTotal() {
        System.out.println("Total de objetos criados: " + contador);
    }

}
