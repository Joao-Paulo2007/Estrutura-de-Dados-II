package Aula02.Exercicio_Array;

public class Main {

    public static void main(String[] args) {

        // Representação por Array (-1 indica nó vazio/ausente)
        int[] dados = {10, 5, 15, 3, 7, -1, 20};

        ArvoreArray arvore = new ArvoreArray(dados);

        System.out.println("--- Estrutura da Árvore ---");
        arvore.exibirArvore(0, "", true);
        System.out.println();

        System.out.print("Pré-Ordem: ");
        arvore.preOrdem(0);
        System.out.println();

        System.out.print("Em-Ordem: ");
        arvore.emOrdem(0);
        System.out.println();

        System.out.print("Pós-Ordem: ");
        arvore.posOrdem(0);
        System.out.println();
    }
}