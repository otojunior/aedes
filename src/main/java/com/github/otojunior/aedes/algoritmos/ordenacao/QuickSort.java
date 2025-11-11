/**
 * 
 */
package com.github.otojunior.aedes.algoritmos.ordenacao;

/**
 * Implementação do algoritmo QuickSort de ordenação.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 11/11/2025
 * @see https://github.com/otojunior
 */
public class QuickSort implements AlgoritmoOrdenacao {
    /**
     * Ordena um vetor utilizando o algoritmo QuickSort.
     * @param vetor O vetor a ser ordenado.
     */
    @Override
    public void sort(int[] vetor) {
        sort(vetor, 0, vetor.length - 1);
    }

    /**
     * Implementação do algoritmo QuickSort.
     * @param vetor O vetor a ser ordenado.
     * @param ini Índice inicial do vetor.
     * @param fim Índice final do vetor.
     */
    private void sort(int[] vetor, int ini, int fim) {
        int i = ini;
        int j = fim;
        int pivo = vetor[ini + (fim - ini) / 2];
        while (i <= j) {
            while (vetor[i] < pivo) i++;
            while (vetor[j] > pivo) j--;
            if (i<= j) {
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
        }
        if (ini < j) sort(vetor, ini, j);
        if (i < fim) sort(vetor, i, fim);
    }
}

