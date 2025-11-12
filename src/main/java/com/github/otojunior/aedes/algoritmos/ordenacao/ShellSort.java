/**
 * 
 */
package com.github.otojunior.aedes.algoritmos.ordenacao;

/**
 * Implementação do algoritmo ShellSort de ordenação.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 11/11/2025
 * @see https://github.com/otojunior
 */
public class ShellSort implements AlgoritmoOrdenacao {
    /**
     * Ordena um vetor utilizando o algoritmo ShellSort.
     * @param vetor O vetor a ser ordenado.
     */
    @Override
    public void sort(int[] vetor) {
        // 1️⃣ Começa com um gap grande e vai diminuindo pela metade
        for (int gap = vetor.length / 2; gap > 0; gap /= 2) {
            // 2️⃣ Faz um Insertion Sort modificado para este gap
            for (int i = gap; i < vetor.length; i++) {
                int atual = vetor[i]; // elemento a ser inserido no subgrupo
                int j = i;

                // Move elementos do subgrupo que são maiores que "atual"
                // para a frente, de gap em gap
                while (j >= gap && vetor[j - gap] > atual) {
                    vetor[j] = vetor[j - gap];
                    j -= gap;
                }

                // Insere o elemento na posição correta dentro do subgrupo
                vetor[j] = atual;
            }
        }
    }
}
