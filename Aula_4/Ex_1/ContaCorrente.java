package Prog_3.Aula_4.Ex_1;

public class ContaCorrente extends ContaBancaria{
    
    public ContaCorrente(int numero, String nome_titular, double valor) {
        super(numero, nome_titular);
        if(valor >= 0) this.saldo = valor;
        else this.saldo = 0;
    }
    

    private double saldo;

    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if ((valor + 1.0) <= this.saldo) {
            this.saldo -= (valor + 1.0); //Taxa de 1 real de saque
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
