# Aula 01

Estrutura em relação a atividade proposta, data 30/07/2026

---

Proposta:
Implementação do Bubble Sort. Medir o tempo para vetores de tamanho 10, 100, 10.000, 100.000, 1.000.000

Para medir o tempo:

long startTime = System.nanoTime();


// --- Código a ser medido ---
// --------------------------

long endTime = System.nanoTime();
l
ong duration = (endTime - startTime); // Tempo em nanossegundos

System.out.println("Tempo: " + (duration / 1000000.0) + " ms");