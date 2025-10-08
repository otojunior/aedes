package com.github.otojunior.aedes.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class ConjuntoHashTest {
    ConjuntoHash conjunto;

    /**
     * Verifica se o conjunto contém um elemento.
     */
    void contem() {
        conjunto.inserir(1);
        conjunto.inserir(2);
        conjunto.inserir(3);
        assertTrue(conjunto.contem(2));
    }

    /**
     * Verifica se o conjunto não contém um elemento.
     */
    void naoContem() {
        conjunto.inserir(1);
        conjunto.inserir(2);
        conjunto.inserir(3);
        assertFalse(conjunto.contem(4));
    }

    /**
     * Impressão do Conjunto.
     */
    String imprimir() {
        conjunto.inserir(11);
        conjunto.inserir(22);
        conjunto.inserir(33);
        return conjunto.imprimir();
    }

    /**
     * Inserção em Conjunto já com elementos.
     * 
     */
    String inserirConjuntoComElementos() {
        conjunto.inserir(1);
        conjunto.inserir(2);
        conjunto.inserir(3);
        conjunto.inserir(4);
        conjunto.inserir(5);
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
     * Remoção de elemento
     */
    String remover() {
        conjunto.inserir(1);
        conjunto.inserir(2);
        conjunto.inserir(3);
        conjunto.inserir(4);
        conjunto.inserir(5);
        conjunto.remover(3);
        assertEquals(4, conjunto.tamanho());
        return conjunto.imprimir();
    }
    
    /**
     * Remoção de elemento
     */
    String removerNaoExistente() {
        conjunto.inserir(1);
        conjunto.inserir(2);
        conjunto.inserir(3);
        conjunto.inserir(4);
        conjunto.inserir(5);
        conjunto.remover(9);
        assertEquals(4, conjunto.tamanho());
        return conjunto.imprimir();
    }

    /**
     * Tamanho (quantidade de elementos) da Conjunto
     */
    void tamanho() {
        conjunto.inserir(1);
        conjunto.inserir(2);
        conjunto.inserir(3);
        assertEquals(3, conjunto.tamanho());
    }
}
