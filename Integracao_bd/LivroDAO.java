package Prog_3.Integracao_bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    
    public void inserir(Livro livro) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO livro (titulo, autor, ano) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());   
        stmt.setString(2, livro.getAutor());    
        stmt.setInt(3, livro.getAno());     
        
        stmt.execute();
        
        conn.close();
    }
    public List<Livro> listar() throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM livro";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Livro> lista = new ArrayList<>();
        
        while (rs.next()) {
            Livro l = new Livro();
            l.setId(rs.getInt("id"));            
            l.setTitulo(rs.getString("titulo"));  
            l.setAutor(rs.getString("autor"));    
            l.setAno(rs.getInt("ano"));            
            
            lista.add(l);
        }
        
        conn.close();
    
        return lista;
    }

    public Livro busca_titulo(String titulo_livro) throws Exception {

        Connection conn = Conexao.conectar();       //Conexão
        String sql = "SELECT l.id, l.titulo, l.autor, l.ano from livro l where (l.titulo like ?)"; //seleciona o livro que tem o titulo = a entrada
        PreparedStatement stmt = conn.prepareStatement(sql);  
        stmt.setString(1, '%' + titulo_livro + '%');   // Passa o nome do livro + % em ambos os lados, retorna qualquer tupla que a substring titulo_livro estiver inserida
        ResultSet rs = stmt.executeQuery();  //Executa a consulta e salva o resultado em rs
        rs.next();      // para mover o cursor para a linha consultada
        Livro saida = new Livro();      //Cria um livro pra retornar

        //Pega os resultados da consulta e guarda nesse objeto    
        saida.setTitulo(rs.getString("titulo"));
        saida.setAutor(rs.getString("autor"));
        saida.setAno(rs.getInt("ano"));

        conn.close();       //Fecha a conexão
        return saida;       //retorna o livro
    }
}