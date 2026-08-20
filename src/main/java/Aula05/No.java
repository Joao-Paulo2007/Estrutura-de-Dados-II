package Aula05;

public class No {

    private int valor;
    private No direita;
    private No esquerda;
    private int altura;

    public No(int valor) {
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
        this.altura = 1;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}