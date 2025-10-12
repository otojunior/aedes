package com.github.otojunior.aedes.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

abstract class ConjuntoHashTest {
    ConjuntoHash conjunto;

    /**
     * Teste Conjunto Hash: Impressão de conjunto vazio.
     */
    @Test
    @Order(9)
    @DisplayName("Conjunto Hash: Impressão de conjunto vazio")
    void testImprimirVazio() {
        assertEquals("[Conjunto Hash Vazio]", this.conjunto.imprimir());
    }

    /**
     * Verifica se o conjunto contém um elemento.
     */
    void contem() {
        for (int i = 1; i <= 3; i++) conjunto.inserir(i);
        assertTrue(conjunto.contem(2));
    }

    /**
     * Impressão do Conjunto.
     */
    String imprimir() {
        for (int i = 1; i <= 3; i++) conjunto.inserir(i);
        return conjunto.imprimir();
    }

    /**
     * Inserção em Conjunto já com elementos.
     * 
     */
    String inserirConjuntoComElementos() {
        for (int i = 1; i <= 5; i++) conjunto.inserir(i);
        assertEquals(5, conjunto.tamanho());
        return conjunto.imprimir();
    }

    /**
     * Inserção em Conjunto vazia
     */
    String inserirConjuntoVazio() {
        conjunto.inserir(1);
        assertEquals(1, conjunto.tamanho());
        return conjunto.imprimir();
    }
    
    /**
     * Verifica se o conjunto não contém um elemento.
     */
    void naoContem() {
        for (int i = 1; i <= 3; i++) conjunto.inserir(i);
        assertFalse(conjunto.contem(4));
    }

    /**
     * Remoção de elemento
     */
    String remover() {
        for (int i = 1; i <= 5; i++) conjunto.inserir(i);
        conjunto.remover(3);
        assertEquals(4, conjunto.tamanho());
        return conjunto.imprimir();
    }
    
    /**
     * Remoção de elemento
     */
    String removerNaoExistente() {
        for (int i = 1; i <= 5; i++) conjunto.inserir(i);
        conjunto.remover(9);
        assertEquals(4, conjunto.tamanho());
        return conjunto.imprimir();
    }

    /**
     * Tamanho (quantidade de elementos) da Conjunto
     */
    void tamanho() {
        for (int i = 1; i <= 3; i++) conjunto.inserir(i);
        assertEquals(3, conjunto.tamanho());
    }
}
