/**
 * 
 */
package com.github.otojunior.aedes.algoritmos.ordenacao;

/**
 * Implementação do algoritmo BubbleSort de ordenação.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 11/11/2025
 * @see https://github.com/otojunior
 */
public class BubbleSort implements AlgoritmoOrdenacao {
    /**
     * Ordena um vetor utilizando o algoritmo BubbleSort.
     * @param vetor O vetor a ser ordenado.
     */
    @Override
    public void sort(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < (vetor.length - 1) - i; j++) {
                if (vetor[j] > vetor[j+1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
    }
}

