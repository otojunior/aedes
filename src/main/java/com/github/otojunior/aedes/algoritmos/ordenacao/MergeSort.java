/**
 * 
 */
package com.github.otojunior.aedes.algoritmos.ordenacao;

/**
 * Implementação do algoritmo MergeSort de ordenação.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 11/11/2025
 * @see https://github.com/otojunior
 */
public class MergeSort implements AlgoritmoOrdenacao {
    /**
     * Ordena um vetor utilizando o algoritmo MergeSort.
     * @param vetor O vetor a ser ordenado.
     */
    @Override
    public void sort(int[] vetor) {
        if (vetor.length > 1) {
            // Divisão: divide o vetor em duas metades
            int meio = vetor.length / 2;
            int[] esquerda = new int[meio];
            int[] direita = new int[vetor.length - meio];
            for (int i = 0; i < meio; i++) esquerda[i] = vetor[i];
            for (int i = meio; i < vetor.length; i++) direita[i - meio] = vetor[i];

            // Recursão: ordena as duas metades
            sort(esquerda);
            sort(direita);

            // Conquista: mescla as duas metades ordenadas
            int i = 0, j = 0, k = 0;
            while (i < esquerda.length && j < direita.length) {
                vetor[k++] = (esquerda[i] <= direita[j])
                    ? esquerda[i++]
                    : direita[j++];
            }

            // Copia os elementos restantes
            while (i < esquerda.length) vetor[k++] = esquerda[i++];
            while (j < direita.length) vetor[k++] = direita[j++];
        }
    }
}
