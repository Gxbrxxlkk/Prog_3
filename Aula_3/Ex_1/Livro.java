package Prog_3.Aula_3.Ex_1;

public class Livro {
    
    //construtor sem parametro
    public Livro() {
        titulo = "N/A";
        autor = "Nenhum";
    }
    //Construtor com parametro
    public Livro(String umTitulo, String umAutor) {
        if (!(umTitulo.isEmpty())) titulo = umTitulo;            
        else titulo = "N/A";
        
        if (!(umAutor.isEmpty())) autor = umAutor;
        else autor = "Nenhum";
    }

    //Declaração de getters e setters
    public String getTituto() { return titulo;}
    public String getAutor() { return autor;}

    public void setTitulo(String umTitulo) {
        if (!(umTitulo.isEmpty())) titulo = umTitulo;            
        else titulo = "N/A";        
    }

    public void setAutor(String umAutor) {
        if (!(umAutor.isEmpty())) autor = umAutor;
        else autor = "Nenhum";        
    }

    //Declaração de atributos
    private String titulo;
    private String autor;

    public static void main(String[] args) {
        
        Livro L1 = new Livro(); //Objeto declarado sem parâmetro
        Livro L2 = new Livro("Arsène Lupin e a rolha de cristal", "Maurice Leblanc"); //Objeto declarado com parametro

        System.out.println("Titulo: " + L1.getTituto() + "\nAutor: " + L1.getAutor());
        System.out.println("\nTitulo: " + L2.getTituto() + "\nAutor: " + L2.getAutor());

    }


}
