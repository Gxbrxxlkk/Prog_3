package Prog_3.Aula_4.Ex_1;

public class ContaPoupanca extends ContaBancaria {
    
    public ContaPoupanca(int numero, String nome_titular, double valor) {
        super(numero, nome_titular);
        if (valor >= 0) this.saldo = valor;
        else this.saldo = 0;
    }

    private double saldo;

    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor; //Sem taxa de saque
            return true;
        }
        else return false;
    }
    
    @Override
    public void depositar(double valor) {
        if (valor >= 0) {
            this.saldo += valor;
        } else return;
    }
}
