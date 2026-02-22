package Prog_3.Aula_8.Ex_3;

import java.awt.*;
import javax.swing.*;

public class janela_texto_3 extends JFrame {
    
    private JLabel titulo, descr, campo1, campo2, escolhLabel, resultadoLabel;
    private JTextField numero1, numero2;
    private JComboBox<String> operacao; // Somar, sub, multi, dividi
    private JCheckBox escolhe_Jopti, escolhe_Text;
    private JButton calcular_botao;

    public janela_texto_3() {
        this.setSize(1200, 720);    //Tamanho da janela
        this.setLocation(100, 100); //Pixel onde começa a janela
        this.setLayout(new GridLayout(5, 4));    //ajustar depois
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titulo = new JLabel("Insira os numeros: ", JLabel.LEFT);
        campo1 = new JLabel("Numero 1: ", JLabel.LEFT);
        numero1 = new JTextField();
        campo2 = new JLabel("Numero 2: ", JLabel.LEFT);
        numero2 = new JTextField();
        String[] operacoes = {"Somar", "Subtrair", "Multiplicar", "Dividir"};
        operacao = new JComboBox<>(operacoes);
        escolhLabel = new JLabel("Onde o resultado deve aparecer?", JLabel.LEFT);
        escolhe_Jopti = new JCheckBox("Resultado em JOptionPane?");
        escolhe_Jopti.setSelected(true);
        escolhe_Text = new JCheckBox("Resultado em Texto?");
        escolhe_Text.setSelected(true);
        resultadoLabel = new JLabel("Resultado: ", JLabel.LEFT);
        calcular_botao = new JButton("Calcular");
        
        // Ação do botão Calcular
        calcular_botao.addActionListener(e -> calcular());

        this.add(titulo);
        this.add(new JLabel("")); //pra da espaço
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(campo1);
        this.add(numero1);
        this.add(campo2);
        this.add(numero2);
        this.add(new JLabel("Operação:", JLabel.LEFT));
        this.add(operacao);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(escolhLabel);
        this.add(escolhe_Jopti);
        this.add(escolhe_Text);
        this.add(calcular_botao);
        this.add(resultadoLabel);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        
        this.setVisible(true);
    }
    
    private void calcular() {
        
        // Converter os números de entrada para inteiros
        int n1 = Integer.parseInt(numero1.getText().trim());
        int n2 = Integer.parseInt(numero2.getText().trim());
        
        // Obter a operação escolhida
        String op = (String) operacao.getSelectedItem();
        int resultado = 0;
        
        // Executar a operação
        switch (op) {
            case "Somar":
                resultado = n1 + n2;
                break;
            case "Subtrair":
                resultado = n1 - n2;
                break;
            case "Multiplicar":
                resultado = n1 * n2;
                break;
            case "Dividir":
                if (n2 == 0) {
                    throw new ArithmeticException("Erro: Divisão por zero!");
                }
                resultado = n1 / n2;
                break;
        }
        
        String msg = n1 + " " + op.toLowerCase() + " " + n2 + " = " + resultado;
        
        // Mostrar resultado conforme os checkboxes selecionados
        if (escolhe_Text.isSelected()) {
            resultadoLabel.setText(msg);
        }
        
        if (escolhe_Jopti.isSelected()) {
            JOptionPane.showMessageDialog(this, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
        

    }
    
    public static void main(String[] args) {
        new janela_texto_3();
    }

}
