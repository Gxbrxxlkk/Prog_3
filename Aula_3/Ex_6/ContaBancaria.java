package Prog_3.Aula_3.Ex_6;

public class ContaBancaria {
    
    public void setNumero(int umNumero) { numero = umNumero; }
    public int getNumero() { return numero; }

    private int numero;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        else if (((ContaBancaria) obj).getNumero() != this.getNumero()) return false;
        else if (((ContaBancaria) obj).getNumero() != this.getNumero()) return false;
        else return true;
    }

    @Override
    public String toString() {
        return ("Numero: " + this.numero);
    }

    public static void main(String[] args) {
     
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();

        conta1.setNumero(1);
        conta2.setNumero(1);

        System.out.println(conta1.toString());
        System.out.println(conta2.equals(conta1));

    }
}
