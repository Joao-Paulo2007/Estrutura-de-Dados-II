package Aula04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arvore arvore = new Arvore();
        Balanceamento balanceamento = new Balanceamento();
        No raiz = null;

        System.out.println("==========================================");
        System.out.println("      SISTEMA DE ÁRVORE AVL INTERATIVA    ");
        System.out.println("==========================================");

        // Pedindo o valor inicial para formar a Raiz
        System.out.print("Digite o valor inicial para a RAIZ da árvore: ");
        int valorInicial = scanner.nextInt();
        raiz = arvore.adicionar(raiz, valorInicial);

        int opcao = 0;

        while (opcao != 3) {
            // Exibe o estado atual da árvore
            System.out.println("\n------------------------------------------");
            System.out.println("ESTADO ATUAL DA ÁRVORE:");
            arvore.exibirArvore(raiz);
            System.out.println("------------------------------------------");
            System.out.println("Raiz Atual: " + (raiz != null ? raiz.getValor() : "Vazia"));
            System.out.println("Fator de Balanceamento da Raiz: " + balanceamento.fatorBalanceamento(raiz));
            System.out.println("Altura da Raiz: " + balanceamento.altura(raiz));
            System.out.println("------------------------------------------");

            // Menu de Opções
            System.out.println("\nMENU DE OPÇÕES:");
            System.out.println("1. Adicionar um número");
            System.out.println("2. Remover um número");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o valor que deseja ADICIONAR: ");
                    int valorAdd = scanner.nextInt();
                    raiz = arvore.adicionar(raiz, valorAdd);
                    System.out.println("-> Valor " + valorAdd + " inserido e árvore rebalanceada!");
                    break;

                case 2:
                    System.out.print("\nDigite o valor que deseja REMOVER: ");
                    int valorRem = scanner.nextInt();
                    raiz = arvore.remover(raiz, valorRem);
                    System.out.println("-> Valor " + valorRem + " removido e árvore rebalanceada!");
                    break;

                case 3:
                    System.out.println("\nEncerrando o programa... Até mais!");
                    break;

                default:
                    System.out.println("\n[Opção Inválida!] Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}