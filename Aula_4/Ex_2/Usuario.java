package Prog_3.Aula_4.Ex_2;

public class Usuario {
    
    private String nome;
    private NivelAcesso nivel;

    public Usuario(String nome, NivelAcesso level) {
        this.nome = nome;
        this.nivel = level;
    }

    public String getNome() {
        return nome;
    }

    public NivelAcesso getNivel() {
        return this.nivel;
    }

    public void mensagem() {
        if (this.nivel == NivelAcesso.ADMIN) {
            System.out.println("Você é administrador");
        } else if (this.nivel == NivelAcesso.INTERMEDIARIO) {
            System.out.println("Você é intermediario");
        } else if (this.nivel == NivelAcesso.BASICO) {
            System.out.println("Você é basico");
        }
    }
}
