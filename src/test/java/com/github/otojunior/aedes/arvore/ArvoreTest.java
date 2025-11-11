/**
 * 
 */
package com.github.otojunior.aedes.arvore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Teste de unidade da Árvore Recursiva.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 05/10/2025
 * @see https://github.com/otojunior
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Árvore")
abstract class ArvoreTest {
    Arvore arvore; 

    /**
     * Teste Árvore: Inserção do 1o. elemento.
     */
    @Test
    @Order(1)
    @DisplayName("Árvore: Inserção do 1o. elemento")
    void testInserir1oElemento() {
        this.arvore.inserir(1);
        assertEquals(1, this.arvore.tamanho());
        assertEquals("1", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Inserção de elemento repetido.
     */
    @Test
    @Order(2)
    @DisplayName("Árvore: Inserção do 1o. elemento")
    void testInserirElementoRepetido() {
        this.arvore.inserir(1);
        this.arvore.inserir(1);
        assertEquals(1, this.arvore.tamanho());
        assertEquals("1", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Inserção de demais elementos.
     */
    @Test
    @Order(3)
    @DisplayName("Árvore: Inserção de demais elementos")
    void testInserirDemaisElementos() {
        inserirelementos();
        assertEquals(6, this.arvore.tamanho());
        assertEquals("2 3 5 6 7 9", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Verificar existência de elemento em árvore vazia.
     */
    @Test
    @Order(4)
    @DisplayName("Árvore: Verificar existência de elemento em árvore vazia")
    void testExisteElementoArvoreVazia() {
        assertFalse(this.arvore.existe(1));
    }

    /**
     * Teste Árvore: Verificar existência de elemento existente.
     */
    @Test
    @Order(5)
    @DisplayName("Árvore: Verificar existência de elemento existente")
    void testExisteElemento() {
        inserirelementos();
        assertTrue(this.arvore.existe(6));
    }

    /**
     * Teste Árvore: Verificar existência de elemento ausente.
     */
    @Test
    @Order(6)
    @DisplayName("Árvore: Verificar existência de elemento ausente")
    void testNaoExisteElemento() {
        inserirelementos();
        assertFalse(this.arvore.existe(99));
    }

    /**
     * Teste Árvore: Remover elemento de árvore vazia.
     */
    @Test
    @Order(7)
    @DisplayName("Árvore: Remover elemento de árvore vazia")
    void testRemoverElementoArvoreVazia() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> this.arvore.remover(1));
        assertEquals("Arvore Vazia", ex.getMessage());
    }

    /**
     * Teste Árvore: Remover elemento inexistente.
     */
    @Test
    @Order(8)
    @DisplayName("Árvore: Remover elemento inexistente")
    void testRemoverInexistente() {
        Exception ex = assertThrows(
            NoSuchElementException.class, () -> {
                inserirelementos();
                this.arvore.remover(99);
            });
        assertEquals("Elemento 99 n\u00E3o encontrado na \u00E1rvore", ex.getMessage());
    }

    /**
     * Teste Árvore: Remover elemento.
     */
    @Test
    @Order(9)
    @DisplayName("Árvore: Remover elemento")
    void testRemover() {
        inserirelementos();
        this.arvore.remover(6);
        assertEquals(5, this.arvore.tamanho());
        assertEquals("2 3 5 7 9", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Remover 2 elementos.
     */
    @Test
    @Order(10)
    @DisplayName("Árvore: Remover 2 elementos")
    void testRemover2Elementos() {
        inserirelementos();
        this.arvore.remover(6);
        this.arvore.remover(3);
        assertEquals(4, this.arvore.tamanho());
        assertEquals("2 5 7 9", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Remover elemento com 1 filho à direita.
     */
    @Test
    @Order(11)
    @DisplayName("Árvore: Remover elemento com 1 filho à direita.")
    void testRemoverElementoFilhoDireita() {
        this.arvore.inserir(5);
        this.arvore.inserir(7);
        this.arvore.remover(5);
        assertEquals(1, this.arvore.tamanho());
        assertEquals("7", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Remover elemento com 1 filho à esquerda.
     */
    @Test
    @Order(12)
    @DisplayName("Árvore: Remover elemento com 1 filho à esquerda.")
    void testRemoverElementoFilhoEsquerda() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.remover(5);
        assertEquals(1, this.arvore.tamanho());
        assertEquals("3", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Remover folhas inferiores.
     */
    @Test
    @Order(13)
    @DisplayName("Árvore: Remover folhas inferiores")
    void testRemoverFolhasInferiores() {
        inserirelementos();
        this.arvore.remover(2);
        this.arvore.remover(9);
        this.arvore.remover(6);
        assertEquals(3, this.arvore.tamanho());
        assertEquals("3 5 7", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Remover folhas intermediárias.
     */
    @Test
    @Order(14)
    @DisplayName("Árvore: Remover folhas intermediárias")
    void testRemoverFolhasIntermediarias() {
        inserirelementos();
        this.arvore.remover(7);
        this.arvore.remover(3);
        assertEquals(4, this.arvore.tamanho());
        assertEquals("2 5 6 9", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Remover raiz.
     */
    @Test
    @Order(15)
    @DisplayName("Árvore: Remover raiz")
    void testRemoverRaiz() {
        inserirelementos();
        this.arvore.remover(5);
        assertEquals(5, this.arvore.tamanho());
        assertEquals("2 3 6 7 9", this.arvore.imprimir());
    }

    /**
     * Teste Árvore: Quantidade de elementos
     */
    @Test
    @Order(16)
    @DisplayName("Árvore: Quantidade de elementos")
    void testQuantidadeElementos() {
        inserirelementos();
        assertEquals(6, this.arvore.tamanho());
    }

    /**
     * Teste Árvore: Impressão da árvore em ordem
     */
    @Test
    @Order(17)
    @DisplayName("Árvore: Impressão da árvore em ordem")
    void testImprimir() {
        inserirelementos();
        assertEquals("2 3 5 6 7 9", this.arvore.imprimir());
    }
    
    /**
     * Teste Árvore: Impressão da árvore em ordem com predecessor
     */
    @Test
    @Order(18)
    @DisplayName("Árvore: Impressão da árvore em ordem com predecessor")
    void testImprimirComPredecessor() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(4);
        assertEquals("3 4 5", this.arvore.imprimir());
    }
    
    /**
     * Teste Árvore: Impressão da árvore vazia
     */
    @Test
    @Order(19)
    @DisplayName("Árvore: Impressão da árvore vazia")
    void testImprimirVazia() {
        assertEquals("[Arvore Vazia]", this.arvore.imprimir());
    }

    /**
     * Insere elementos na árvore.
     */
    private void inserirelementos() {
        this.arvore.inserir(5);
        this.arvore.inserir(3);
        this.arvore.inserir(7);
        this.arvore.inserir(6);
        this.arvore.inserir(2);
        this.arvore.inserir(9);
    }
}
