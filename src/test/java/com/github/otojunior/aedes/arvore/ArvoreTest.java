/**
 * 
 */
package com.github.otojunior.aedes.arvore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Teste de unidade da Árvore Recursiva.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 05/10/2025
 * @see https://github.com/otojunior
 */
 abstract class ArvoreTest {
    Arvore arvore; 

    /**
     * Teste de inserção em Arvore já com elementos.
     */
    @Test
    @DisplayName("Inserção em Arvore já com elementos.")
    void testInserirArvoreComElementos() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        assertEquals(6, this.arvore.tamanho());
        assertEquals("2 3 5 6 7 9", this.arvore.imprimir());
    }

    /**
     * Teste de inserção em Arvore vazia
     */
    @Test
    @DisplayName("Inserção em Arvore vazia")
    void testInserirArvoreVazia() {
        this.arvore.inserir(1);
        assertEquals(1, this.arvore.tamanho());
        assertEquals("1", this.arvore.imprimir());
    }

    /**
     * Teste de remover elemento.
     */
    @Test
    @DisplayName("Remover elemento")
    void testRemover() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        this.arvore.remover(6);
        assertEquals(5, this.arvore.tamanho());
        assertEquals("2 3 5 7 9", this.arvore.imprimir());
    }

    /**
     * Teste de remover 2 elementos.
     */
    @Test
    @DisplayName("Remover 2 elementos")
    void testRemover2Elementos() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        this.arvore.remover(6);
        this.arvore.remover(3);
        assertEquals(4, this.arvore.tamanho());
        assertEquals("2 5 7 9", this.arvore.imprimir());
    }

    /**
     * Teste de remover folhas inferiores.
     */
    @Test
    @DisplayName("Remover folhas inferiores")
    void testRemoverFolhasInferiores() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        this.arvore.remover(2);
        this.arvore.remover(9);
        this.arvore.remover(6);
        assertEquals(3, this.arvore.tamanho());
        assertEquals("3 5 7", this.arvore.imprimir());
    }

    /**
     * Teste de remover 2 elementos.
     */
    @Test
    @DisplayName("Remover folhas intermediárias")
    void testRemoverFolhasIntermediarias() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        this.arvore.remover(7);
        this.arvore.remover(3);
        assertEquals(4, this.arvore.tamanho());
        assertEquals("2 5 6 9", this.arvore.imprimir());
    }

    /**
     * Teste de remover raiz.
     */
    @Test
    @DisplayName("Remover raiz")
    void testRemoverRaiz() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        this.arvore.remover(5);
        assertEquals(5, this.arvore.tamanho());
        assertEquals("2 3 6 7 9", this.arvore.imprimir());
    }

    /**
     * Teste de tamanho (quantidade de elementos) da Arvore
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da Arvore")
    void testTamanho() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        assertEquals(6, this.arvore.tamanho());
    }

    /**
     * Teste de impressão da Arvore.
     */
    @Test
    @DisplayName("Impressão da Arvore Em Ordem")
    void testToStringEmOrdem() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
        assertEquals("2 3 5 6 7 9", this.arvore.imprimir());
    }
}
