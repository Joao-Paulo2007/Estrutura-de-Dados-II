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