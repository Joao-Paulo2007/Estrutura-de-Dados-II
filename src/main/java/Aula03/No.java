package Aula03;

public class No {
    private int valor;
    private No direita, esquerda;

    public No(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}
