package Aula04;

public class Arvore {
    Balanceamento balanceamento = new Balanceamento();

    // Metodo para adicionar itens na árvore
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


    // Metodo principal para exibir a árvore
    public void exibirArvore(No no) {
        exibirArvoreRec(no, "", "Raiz");
    }

    // Metodo auxiliar recursivo simples
    private void exibirArvoreRec(No no, String espaco, String direcao) {
        if (no == null) return;

        // Imprime o nó atual mostrando se é Raiz, Esquerda (E) ou Direita (D)
        System.out.println(espaco + "[" + direcao + "] " + no.getValor());

        // Percorre a esquerda e a direita aumentando o espaçamento
        exibirArvoreRec(no.getEsquerda(), espaco + "   ", "E");
        exibirArvoreRec(no.getDireita(), espaco + "   ", "D");
    }

    // Remove um elemento mantendo a ordenação e o balanceamento
    public No remover(No no, int valor) {
        // Caso base: valor não encontrado
        if (no == null) return null;

        // Busca o nó a ser removido recursivamente
        if (valor < no.getValor()) no.setEsquerda(remover(no.getEsquerda(), valor));
        else if (valor > no.getValor()) no.setDireita(remover(no.getDireita(), valor));

            // Nó encontrado. Trata a exclusão pelos 3 casos
        else {
            // Caso 1 e 2: Sem filho à esquerda (retorna o direito ou null)
            if (no.getEsquerda() == null) return no.getDireita();

            // Caso 1 e 2: Sem filho à direita (retorna o esquerdo)
            if (no.getDireita() == null) return no.getEsquerda();

            // Caso 3: Nó possui 2 filhos
            No sucessor = menorValor(no.getDireita());                     // Busca o menor nó da subárvore direita
            no.setValor(sucessor.getValor());                               // Substitui o valor do nó pelo valor do sucessor
            no.setDireita(remover(no.getDireita(), sucessor.getValor()));   // Deleta o nó sucessor duplicado
        }

        // Atualiza a altura após a remoção
        no.setAltura(balanceamento.calcularAltura(no));

        // Aplica as rotações para rebalancear caso necessário
        return balanceamento.balancearArvore(no);
    }

    // Encontra o menor valor a partir de um nó (caminha totalmente para a esquerda)
    public No menorValor(No no) {
        while (no.getEsquerda() != null) no = no.getEsquerda();

        return no;
    }
}