package Prog_3.Integracao_bd;

public class Livro {
    private int id;
    private String titulo;
    
    private String autor;
    private int ano;
    public Livro() {}
    
    // GETTERS E SETTERS
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }
    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }
    public String getAutor() { 
        return autor; 
    }
    public void setAutor(String autor) { 
        this.autor = autor; 
    }
    public int getAno() { 
        return ano; 
    }
    public void setAno(int ano) { 
        this.ano = ano; 
    }
}