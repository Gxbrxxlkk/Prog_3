package Prog_3.Trabalho_1;

public class Caminhao extends Veiculo {

    public Caminhao(String adescricao) {
        
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
        if (velocidade == 0) System.out.println("O Caminhão saiu do lugar, e está a " + velocidade);
        else if (velocidade < 30) System.out.println("O Caminhão está andando a " + velocidade);
        else if (velocidade < 70) System.out.println("O Caminhão está relativamente rápido: " + velocidade + " Km/h");
        else System.out.println("O Caminhão está bem rápido" + velocidade + " km/h");
    }

    @Override
    public void freiar() {
        while (velocidade > 0) {
            velocidade -= 10;
            System.out.println("Freiando" + velocidade);
        }
        System.out.println("O Caminhão está parado");
    }

    //Declaração de atributos
    private String descricao;
    private int velocidade;
}
