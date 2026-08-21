package Aula02.atividade;

public class Exercicio01 {

    // Adiciona elementos de forma iterativa (com laço while)
    public No adicionar(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }

        No atual = raiz;
        No pai = null;

        while (atual != null) {
            pai = atual;

            if (valor < atual.getValor()) {
                atual = atual.getEsquerda();
            } else if (valor > atual.getValor()) {
                atual = atual.getDireita();
            } else {
                return raiz; // Evita valores duplicados
            }
        }

        if (valor < pai.getValor()) {
            pai.setEsquerda(new No(valor));
        } else {
            pai.setDireita(new No(valor));
        }

        return raiz;
    }

    // Exibe a árvore de forma gráfica
    public void exibirArvore(No no) {
        if (no == null) return;
        // A raiz não tem lado (E/D), então só imprime o valor
        System.out.println(no.getValor() + " (RAIZ)");

        // Inicia a recursão para os filhos
        if (no.getEsquerda() != null || no.getDireita() != null) {
            exibirArvoreRec(no.getEsquerda(), "", true, true);
            exibirArvoreRec(no.getDireita(), "", false, false);
        }
    }

    // Método auxiliar mantendo o estilo de galhos + indicação do lado no final
    private void exibirArvoreRec(No no, String prefixo, boolean ehEsquerda, boolean ehFilhoEsquerda) {
        if (no == null) return;

        // Imprime o valor mantendo a estrutura gráfica e adiciona (E) ou (D) depois do valor
        String indicadorLado = ehFilhoEsquerda ? " [E]" : " [D]";
        System.out.println(prefixo + (ehEsquerda ? "├── " : "└── ") + no.getValor() + indicadorLado);

        if (no.getEsquerda() != null || no.getDireita() != null) {
            exibirArvoreRec(no.getEsquerda(), prefixo + (ehEsquerda ? "│   " : "    "), true, true);
            exibirArvoreRec(no.getDireita(), prefixo + (ehEsquerda ? "│   " : "    "), false, false);
        }
    }
}