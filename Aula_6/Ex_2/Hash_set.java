package Prog_3.Aula_6.Ex_2;

import java.util.HashSet;

public class Hash_set {
    
    public Hash_set() {
        hash = new HashSet<String>();
    }

    private HashSet <String> hash; 

    public void insere(String palavra) {
        hash.add(palavra);
    }

    public void print_hash() {
        System.out.println(hash);
    }

    public boolean tem_java() {
        return hash.contains("Java");
    }

    public static void main(String[] args) {
        
    }
}
