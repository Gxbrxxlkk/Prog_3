package Prog_3.Aula_4.Ex_1;

public abstract class ContaBancaria {
    
    private int numero;
    private String nome_titular;

    public ContaBancaria() {
        this.numero = -1;
        this.nome_titular = "N/A";
    }

    public ContaBancaria(int numero, String nome_titular) {
        this.numero = numero;
        this.nome_titular = nome_titular;
    }

    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);

}
