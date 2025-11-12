/**
 * 
 */
package com.github.otojunior.aedes.algoritmos.ordenacao;

/**
 * Implementação do algoritmo InsertSort de ordenação.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 11/11/2025
 * @see https://github.com/otojunior
 */
public class InsertSort implements AlgoritmoOrdenacao {
    /**
     * Ordena um vetor utilizando o algoritmo InsertSort.
     * @param vetor O vetor a ser ordenado.
     */
    @Override
    public void sort(int[] vetor) {
        // Começa do segundo elemento (índice 1),
        for (int i = 1; i < vetor.length; i++) {
            int atual = vetor[i]; // valor que queremos inserir na parte ordenada
            int j = i - 1;

            // Move os elementos maiores que "atual" uma posição à frente
            while (j >= 0 && vetor[j] > atual) {
                vetor[j + 1] = vetor[j]; // desloca para a direita
                j--;
            }

            // Agora, j parou uma posição antes do local correto
            vetor[j + 1] = atual;
        }
    }
}

//[8, 3, 5, 2, 4]
//| Passo | Atual | Parte Ordenada | Resultado       |
//| :---- | :---- | :------------- | :-------------- |
//| 1     | 3     | [8]            | [3, 8, 5, 2, 4] |
//| 2     | 5     | [3, 8]         | [3, 5, 8, 2, 4] |
//| 3     | 2     | [3, 5, 8]      | [2, 3, 5, 8, 4] |
//| 4     | 4     | [2, 3, 5, 8]   | [2, 3, 4, 5, 8] |