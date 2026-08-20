package Aula05;

public class Balanceamento {
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
        No temp = novaRaiz.getEsquerda();

        novaRaiz.setEsquerda(no);
        no.setDireita(temp);

        // Atualiza as alturas
        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        novaRaiz.setAltura(1 + Math.max(altura(novaRaiz.getEsquerda()), altura(novaRaiz.getDireita())));

        return novaRaiz;
    }

    // Verificar se o No é nulo
    public int altura(No no) {

        if (no == null) return 0;
        return no.getAltura();
    }

    public int calcularAltura(No no) {
        return 1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
    }

    // Achar o fator de balanceamento (Para estar balanceada: -1, 0 ou 1)
    public int fatorBalanceamento(No no) {

        if (no == null) return 0;

        return altura(no.getEsquerda()) - altura(no.getDireita());
    }
}
