package Aula02.atividade;

public class Main {
    public static void main(String[] args) {

        // EXERCICIO 01 DO SLIDE DA AULA 03
        Exercicio01 exercicio01 = new Exercicio01();

        No raizA = null;

        // Opcao A
        raizA = exercicio01.adicionar(raizA, 50);
        raizA = exercicio01.adicionar(raizA, 30);
        raizA = exercicio01.adicionar(raizA, 70);
        raizA = exercicio01.adicionar(raizA, 65);

        System.out.println("Árvore A: ");
        exercicio01.exibirArvore(raizA);

        No raizB = null;

        // Opcao B
        raizB = exercicio01.adicionar(raizB, 20);
        raizB = exercicio01.adicionar(raizB, 10);
        raizB = exercicio01.adicionar(raizB, 35);
        raizB = exercicio01.adicionar(raizB, 25);
        raizB = exercicio01.adicionar(raizB, 40);

        System.out.println("\nÁrvore B: ");
        exercicio01.exibirArvore(raizB);

        No raizC = null;

        // Opcao C
        raizC = exercicio01.adicionar(raizC, 8);
        raizC = exercicio01.adicionar(raizC, 12);
        raizC = exercicio01.adicionar(raizC, 4);

        System.out.println("\nÁrvore C: ");
        exercicio01.exibirArvore(raizC);

        // EXERCICIO 02 DO SLIDE DA AULA 03
        Exercicio02 exercicio02 = new Exercicio02();
        No raizEx2 = null;

        raizEx2 = exercicio02.adicionar(raizEx2, 45);
        raizEx2 = exercicio02.adicionar(raizEx2, 20);
        raizEx2 = exercicio02.adicionar(raizEx2, 70);
        raizEx2 = exercicio02.adicionar(raizEx2, 10);
        raizEx2 = exercicio02.adicionar(raizEx2, 30);
        raizEx2 = exercicio02.adicionar(raizEx2, 60);
        raizEx2 = exercicio02.adicionar(raizEx2, 80);
        raizEx2 = exercicio02.adicionar(raizEx2, 25);
        raizEx2 = exercicio02.adicionar(raizEx2, 35);

        System.out.println("\nÁrvore Resultante do Ex 02:");
        exercicio02.exibirArvore(raizEx2);

        // Exercício 03
        Exercicio03 exercicio03 = new Exercicio03();

        // Teste 1: Testando a árvore válida gerada no Ex 02
        boolean ehValidaEx2 = exercicio03.ehBstValida(raizEx2);
        System.out.println("A Árvore do Exercicio 02 eh uma BST valida? " + ehValidaEx2);
        System.out.println();

        // Teste 2: Criando manualmente uma árvore INVÁLIDA para testar o método
        // Estrutura inválida: 10 tem filho direito 15, e 15 tem filho esquerdo 6 (que é menor que a raiz 10)
        No raizInvalida = new No(10);
        raizInvalida.setEsquerda(new No(5));
        raizInvalida.setDireita(new No(15));
        raizInvalida.getDireita().setEsquerda(new No(6)); // <--- Erro aqui (6 < 10 na subárvore direita)

        exercicio03.exibirArvore(raizInvalida);

        boolean ehValidaInvalida = exercicio03.ehBstValida(raizInvalida);
        System.out.println("A Árvore Invalida montada eh BST valida? " + ehValidaInvalida);
    }
}