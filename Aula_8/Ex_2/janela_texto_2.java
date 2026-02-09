package Prog_3.Aula_8.Ex_2;

import java.awt.*;
import javax.swing.*;

public class janela_texto_2 extends JFrame {
    
    private JLabel nome, senha;
    private JTextField campo_nome; 
    private JPasswordField campo_senha;
    private JButton entrar;

    public janela_texto_2() {
        this.setSize(1280, 720);
        this.setLocation(100, 100);
        this.setLayout(new GridLayout(5,1));
        
        nome = new JLabel("Nome: ", SwingConstants.LEFT);
        add(nome);

        campo_nome = new JTextField();
        add(campo_nome);

        senha = new JLabel("Senha: ", SwingConstants.LEFT);
        add(senha);

        campo_senha = new JPasswordField();
        add(campo_senha);
        
        entrar = new JButton("Entrar");
        add(entrar);

        entrar.addActionListener(e -> {
            String usuario = campo_nome.getText();

            JOptionPane.showMessageDialog(
                this,
                "Bem-vindo, " + usuario + "!",
                "Login",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        this.setVisible(true);

    }
    public static void main(String[] args) {
        new janela_texto_2();
    }
}
