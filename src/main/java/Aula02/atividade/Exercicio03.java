package Aula02.atividade;

public class Exercicio03 {

    // Método principal que o usuário chama passando apenas a raiz
    public boolean ehBstValida(No raiz) {
        // Inicializa o intervalo de valores com limites infinito negativo e infinito positivo
        return validar(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Método auxiliar recursivo que controla o intervalo [min, max]
    private boolean validar(No no, int min, int max) {
        // Uma árvore vazia (ou folha/fim do ramo) é considerada uma BST válida
        if (no == null) {
            return true;
        }

        if (no.getValor() <= min || no.getValor() >= max) {
            return false;
        }

        // Recursão para a esquerda: o valor máximo permitido passa a ser (valorAtual - 1)
        // Recursão para a direita: o valor mínimo permitido passa a ser (valorAtual + 1)
        return validar(no.getEsquerda(), min, no.getValor())
                && validar(no.getDireita(), no.getValor(), max);
    }

    public void exibirArvore(No no){
        Exercicio01 ex1 = new Exercicio01();
        ex1.exibirArvore(no);
    }
}