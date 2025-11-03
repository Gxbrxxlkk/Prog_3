package Prog_3.Aula_3.Ex_2;

public class Aluno extends Pessoa {
    
    public Aluno(String umNome, int umaIdade, int umaMatricula) {
        super(umNome,umaIdade);
        this.matricula = umaMatricula;
    }

    public int getMatricula() { return matricula;}

    //declaração de atributo
    private int matricula;

    public static void main(String[] args) {
        Aluno A1 = new Aluno("Gabriel", 19, 12345);

        System.out.println("Nome: " + A1.getNome() + "\nIdade: " + A1.getIdade() + "\nMatricula: " + A1.getMatricula());
        
    }
}
