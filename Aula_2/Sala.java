package Prog_3.Aula_2;
import java.util.ArrayList;
import java.util.Iterator;

public class Sala {
    
    public Sala() {
        alunos = new ArrayList<String>();
    }

    public static void main(String[] args) {
        Sala s = new Sala();
        s.setAluno("Pedro");
        s.setAluno("Gabriel");
        s.setAluno("Vinicius");
        s.mostrarAlunos();

        s.alunos.remove(1);

        s.mostrarAlunos();
    }

    public ArrayList<String> alunos;

    public void setAluno(String aluno) {
        alunos.add(aluno);
    }

    public void mostrarAlunos() {
        Iterator i  = alunos.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
