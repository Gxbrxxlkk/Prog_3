package Prog_3.Aula_6.Ex_1;

import java.util.ArrayList;

public class lista_array {
    
    public lista_array() {
        lista = new ArrayList<Integer>();
    }

    private ArrayList <Integer> lista;
    
    public void insere(int numero) {
        lista.add(numero);
    }

    public void remove_pares() {
        lista.removeIf(i -> i % 2 == 0);
    }

    public void print_lista() {
        System.out.println(lista);
    }

    public void calculos() {
        
        double soma = 0;

        for (Integer integer : lista) {
            soma += integer;
        }
        
        System.out.println("A soma dos numeros do array é: " + soma);

        double media = 0;
        int tamanho = lista.size();

        media = soma / tamanho;

        System.out.println("A média dos numeros do array é: " + media);
    }

    public static void main(String[] args) {
    }
}
