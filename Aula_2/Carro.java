package Prog_3.Aula_2; //Tem que especificar a pasta que está?

public class Carro {
    
    public static void main(String[] args) {
        
        Carro c1 = new Carro();
        c1.ano = 2012;
        c1.marca = "Chevrolet";
        c1.modelo = "Astra";

        c1.exibirInfo();

        Carro c2 = new Carro();
        c2.ano = 1998;
        c2.marca = "VolksVagen";
        c2.modelo = "Fusca";

        c2.exibirInfo();

        Carro c3 = new Carro();
        c3.ano = 2020;
        c3.marca = "RAM";
        c3.modelo = "Ultimate";

        c3.exibirInfo();

    }
    //Declaração de atributos
    public String marca;
    public String modelo;
    public int ano;

    //Declaração de método
    public void exibirInfo() {
        System.out.println("Marca do carro: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano do carro: " + this.ano + "\n");
    }
}