package Prog_3.Aula_3.Ex_4;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> lista_animal = new ArrayList<>();
        Cachorro C1 = new Cachorro();
        Gato G1 = new Gato();
    
        lista_animal.add(C1);
        lista_animal.add(G1);

        for (Animal a : lista_animal) {
            a.emitirSom();
        }
        
    }

}
