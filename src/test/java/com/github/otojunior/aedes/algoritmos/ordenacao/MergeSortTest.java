package com.github.otojunior.aedes.algoritmos.ordenacao;

import org.junit.jupiter.api.DisplayName;

/**
 * Teste unitário para a classe MergeSort.
 */
@DisplayName("MergeSort")
class MergeSortTest extends AlgoritmoOrdenacaoTest {
    /**
     * Construtor.
     */
    public MergeSortTest() {
        super.algoritmo = new MergeSort();
    }
}
