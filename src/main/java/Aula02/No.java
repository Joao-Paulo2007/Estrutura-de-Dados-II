package Aula02;

public class No {
    int valor;
    No direita, esquerda;

    public No(int valor){
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
