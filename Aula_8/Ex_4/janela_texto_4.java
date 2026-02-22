package Prog_3.Aula_8.Ex_4;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class janela_texto_4 extends JFrame {
    
    private JTextField campoTitulo, campoBusca;
    private JTextArea campoDescricao, areaResultados;
    private JComboBox<String> tipoCombo;
    private JTextField campoAutor, campoDiretor; // Específicos para Livro/Filme
    private JButton btnAdicionar, btnListar, btnFiltrar, btnExportar, btnImportar;
    private java.util.List<Item> itens = new ArrayList<>();
    
    private Color corPrincipal = new Color(70, 130, 180); // Azul royal
    
    public janela_texto_4() {
        this.setTitle("Gerenciador de Livros e Filmes");
        this.setSize(1000, 700);
        this.setLocation(50, 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        // Painel superior com título
        JPanel painelTitulo = new JPanel();
        painelTitulo.setBackground(corPrincipal);
        JLabel titulo = new JLabel("Gerenciador de Conteúdo");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelTitulo.add(titulo);
        this.add(painelTitulo, BorderLayout.NORTH);
        
        // Painel principal com GridBagLayout para melhor controle
        JPanel painelConteudo = new JPanel();
        painelConteudo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // --- Seção de entrada ---
        JLabel lblTipo = new JLabel("Tipo:");
        gbc.gridx = 0; gbc.gridy = 0;
        painelConteudo.add(lblTipo, gbc);
        
        String[] tipos = {"Livro", "Filme"};
        tipoCombo = new JComboBox<>(tipos);
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.gridwidth = 2;
        painelConteudo.add(tipoCombo, gbc);
        gbc.gridwidth = 1;
        
        JLabel lblTitulo = new JLabel("Título:");
        gbc.gridx = 0; gbc.gridy = 1;
        painelConteudo.add(lblTitulo, gbc);
        campoTitulo = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.gridwidth = 2;
        painelConteudo.add(campoTitulo, gbc);
        gbc.gridwidth = 1;
        
        JLabel lblDescricao = new JLabel("Descrição:");
        gbc.gridx = 0; gbc.gridy = 2;
        painelConteudo.add(lblDescricao, gbc);
        campoDescricao = new JTextArea(3, 20);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        painelConteudo.add(new JScrollPane(campoDescricao), gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        
        JLabel lblEspecifico = new JLabel("Autor/Diretor:");
        gbc.gridx = 0; gbc.gridy = 3;
        painelConteudo.add(lblEspecifico, gbc);
        campoDiretor = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.gridwidth = 2;
        painelConteudo.add(campoDiretor, gbc);
        gbc.gridwidth = 1;
        
        // Painel de botões para adicionar/listar
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(corPrincipal);
        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBackground(corPrincipal);
        btnAdicionar.setForeground(Color.WHITE);
        btnAdicionar.addActionListener(e -> adicionar());
        painelBotoes.add(btnAdicionar);
        
        btnListar = new JButton("Listar Tudo");
        btnListar.setBackground(corPrincipal);
        btnListar.setForeground(Color.WHITE);
        btnListar.addActionListener(e -> listar());
        painelBotoes.add(btnListar);
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 3;
        painelConteudo.add(painelBotoes, gbc);
        gbc.gridwidth = 1;
        
        // --- Seção de busca ---
        JLabel lblBusca = new JLabel("Buscar por título:");
        gbc.gridx = 0; gbc.gridy = 5;
        painelConteudo.add(lblBusca, gbc);
        campoBusca = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 5;
        painelConteudo.add(campoBusca, gbc);
        
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBackground(corPrincipal);
        btnFiltrar.setForeground(Color.WHITE);
        btnFiltrar.addActionListener(e -> filtrar());
        gbc.gridx = 2; gbc.gridy = 5;
        painelConteudo.add(btnFiltrar, gbc);
        
        // --- Seção de exportar/importar ---
        JPanel painelArquivos = new JPanel();
        painelArquivos.setBackground(corPrincipal);
        btnExportar = new JButton("Exportar Dados");
        btnExportar.setBackground(new Color(34, 139, 34)); // Verde
        btnExportar.setForeground(Color.WHITE);
        btnExportar.addActionListener(e -> exportar());
        painelArquivos.add(btnExportar);
        
        btnImportar = new JButton("Importar Dados");
        btnImportar.setBackground(new Color(220, 20, 60)); // Vermelho
        btnImportar.setForeground(Color.WHITE);
        btnImportar.addActionListener(e -> importar());
        painelArquivos.add(btnImportar);
        
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 3;
        painelConteudo.add(painelArquivos, gbc);
        gbc.gridwidth = 1;
        
        // --- Área de resultados ---
        JLabel lblResultados = new JLabel("Resultados:");
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 3;
        painelConteudo.add(lblResultados, gbc);
        gbc.gridwidth = 1;
        
        areaResultados = new JTextArea(10, 50);
        areaResultados.setEditable(false);
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        painelConteudo.add(new JScrollPane(areaResultados), gbc);
        
        this.add(painelConteudo, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    private void adicionar() {
        try {
            String tipo = (String) tipoCombo.getSelectedItem();
            String titulo = campoTitulo.getText().trim();
            String descricao = campoDescricao.getText().trim();
            String autor_diretor = campoDiretor.getText().trim();
            
            if (titulo.isEmpty() || descricao.isEmpty() || autor_diretor.isEmpty()) {
                throw new Exception("Todos os campos devem ser preenchidos!");
            }
            
            Item item = new Item(tipo, titulo, descricao, autor_diretor);
            itens.add(item);
            
            JOptionPane.showMessageDialog(this, tipo + " adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            campoTitulo.setText("");
            campoDescricao.setText("");
            campoDiretor.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listar() {
        if (itens.isEmpty()) {
            areaResultados.setText("Nenhum item cadastrado.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itens.size(); i++) {
            sb.append((i + 1) + ". ").append(itens.get(i)).append("\n\n");
        }
        areaResultados.setText(sb.toString());
    }
    
    private void filtrar() {
        try {
            String busca = campoBusca.getText().trim().toLowerCase();
            if (busca.isEmpty()) {
                throw new Exception("Digite algo para buscar!");
            }
            
            StringBuilder sb = new StringBuilder();
            int contador = 0;
            for (Item item : itens) {
                if (item.titulo.toLowerCase().contains(busca)) {
                    contador++;
                    sb.append(contador + ". ").append(item).append("\n\n");
                }
            }
            
            if (contador == 0) {
                areaResultados.setText("Nenhum item encontrado para: " + busca);
            } else {
                areaResultados.setText(sb.toString());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportar() {
        try {
            if (itens.isEmpty()) {
                throw new Exception("Nenhum item para exportar!");
            }
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto", "txt"));
            int resultado = fileChooser.showSaveDialog(this);
            
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File arquivo = fileChooser.getSelectedFile();
                if (!arquivo.getName().endsWith(".txt")) {
                    arquivo = new File(arquivo.getAbsolutePath() + ".txt");
                }
                
                try (FileWriter fw = new FileWriter(arquivo)) {
                    for (Item item : itens) {
                        fw.write(item.tipo + "|" + item.titulo + "|" + item.descricao + "|" + item.autor_diretor + "\n");
                    }
                    JOptionPane.showMessageDialog(this, "Dados exportados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro na exportação: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void importar() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto", "txt"));
            int resultado = fileChooser.showOpenDialog(this);
            
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File arquivo = fileChooser.getSelectedFile();
                itens.clear();
                
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        String[] partes = linha.split("\\|");
                        if (partes.length == 4) {
                            itens.add(new Item(partes[0], partes[1], partes[2], partes[3]));
                        }
                    }
                    JOptionPane.showMessageDialog(this, itens.size() + " itens importados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    listar();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro na importação: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Classe interna para representar um item
    static class Item {
        String tipo, titulo, descricao, autor_diretor;
        
        public Item(String tipo, String titulo, String descricao, String autor_diretor) {
            this.tipo = tipo;
            this.titulo = titulo;
            this.descricao = descricao;
            this.autor_diretor = autor_diretor;
        }
        
        @Override
        public String toString() {
            return "[" + tipo + "] " + titulo + "\n" +
                   "Descrição: " + descricao + "\n" +
                   (tipo.equals("Livro") ? "Autor: " : "Diretor: ") + autor_diretor;
        }
    }
    
    public static void main(String[] args) {
        new janela_texto_4();
    }

}
