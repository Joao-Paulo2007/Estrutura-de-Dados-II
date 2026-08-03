package Aula01;

import java.util.Random;

public class Main {

        public static void bubbleSort (int[] lista){
            int n = lista.length;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n - i - 1; j++){
                    if (lista[j] > lista[j+1]){
                        int temp = lista[j];
                        lista [j] = lista[j+1];
                        lista [j+1] = temp;
                    }
                }
            }
        }

        public static int[] gerarVetor (int tamanho){
            Random random = new Random();
            int [] vetor = new int [tamanho];

            for (int i = 0; i < tamanho; i++){
                vetor[i] = random.nextInt(100000);
            }
            return vetor;
        }

        public static void main (String[]args) {
            int[] tamanhos = {10, 100, 10000, 100000, 1000000};
            for (int tamanho : tamanhos) {
                int[] vetor = gerarVetor(tamanho);
                long startTime = System.nanoTime();

                bubbleSort(vetor);

                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                System.out.println("Tamanho: " + tamanho + " ---> Tempo: " + (duration / 1000000.0) + " ms");
            }
        }
}