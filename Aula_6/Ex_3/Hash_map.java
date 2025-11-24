package Prog_3.Aula_6.Ex_3;

import java.util.HashMap;

public class Hash_map {
    

    //construtor
    public Hash_map() {
        hash_map = new HashMap<String, Integer>();
    }

    //declaração do atributo
    private HashMap<String, Integer> hash_map;

    public void insere(String a, Integer b) {
        hash_map.put(a, b);
    }

    public void descobre_idade(String a) {
        if (hash_map.containsKey(a)) {
            System.out.println("Idade: " + hash_map.get(a));   
        } else System.out.println("Usuário não existe");
    }

    public void print_hash_map() {
        System.out.println(hash_map);
    }

    public void remove(String a) {
        hash_map.remove(a);
    }

    public static void main(String[] args) {}
}
