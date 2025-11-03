package Prog_3.Aula_3.Ex_3;

public class Pessoa {

    public Pessoa(String umNome, int umaIdade) {
        if (!(umNome.isEmpty())) nome = umNome;
        else nome = "N/A";

        if (umaIdade > 0 && umaIdade < 120) idade = umaIdade;
        else idade = 0;
    }

    public String getNome() { return nome;}
    public int getIdade() { return idade;}

    public void setNome(String umNome) {
        if (!(umNome.isEmpty())) nome = umNome;
        else nome = "N/A";
    }
    public void setIdade(int umaIdade) {
        if (umaIdade > 0 && umaIdade < 120) idade = umaIdade;
        else idade = 0;
    }


    //Declaração de atributos
    private String nome;
    private int idade;


    public static void main(String[] args) {
    }
}
