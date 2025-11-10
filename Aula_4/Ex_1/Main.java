package Prog_3.Aula_4.Ex_1;

public class Main {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(123,"Gabriel Loss",100100);
        ContaPoupanca c2 = new ContaPoupanca(321, "Bruno Loss", 1010);

        c1.sacar(100);
        c1.depositar(50);
        System.out.println(c1.getSaldo());

        c2.sacar(100);
        c2.depositar(50);
        System.out.println(c2.getSaldo());

    }
}
