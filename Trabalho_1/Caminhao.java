package Prog_3.Trabalho_1;

public class Caminhao extends Veiculo {

    public Caminhao(String adescricao) {
        this.descricao = (adescricao != null && !adescricao.isEmpty()) ? adescricao : "N/A";
        this.velocidade = 0;
    }

    @Override
    public void descricao() {
        System.out.println("Descrição: " + descricao);
    }

    @Override
    public void acelerar() {
        velocidade += 10;
        if (velocidade == 10) System.out.println("O Caminhão saiu do lugar, e está a " + velocidade + " km/h");
        else if (velocidade < 30) System.out.println("O Caminhão está andando a " + velocidade + " km/h");
        else if (velocidade < 70) System.out.println("O Caminhão está relativamente rápido: " + velocidade + " Km/h");
        else System.out.println("O Caminhão está bem rápido: " + velocidade + " km/h");
    }

    @Override
    public void freiar() {
        if (velocidade > 0) {
            velocidade -= 10;
            System.out.println("Freiando: " + velocidade);
        }
        else System.out.println("O Caminhão está parado");
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String getDescricaoVeiculo() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Caminhão - " + descricao;
    }

    //Declaração de atributos
    private String descricao;
    private int velocidade;
}
