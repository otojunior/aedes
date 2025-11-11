package com.github.otojunior.aedes.algoritmos.ordenacao;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Teste unitário para a classe QuickSort.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
abstract class AlgoritmoOrdenacaoTest {
    AlgoritmoOrdenacao algoritmo;
    
    /**
     * Teste de ordenação de um vetor par desordenado.
     */
    @Test
    @Order(1)
    @DisplayName("Vetor par desordenado")
    void testSortVetorParDesordenado() {
        int[] vetor = {5, 8, 1, 2, 7, 3, 10, 9, 4, 6};
        algoritmo.sort(vetor);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, vetor);
    }

    /**
     * Teste de ordenação de um vetor impar desordenado.
     */
    @Test
    @Order(2)
    @DisplayName("Vetor impar desordenado")
    void testSortVetorImparDesordenado() {
        int[] vetor = {5, 8, 1, 2, 7, 3, 9, 6, 4};
        algoritmo.sort(vetor);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, vetor);
    }
    
    /**
     * Teste de ordenação de um vetor reverso.
     */
    @Test
    @Order(3)
    @DisplayName("Vetor reverso")
    void testSortVetorReverso() {
        int[] vetor = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        algoritmo.sort(vetor);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, vetor);
    }
    
    /**
     * Teste de ordenação de um vetor ordenado.
     */
    @Test
    @Order(4)
    @DisplayName("Vetor ordenado")
    void testSortVetorOrdenado() {
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        algoritmo.sort(vetor);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, vetor);
    }
}
