package Prog_3.Trabalho_1;

public class Moto extends Veiculo {

    public Moto(String adescricao) {
        
        if (adescricao.isEmpty()) descricao = "N/A";
        else descricao = adescricao;

        velocidade = 0;
    }

    @Override
    public void descricao() {
        System.out.println("Descrição: " + descricao);
    }

    @Override
    public void acelerar() {
        velocidade += 10;
        if (velocidade == 0) System.out.println("O carro saiu do lugar, e está a " + velocidade);
        else if (velocidade < 30) System.out.println("O carro está andando a " + velocidade);
        else if (velocidade < 70) System.out.println("O Carro está relativamente rápido: " + velocidade + " Km/h");
        else System.out.println("O carro está bem rápido" + velocidade + " km/h");
    }

    @Override
    public void freiar() {
        while (velocidade > 0) {
            velocidade -= 10;
            System.out.println("Freiando" + velocidade);
        }
        System.out.println("O carro está parado");
    }

    //Declaração de atributos
    private String descricao;
    private int velocidade;
}
