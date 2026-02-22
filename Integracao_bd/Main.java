package Prog_3.Integracao_bd;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        LivroDAO dao = new LivroDAO();
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setAno(1899);
        
        Livro livro2 = new Livro();                         //segundo livro
        livro2.setTitulo("O Pequeno Príncipe");
        livro2.setAutor("Saint-Exupéry");
        livro2.setAno(1943);

        Livro livro3 = new Livro();                        //Terceiro livro
        livro3.setTitulo("Arsène Lupin – O Ladrão de Casaca");
        livro3.setAutor("Maurice Leblanc");
        livro3.setAno(1907);

        dao.inserir(livro);
        dao.inserir(livro2);
        dao.inserir(livro3);
        List<Livro> livros = dao.listar();
    
        for (Livro l : livros) {
            System.out.println(l.getTitulo() + " - " + l.getAutor());
        }

        // Inserir o nome do livro aqui para buscar
        
        Livro saida_consulta = dao.busca_titulo("O Pequeno Príncipe");                                          
        System.out.println(saida_consulta.getTitulo() + " - " + saida_consulta.getAutor() + ' ' + saida_consulta.getAno());

    }
}