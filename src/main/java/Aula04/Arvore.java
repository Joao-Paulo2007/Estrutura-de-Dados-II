package Aula04;

public class Arvore {

        /**
         * Função de Rotação Simples à Direita.
         * Recebe o nó desbalanceado 'y' e promove o filho esquerdo 'x' a nova raiz.
         */
        public static No rotacionarDireita(No y) {
            No x = y.esquerda;
            No t2 = x.direita;

            // Executa a reestruturação de ponteiros
            x.direita = y;
            y.esquerda = t2;

            // Retorna o nó 'x' como a nova raiz da subárvore
            return x;
        }

        //Método auxiliar para imprimir o percurso em-ordem (E-V-D)
        public static void emOrdem(No raiz) {
            if (raiz != null) {
                emOrdem(raiz.esquerda);
                System.out.print(raiz.valor + " ");
                emOrdem(raiz.direita);
            }
        }

        // Método auxiliar para desenhar a árvore visualmente no console
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
            No x = new No(20);
            No t2 = new No(25);

            y.esquerda = x;
            y.direita = new No(35);

            x.esquerda = new No(10);
            x.direita = t2; // Este nó 't2' mudará de pai durante a rotação

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
        }
}