package Aula02;

public class Main {

    public static void main(String[] args) {

        Metodos arvore = new Metodos();

        No raiz = null;

        // É preciso atribuir o retorno de 'adicionar' para atualizar a raiz e as conexões
        raiz = arvore.adicionar(raiz, 6);
        raiz = arvore.adicionar(raiz, 14);
        raiz = arvore.adicionar(raiz, 4);
        raiz = arvore.adicionar(raiz, 7);
        raiz = arvore.adicionar(raiz, 13);
        raiz = arvore.adicionar(raiz, 8);
        raiz = arvore.adicionar(raiz, 3);
        raiz = arvore.adicionar(raiz, 10);
        raiz = arvore.adicionar(raiz, 1);

        System.out.println("--- Estrutura da Árvore ---");
        arvore.exibirArvore(raiz);
        System.out.println();

        System.out.print("Pré-Ordem: ");
        arvore.preOrdem(raiz);
        System.out.println();

        System.out.print("Em-Ordem: ");
        arvore.emOrdem(raiz);
        System.out.println();

        System.out.print("Pós-Ordem: ");
        arvore.posOrdem(raiz);
        System.out.println();
    }
}