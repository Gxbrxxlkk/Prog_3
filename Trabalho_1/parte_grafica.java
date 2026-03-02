package Prog_3.Trabalho_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class parte_grafica extends JFrame {

    // Opções tipos disponiveis
    private String[] tipo_veiculo = {"Carro", "Moto", "Caminhão"};

    // Lista com os veículos cadastrados
    private List<Veiculo> listaVeiculos;
    
    // Componentes das janelas
    private JButton bListar_veiculos, bAdicionar_veiculo, bAcelerar, bFreiar;
    private JLabel descricao, tipo, selecionar, valor_velocidade, texto_velocidade;
    private JTextField campoDescricaoVeiculo;
    private JComboBox<String> comboTipoVeiculo;
    private ImageIcon logo = new ImageIcon("Prog_3/Trabalho_1/logo.png");
    private JFrame janela_lista;
    private JComboBox<Veiculo> comboVeiculos;

    public parte_grafica() {

        // Inicializa a lista de veiculos
        this.listaVeiculos = new ArrayList<>();

        // Configuração da janela principal
        this.setTitle("Loja de veiculos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Para não ficar processo aberto ao clicar no X
        this.setLayout(new GridLayout(3, 2, 10, 10));    //10 espaçamento vertical, 10 espaçamento horizontal, para os botões não ficar grudado
        this.setSize(980, 420);     // Tamanho da janela
        this.setLocation(620, 160);     //Localização da janela

        // Criação dos componentes
        descricao = new JLabel("Inserir Veiculo: ", JLabel.CENTER);
        tipo = new JLabel("Tipo: ", logo, JLabel.LEFT);     //Incone do Jlabel para aparecer a logo
        campoDescricaoVeiculo = new JTextField();           //Campo pra inserir a descrição do veiculo
        bAdicionar_veiculo = new JButton("Adicionar veiculo");  
        bListar_veiculos = new JButton("Listar veiculos");
        comboTipoVeiculo = new JComboBox<>(tipo_veiculo);       //Combo box com os tipos de veiculos listados em tipo_veiculo (carro, caminhao, moto)

        //Adicionando componentes na janela
        this.add(tipo);
        this.add(comboTipoVeiculo);
        this.add(descricao);
        this.add(campoDescricaoVeiculo);
        this.add(bAdicionar_veiculo);
        this.add(bListar_veiculos);

        //Tratando o evento do botao de adicionar veiculo
        bAdicionar_veiculo.addActionListener(e -> {

            String descricao = campoDescricaoVeiculo.getText();     //Pega o texto do Jtextfield
        
            if (descricao.isEmpty()) { //Verifica se não tem nada escrito
                JOptionPane.showMessageDialog(this, "Digite a descrição do veículo.");
                return;
            }

            Veiculo veiculo = criarVeiculo(comboTipoVeiculo.getSelectedItem().toString(), descricao);   // Pega o tipo no combobox, transforma em texto, e passa de parametro pra criar o veiculo

            // Salva e limpa o campo para novo cadastro
            listaVeiculos.add(veiculo);
            campoDescricaoVeiculo.setText("");
            JOptionPane.showMessageDialog(this, "Veículo adicionado com sucesso!");

        });

        //Para listar os veiculos da loja
        bListar_veiculos.addActionListener(e -> {

            if (listaVeiculos.isEmpty()) {                  // Lista vazia, mostra nada       
                JOptionPane.showMessageDialog(this, "Nenhum veículo cadastrado.");
                return;
            }
        
            // Janela secundaria, pra mostrar a lista de veiculos e as aç~oes de acelerar e freiar
            
            janela_lista = new JFrame("Lista de Veículos");
            janela_lista.setLayout(new GridLayout(4, 2, 10, 10));   //10,10 para ficar espaçamento entre os componentes
            janela_lista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Pra não ficar processo aberto ao clicar no X
            janela_lista.setSize(500, 220);
            janela_lista.setLocation(620,160);

            selecionar = new JLabel("Selecione o veículo:");
            comboVeiculos = new JComboBox<>(this.listaVeiculos.toArray(new Veiculo[0]));    //Conversão de lista para um vetor, pq é o jeito q o construtor do JComboBox entende
            texto_velocidade = new JLabel("Velocidade atual:");
            valor_velocidade = new JLabel("0 km/h");
            bAcelerar = new JButton("Acelerar");
            bFreiar = new JButton("Freiar");

            // Quando tiver ação na JcomboBox da lista de veiculo, muda o label da velocidade
            comboVeiculos.addActionListener(ev -> {
                Veiculo veiculo_selecionado = (Veiculo) comboVeiculos.getSelectedItem(); 
                valor_velocidade.setText(veiculo_selecionado.getVelocidade() + " km/h");
            });

            // Se o botão acelerar for pressionado, aumenta a velocidade do veiculo selecionado no JcomboBox
            bAcelerar.addActionListener(ev -> {
                Veiculo veiculo_selecionado = (Veiculo) comboVeiculos.getSelectedItem();
                veiculo_selecionado.acelerar();
                valor_velocidade.setText(veiculo_selecionado.getVelocidade() + " km/h");
            });

            // Mesma coisa, mas para freiar
            bFreiar.addActionListener(ev -> {
                Veiculo selecionado = (Veiculo) comboVeiculos.getSelectedItem();
                selecionado.freiar();
                valor_velocidade.setText(selecionado.getVelocidade() + " km/h");
            });
            
            //Adiciona itens da janela secundaria
            janela_lista.add(selecionar);
            janela_lista.add(comboVeiculos);
            janela_lista.add(texto_velocidade);
            janela_lista.add(valor_velocidade);
            janela_lista.add(bAcelerar);
            janela_lista.add(bFreiar);
            janela_lista.add(new JLabel(""));
            janela_lista.add(new JLabel(""));

            janela_lista.setVisible(true);
        });

        this.setVisible(true);
    }

    // Chama o construtor do veiculo selecionado no JcomboBox
    private Veiculo criarVeiculo(String tipoSelecionado, String descricao) {
        if ("Carro".equals(tipoSelecionado)) {  //Compara o conteudo de tipoSelecionado com "Carro"
            return new Carro(descricao);
        }
        if ("Moto".equals(tipoSelecionado)) {
            return new Moto(descricao);
        }
        
        return new Caminhao(descricao); //Se não é carro nem moto, então é caminhão, tem q mudar aqui caso adicione um novo veiculo
    }

    public static void main(String[] args) {
        new parte_grafica();            //Chama a interface
    }
}
