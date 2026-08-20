package Aula05;

public class Arvore {

    // Método para adicionar itens na árvore
    public No adicionar(No no, int valor) {

        // Se a árvore estiver vazia, o novo nó torna-se a raiz
        if (no == null) return new No(valor);

        // Adicionar à esquerda
        if (valor < no.getValor()) no.setEsquerda(adicionar(no.getEsquerda(), valor));

            // Adicionar à direita
        else if (valor > no.getValor()) no.setDireita(adicionar(no.getDireita(), valor));

            // Valor repetido
        else return no;

        // Atualiza a altura do nó
        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        // Verifica e corrige o balanceamento
        return balancearArvore(no);
    }

    // Balancear árvore AVL
    public No balancearArvore(No no) {
        int fator = fatorBalanceamento(no);

        // Caso esquerda-esquerda
        if (fator > 1 && fatorBalanceamento(no.getEsquerda()) >= 0) return rotacaoDireita(no);

        // Caso esquerda-direita
        if (fator > 1 && fatorBalanceamento(no.getEsquerda()) < 0) {
            no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            return rotacaoDireita(no);
        }

        // Caso direita-direita
        if (fator < -1 && fatorBalanceamento(no.getDireita()) <= 0) return rotacaoEsquerda(no);

        // Caso direita-esquerda
        if (fator < -1 && fatorBalanceamento(no.getDireita()) > 0) {
            no.setDireita(rotacaoDireita(no.getDireita()));
            return rotacaoEsquerda(no);
        }

        // Já está balanceada
        return no;
    }

    // Rotação simples para a direita
    private No rotacaoDireita(No no) {

        No novaRaiz = no.getEsquerda();
        No subArvore = novaRaiz.getDireita();

        novaRaiz.setDireita(no);
        no.setEsquerda(subArvore);

        // Atualiza as alturas
        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        novaRaiz.setAltura(1 + Math.max(altura(novaRaiz.getEsquerda()), altura(novaRaiz.getDireita())));

        return novaRaiz;
    }

    // Rotação simples para a esquerda
    private No rotacaoEsquerda(No no) {

        No novaRaiz = no.getDireita();
        No subArvore = novaRaiz.getEsquerda();

        novaRaiz.setEsquerda(no);
        no.setDireita(subArvore);

        // Atualiza as alturas
        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        novaRaiz.setAltura(1 + Math.max(altura(novaRaiz.getEsquerda()), altura(novaRaiz.getDireita())));

        return novaRaiz;
    }

    // Calcular a altura da árvore
    public int altura(No no) {

        if (no == null) return 0;

        return no.getAltura();
    }

    // Achar o fator de balanceamento (Para estar balanceada: -1, 0 ou 1)
    public int fatorBalanceamento(No no) {

        if (no == null) return 0;

        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    // Auxiliar recursivo para formatar os galhos
    public void exibirArvore(No raiz) {
        int h = altura(raiz);
        if (h == 0) return;

        java.util.List<No> nivelAtual = new java.util.ArrayList<>();
        nivelAtual.add(raiz);

        int larguraMax = (int) Math.pow(2, h) * 3;

        for (int nivel = 1; nivel <= h; nivel++) {
            java.util.List<No> proximoNivel = new java.util.ArrayList<>();
            int espacosAntes = (int) Math.pow(2, h - nivel + 1) - 1;
            int espacosEntre = (int) Math.pow(2, h - nivel + 2) - 1;

            // Imprime os valores dos nós
            imprimirEspacos(espacosAntes);
            for (No no : nivelAtual) {
                if (no != null) {
                    System.out.printf("%2d", no.getValor());
                    proximoNivel.add(no.getEsquerda());
                    proximoNivel.add(no.getDireita());
                } else {
                    System.out.print("  ");
                    proximoNivel.add(null);
                    proximoNivel.add(null);
                }
                imprimirEspacos(espacosEntre - 1);
            }
            System.out.println();

            // Imprime as ramificações (/ \)
            if (nivel < h) {
                imprimirEspacos(espacosAntes - 1);
                for (No no : nivelAtual) {
                    if (no != null && no.getEsquerda() != null) System.out.print("/");
                    else System.out.print(" ");

                    imprimirEspacos(1);

                    if (no != null && no.getDireita() != null) System.out.print("\\");
                    else System.out.print(" ");

                    imprimirEspacos(espacosEntre - 2);
                }
                System.out.println();
            }
            nivelAtual = proximoNivel;
        }
    }

    private void imprimirEspacos(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(" ");
        }
    }

    // Remover um valor da árvore
    public No remover(No no, int valor) {
        if (no == null) return null;

        if (valor < no.getValor()) no.setEsquerda(remover(no.getEsquerda(), valor));

        else if (valor > no.getValor()) no.setDireita(remover(no.getDireita(), valor));

        else {

            if (no.getEsquerda() == null) return no.getDireita();

            if (no.getDireita() == null) return no.getEsquerda();

            No sucessor = menorValor(no.getDireita());

            no.setValor(sucessor.getValor());

            no.setDireita(remover(no.getDireita(), sucessor.getValor()));

        }

        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        return balancearArvore(no);
    }

    public No menorValor(No no) {
        while (no.getEsquerda() != null) no = no.getEsquerda();

        return no;

    }
}