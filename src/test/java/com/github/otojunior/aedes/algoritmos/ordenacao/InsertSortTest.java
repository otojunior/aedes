package com.github.otojunior.aedes.algoritmos.ordenacao;

import org.junit.jupiter.api.DisplayName;

/**
 * Teste unitário para a classe InsertSort.
 */
@DisplayName("InsertSort")
class InsertSortTest extends AlgoritmoOrdenacaoTest {
    /**
     * Construtor.
     */
    public InsertSortTest() {
        super.algoritmo = new InsertSort();
    }
}
