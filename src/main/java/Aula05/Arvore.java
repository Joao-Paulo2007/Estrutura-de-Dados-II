package Aula05;

public class Arvore {
    Balanceamento balanceamento = new Balanceamento();

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
        no.setAltura(balanceamento.calcularAltura(no));

        // Verifica e corrige o balanceamento
        return balanceamento.balancearArvore(no);
    }


    // Método principal para exibir a árvore
    public void exibirArvore(No no) {
        exibirArvoreRec(no, "", "Raiz");
    }

    // Método auxiliar recursivo simples
    private void exibirArvoreRec(No no, String espaco, String direcao) {
        if (no == null) return;

        // Imprime o nó atual mostrando se é Raiz, Esquerda (E) ou Direita (D)
        System.out.println(espaco + "[" + direcao + "] " + no.getValor());

        // Percorre a esquerda e a direita aumentando o espaçamento
        exibirArvoreRec(no.getEsquerda(), espaco + "   ", "E");
        exibirArvoreRec(no.getDireita(), espaco + "   ", "D");
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

        no.setAltura(balanceamento.calcularAltura(no));

        return balanceamento.balancearArvore(no);
    }

    public No menorValor(No no) {
        while (no.getEsquerda() != null) no = no.getEsquerda();

        return no;

    }
}