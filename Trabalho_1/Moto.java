package Prog_3.Trabalho_1;

public class Moto extends Veiculo {

    public Moto(String adescricao) {
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
        if (velocidade == 10) System.out.println("A Moto saiu do lugar, e está a " + velocidade + " km/h");
        else if (velocidade < 30) System.out.println("A Moto está andando a " + velocidade + " km/h");
        else if (velocidade < 70) System.out.println("A Moto está relativamente rápida: " + velocidade + " Km/h");
        else System.out.println("A Moto está bem rápida: " + velocidade + " km/h");
    }

    @Override
    public void freiar() {
        if (velocidade > 0) {
            velocidade -= 10;
            System.out.println("Freiando: " + velocidade);
        }
        else System.out.println("A Moto está parada");
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
        return "Moto - " + descricao;
    }

    //Declaração de atributos
    private String descricao;
    private int velocidade;
}
