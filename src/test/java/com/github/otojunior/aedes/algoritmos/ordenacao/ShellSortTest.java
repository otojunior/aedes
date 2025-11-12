package com.github.otojunior.aedes.algoritmos.ordenacao;

import org.junit.jupiter.api.DisplayName;

/**
 * Teste unitário para a classe ShellSort.
 */
@DisplayName("ShellSort")
class ShellSortTest extends AlgoritmoOrdenacaoTest {
    /**
     * Construtor.
     */
    public ShellSortTest() {
        super.algoritmo = new ShellSort();
    }
}
