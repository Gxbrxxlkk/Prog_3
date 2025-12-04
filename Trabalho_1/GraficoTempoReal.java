package Prog_3.Trabalho_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
usando Swing + Java2D
Exemplo de um gráfico em tempo real, aprender o que cada parte faz e adaptar para o veiculo
*/

public class GraficoTempoReal extends JPanel {

    private final List<Integer> dados = new ArrayList<>();
    private final Random random = new Random();

    public GraficoTempoReal() {
        new Timer(500, e -> {
            int novoValor = random.nextInt(100); // valor aleatório
            dados.add(novoValor);
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int largura = getWidth();
        int altura = getHeight();

        int margemEsq = 60;
        int margemInf = 40;
        int margemDir = 20;
        int margemSup = 20;

        // fundo
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, largura, altura);

        // desenhar grid
        g2.setColor(new Color(220, 220, 220));

        // linhas horizontais (Y)
        for (int y = 0; y <= 100; y += 20) {
            int yy = altura - margemInf - (y);
            g2.drawLine(margemEsq, yy, largura - margemDir, yy);
        }

        // desenhar eixos
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(margemEsq, margemSup, margemEsq, altura - margemInf);          // eixo Y
        g2.drawLine(margemEsq, altura - margemInf, largura - margemDir, altura - margemInf); // eixo X

        // marcações no eixo Y
        g2.setFont(new Font("Arial", Font.PLAIN, 12));
        for (int y = 0; y <= 100; y += 20) {
            int yy = altura - margemInf - y;
            g2.drawLine(margemEsq - 5, yy, margemEsq, yy); // risquinho
            g2.drawString(String.valueOf(y), margemEsq - 35, yy + 5); // texto
        }

        if (dados.size() < 2)
            return;

        // gráfico
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));

        int espacamentoX = 40;
        int xInicio = margemEsq;

        // desenha linhas do gráfico
        for (int i = 1; i < dados.size(); i++) {
            int x1 = xInicio + (i - 1) * espacamentoX;
            int y1 = altura - margemInf - dados.get(i - 1);

            int x2 = xInicio + i * espacamentoX;
            int y2 = altura - margemInf - dados.get(i);

            g2.drawLine(x1, y1, x2, y2);
        }

        // marcações no eixo X
        g2.setColor(Color.BLACK);
        for (int i = 0; i < dados.size(); i++) {
            int x = xInicio + i * espacamentoX;

            g2.drawLine(x, altura - margemInf, x, altura - margemInf + 5); // risquinho
            g2.drawString(String.valueOf(i), x - 3, altura - margemInf + 20); // número
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráfico em tempo real");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.add(new GraficoTempoReal());
        frame.setVisible(true);
    }
}
