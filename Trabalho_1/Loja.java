package Prog_3.Trabalho_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Veiculo> lista_veiculo = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("   SISTEMA DE VEÍCULOS");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("1 - Adicionar Carro");
            System.out.println("2 - Adicionar Moto");
            System.out.println("3 - Adicionar Caminhão");
            System.out.println("4 - Listar Veículos");
            System.out.println("5 - Acelerar Veículo");
            System.out.println("6 - Freiar Veículo");
            System.out.println("0 - Sair");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.print("Escolha uma opção: ");

            opcao = s.nextInt();
            s.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição do carro: ");
                    String descCarro = s.nextLine();
                    lista_veiculo.add(new Carro(descCarro));
                    System.out.println("Carro adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite a descrição da moto: ");
                    String descMoto = s.nextLine();
                    lista_veiculo.add(new Moto(descMoto));
                    System.out.println("Moto adicionada com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite a descrição do caminhão: ");
                    String descCaminhao = s.nextLine();
                    lista_veiculo.add(new Caminhao(descCaminhao));
                    System.out.println("Caminhão adicionado com sucesso!");
                    break;

                case 4:
                    if (lista_veiculo.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        System.out.println("\n═══ LISTA DE VEÍCULOS ═══");
                        for (int i = 0; i < lista_veiculo.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            lista_veiculo.get(i).descricao();
                        }
                    }
                    break;

                case 5:
                    if (lista_veiculo.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        System.out.print("Digite o número do veículo (1-" + lista_veiculo.size() + "): ");
                        int indiceAcelerar = s.nextInt() - 1;
                        if (indiceAcelerar >= 0 && indiceAcelerar < lista_veiculo.size()) {
                            lista_veiculo.get(indiceAcelerar).acelerar();
                        } else {
                            System.out.println("Veículo inválido!");
                        }
                    }
                    break;

                case 6:
                    if (lista_veiculo.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        System.out.print("Digite o número do veículo (1-" + lista_veiculo.size() + "): ");
                        int indiceFreiar = s.nextInt() - 1;
                        if (indiceFreiar >= 0 && indiceFreiar < lista_veiculo.size()) {
                            lista_veiculo.get(indiceFreiar).freiar();
                        } else {
                            System.out.println("⚠ Veículo inválido!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nEncerrando sistema");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        s.close();
    }
}