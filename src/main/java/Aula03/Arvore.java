package Aula03;

public class Arvore {

        public static No rotacionarDireita(No y) {
            No x = y.esquerda;
            No t2 = x.direita;

            x.direita = y;
            y.esquerda = t2;

            return x;
        }

    public static No rotacionarEsquerda(No y) {


        No x = y.direita;

        No t2 = x.esquerda;

        x.esquerda = y;

        y.direita = t2;

        return x;
    }

        public static void emOrdem(No raiz) {
            if (raiz != null) {
                emOrdem(raiz.esquerda);
                System.out.print(raiz.valor + " ");
                emOrdem(raiz.direita);
            }
        }

        public static void exibirArvore(No raiz, String prefixo, boolean ehEsquerda) {
            if (raiz != null) {
                System.out.println(prefixo + (ehEsquerda ? "├── (E) " : "└── (D) ") + raiz.valor);
                exibirArvore(raiz.esquerda, prefixo + (ehEsquerda ? "│   " : "    "), true);
                exibirArvore(raiz.direita, prefixo + (ehEsquerda ? "│   " : "    "), false);
            }
        }

        public static void main(String[] args) {
            /*
             * Montando manualmente a seguinte árvore desbalanceada à esquerda:
             *
             *          30 (y)
             *         /  \
             *       20(x) 35
             *      /  \
             *    10    25 (t2)
             */

            No y = new No(30);
            No x = new No(25);
            No t2 = new No(26);

            y.esquerda = x;
            y.direita = new No(80);

            x.esquerda = new No(20);
            x.direita = t2;// Este nó 't2' mudará de pai durante a rotação

            x.esquerda.esquerda = new No(10);
            x.esquerda.direita = new No(23);

            y.direita.esquerda = new No(50);
            y.direita.direita = new No(90);

            System.out.println("==============================================");
            System.out.println(" 1. ÁRVORE ORIGINAL (Antes da Rotação)");
            System.out.println("==============================================");
            exibirArvore(y, "", false);
            System.out.print("\nCaminhamento Em-Ordem: ");
            emOrdem(y);
            System.out.println("\n");

            // Executa a Rotação à Direita passando a raiz 'y'
            No novaRaiz = rotacionarDireita(y);

            /*
             * Estrutura esperada após a rotação:
             *
             *          20 (x)
             *         /  \
             *       10    30 (y)
             *            /  \
             *          25    35
             *         (t2)
             */

            System.out.println("==============================================");
            System.out.println(" 2. ÁRVORE APÓS ROTAÇÃO À DIREITA");
            System.out.println("==============================================");
            exibirArvore(novaRaiz, "", false);
            System.out.print("\nCaminhamento Em-Ordem: ");
            emOrdem(novaRaiz);
            System.out.println("\n==============================================");

            //Resetando para árvore original, para aplicar a rotação a esquerda.


            No NRaiz = rotacionarEsquerda(novaRaiz);

            System.out.println("==============================================");
            System.out.println(" 3. ÁRVORE APÓS ROTAÇÃO À ESQUERDA");
            System.out.println("==============================================");
            exibirArvore(NRaiz, "",false);
            System.out.println("\nCaminho Em-Ordem: ");
            emOrdem(NRaiz);
            System.out.println("\n==============================================");
        }
}