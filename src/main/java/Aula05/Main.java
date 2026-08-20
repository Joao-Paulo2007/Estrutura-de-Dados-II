package Aula05;

public class Main {

    private final Arvore arvore = new Arvore();
    private No raiz = null;

    public void main() {
        int[] valores = {10, 20, 25, 30, 40, 50};

        for (int v : valores) {
            raiz = arvore.adicionar(raiz, v);
        }

        System.out.println("--- Árvore AVL Balanceada ---");
        arvore.exibirArvore(raiz);

        System.out.println("\n--- Removendo o valor 30 ---");
        raiz = arvore.remover(raiz, 20);
        arvore.exibirArvore(raiz);
    }
}