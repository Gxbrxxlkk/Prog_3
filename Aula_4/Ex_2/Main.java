package Prog_3.Aula_4.Ex_2;

public class Main {
    public static void main(String[] args) {
        Usuario usr1 = new Usuario("@Gxbrxxlkk", NivelAcesso.ADMIN);
        Usuario usr2 = new Usuario("@jonh_poul_", NivelAcesso.INTERMEDIARIO);
        Usuario usr3 = new Usuario("@jm_galdino_pereira", NivelAcesso.BASICO);
    
        usr1.mensagem();
        usr2.mensagem();
        usr3.mensagem();
    
    }
}
