package Aula02;

public class Metodos {

    // Adicionar valores na árvore
    public No adicionar(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.getValor()) {
            no.setEsquerda(adicionar(no.getEsquerda(), valor));
        } else if (valor > no.getValor()) {
            no.setDireita(adicionar(no.getDireita(), valor));
        }

        return no;
    }

    // Tentando fazer de uma forma interativa, utilizando while
    public No adicionarIterativo(No raiz, int valor) {
        // Se a árvore estiver vazia, o novo nó torna-se a própria raiz
        if (raiz == null) {
            return new No(valor);
        }

        No atual = raiz;
        No pai = null;

        // 1. Navega pela árvore até encontrar uma posição vaga (null)
        while (atual != null) {
            pai = atual; // Guarda o pai antes de andar para o filho

            if (valor < atual.getValor()) {
                atual = atual.getEsquerda();
            } else if (valor > atual.getValor()) {
                atual = atual.getDireita();
            } else {
                // Valor já existe na árvore (evita duplicatas)
                return raiz;
            }
        }

        // 2. Conecta o novo nó no lado correto do pai encontrado
        if (valor < pai.getValor()) {
            pai.setEsquerda(new No(valor));
        } else {
            pai.setDireita(new No(valor));
        }

        return raiz;
    }

    // Metodo principal para exibir a árvore de forma visual
    public void exibirArvore(No no) {
        exibirArvoreRec(no, "", true);
    }

    // Auxiliar recursivo para formatar os galhos
    private void exibirArvoreRec(No no, String prefixo, boolean ehEsquerda) {
        if (no == null) return;

        System.out.println(prefixo + (ehEsquerda ? "├── " : "└── ") + no.getValor());

        // Se houver pelo menos um filho, imprime os sub-ramos
        if (no.getEsquerda() != null || no.getDireita() != null) {
            exibirArvoreRec(no.getEsquerda(), prefixo + (ehEsquerda ? "│   " : "    "), true);
            exibirArvoreRec(no.getDireita(), prefixo + (ehEsquerda ? "│   " : "    "), false);
        }
    }

    // Pré-Ordem
    public void preOrdem(No no) {
        if (no == null) return;

        System.out.print(no.getValor() + " ");
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    // Em-Ordem
    public void emOrdem(No no) {
        if (no == null) return;

        emOrdem(no.getEsquerda());
        System.out.print(no.getValor() + " ");
        emOrdem(no.getDireita());
    }

    // Pós-Ordem
    public void posOrdem(No no) {
        if (no == null) return;

        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.print(no.getValor() + " ");
    }
}