package Prog_3.Aula_8.Ex_1;

import java.awt.*; 
import javax.swing.*;

public class janela_texto extends JFrame {
    private JLabel texto;
    private JButton botao;
    
    public janela_texto() {
        
        this.setTitle("Janela");
        this.setSize(2000,1000);
        this.setLocation(200,100);
        this.setLayout(new GridLayout(5, 1));

        this.texto = new JLabel("Bem-vindo", SwingConstants.CENTER);
        this.add(this.texto);

        this.botao = new JButton("Sair");
        this.add(this.botao);

        this.botao.addActionListener(e -> {dispose();});


        this.setVisible(true);


    }

    public static void main(String[] args) {
        new janela_texto();
    }

}

