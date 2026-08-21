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

    public void exibirArvore(No raiz) {
        int h = balanceamento.altura(raiz) + 1;
        if (h <= 0) return;

        java.util.List<No> nivelAtual = new java.util.ArrayList<>();
        nivelAtual.add(raiz);

        for (int nivel = 1; nivel <= h; nivel++) {
            java.util.List<No> proximoNivel = new java.util.ArrayList<>();
            int espacosAntes = (int) Math.pow(2, h - nivel + 1) - 2;
            int espacosEntre = (int) Math.pow(2, h - nivel + 2) - 1;

            // Imprime os nós
            imprimirEspacos(Math.max(0, espacosAntes));
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
                imprimirEspacos(Math.max(0, espacosEntre - 1));
            }
            System.out.println();

            // Imprime as conexões (/ \)
            if (nivel < h) {
                imprimirEspacos(Math.max(0, espacosAntes));
                for (No no : nivelAtual) {
                    if (no != null && no.getEsquerda() != null) {
                        System.out.print("/");
                    } else {
                        System.out.print(" ");
                    }

                    imprimirEspacos(1);

                    if (no != null && no.getDireita() != null) {
                        System.out.print("\\");
                    } else {
                        System.out.print(" ");
                    }

                    imprimirEspacos(Math.max(0, espacosEntre - 3));
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