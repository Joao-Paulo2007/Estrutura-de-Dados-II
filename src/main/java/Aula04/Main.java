package Aula04;

public class Main {

    private final Arvore arvore = new Arvore();
    private final Balanceamento balanceamento = new Balanceamento();
    private No raiz = null;

    public void main() {
        int[] valores = {10, 20, 25, 30, 40, 50};

        for (int v : valores) {
            raiz = arvore.adicionar(raiz, v);
        }

        System.out.println("--- Árvore AVL Balanceada ---");
        arvore.exibirArvore(raiz);
        System.out.println("Fator Balanceamento: " + balanceamento.fatorBalanceamento(raiz));
        System.out.println("Altura: " + raiz.getAltura());

        System.out.println("\n--- Removendo o valor 30 ---");
        raiz = arvore.remover(raiz, 30);
        arvore.exibirArvore(raiz);
    }
}