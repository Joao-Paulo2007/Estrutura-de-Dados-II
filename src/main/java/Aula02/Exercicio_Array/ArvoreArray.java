package Aula02.Exercicio_Array;

public class ArvoreArray {

    private int[] arvore;

    public ArvoreArray(int[] arvore) {
        this.arvore = arvore;
    }

    // Métodos auxiliares de navegação
    public int filhoEsquerdo(int i) { return 2 * i + 1; }
    public int filhoDireito(int i)  { return 2 * i + 2; }
    public int pai(int i)           { return (i - 1) / 2; }

    // Exibição visual da árvore
    public void exibirArvore(int i, String prefixo, boolean ehEsquerda) {
        if (i >= arvore.length || arvore[i] == -1) return;

        System.out.println(prefixo + (ehEsquerda ? "├── " : "└── ") + arvore[i]);

        int esq = filhoEsquerdo(i);
        int dir = filhoDireito(i);

        boolean temEsq = esq < arvore.length && arvore[esq] != -1;
        boolean temDir = dir < arvore.length && arvore[dir] != -1;

        if (temEsq || temDir) {
            exibirArvore(esq, prefixo + (ehEsquerda ? "│   " : "    "), true);
            exibirArvore(dir, prefixo + (ehEsquerda ? "│   " : "    "), false);
        }
    }

    // Percurso Pré-Ordem (Raiz -> Esquerda -> Direita)
    public void preOrdem(int i) {
        if (i >= arvore.length || arvore[i] == -1) return;

        System.out.print(arvore[i] + " ");
        preOrdem(filhoEsquerdo(i));
        preOrdem(filhoDireito(i));
    }

    // Percurso Em-Ordem (Esquerda -> Raiz -> Direita)
    public void emOrdem(int i) {
        if (i >= arvore.length || arvore[i] == -1) return;

        emOrdem(filhoEsquerdo(i));
        System.out.print(arvore[i] + " ");
        emOrdem(filhoDireito(i));
    }

    // Percurso Pós-Ordem (Esquerda -> Direita -> Raiz)
    public void posOrdem(int i) {
        if (i >= arvore.length || arvore[i] == -1) return;

        posOrdem(filhoEsquerdo(i));
        posOrdem(filhoDireito(i));
        System.out.print(arvore[i] + " ");
    }
}
