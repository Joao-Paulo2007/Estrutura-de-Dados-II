package Aula04;

public class Balanceamento {

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

        return no;
    }

    private No rotacaoDireita(No no) {
        No novaRaiz = no.getEsquerda();
        No subArvore = novaRaiz.getDireita();

        novaRaiz.setDireita(no);
        no.setEsquerda(subArvore);

        // CORREÇÃO AQUI: calcularAltura(novaRaiz) no lugar de calcularAltura(no)
        no.setAltura(calcularAltura(no));
        novaRaiz.setAltura(calcularAltura(novaRaiz));

        return novaRaiz;
    }

    private No rotacaoEsquerda(No no) {
        No novaRaiz = no.getDireita();
        No temp = novaRaiz.getEsquerda();

        novaRaiz.setEsquerda(no);
        no.setDireita(temp);

        // CORREÇÃO AQUI: calcularAltura(novaRaiz) no lugar de calcularAltura(no)
        no.setAltura(calcularAltura(no));
        novaRaiz.setAltura(calcularAltura(novaRaiz));

        return novaRaiz;
    }

    public int altura(No no) {
        if (no == null) return -1;
        return no.getAltura();
    }

    public int calcularAltura(No no) {
        return 1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
    }

    public int fatorBalanceamento(No no) {
        if (no == null) return 0;
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }
}