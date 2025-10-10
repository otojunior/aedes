/**
 * 
 */
package com.github.otojunior.aedes.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Teste de unidade da Fila
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Fila")
class FilaTest {
    private Fila fila;

    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        this.fila = new Fila();
    }

    /**
     * Teste Fila: Inserção do 1o. elemento.
     */
    @Test
    @Order(1)
    @DisplayName("Fila: Inserção do 1o. elemento")
    void testInserir1oElemento() {
        this.fila.inserir(1);
        assertEquals(1, this.fila.tamanho());
        assertEquals("1", this.fila.imprimir());
    }

    /**
     * Teste Fila: Inserção do 2o. elemento.
     */
    @Test
    @Order(2)
    @DisplayName("Fila: Inserção do 2o. elemento")
    void testInserir2oElemento() {
        for (int i = 1; i <= 2; i++) this.fila.inserir(i);
        assertEquals(2, this.fila.tamanho());
        assertEquals("1 2", this.fila.imprimir());
    }

    /**
     * Teste Fila: Inserção do 3o. elemento.
     */
    @Test
    @Order(3)
    @DisplayName("Fila: Inserção do 3o. elemento")
    void testInserir3oElemento() {
        for (int i = 1; i <= 3; i++) this.fila.inserir(i);
        assertEquals(3, this.fila.tamanho());
        assertEquals("1 2 3", this.fila.imprimir());
    }
    
    /**
     * Teste Pilha: Puxar elemento em pilha vazia.
     */
    @Test
    @Order(4)
    @DisplayName("Pilha: Puxar elemento em fila vazia")
    void testPuxarElementoFilaVazia() {
        Exception ex = assertThrows(
            NoSuchElementException.class, () -> this.fila.puxar());
        assertEquals("Fila Vazia", ex.getMessage());
    }

    /**
     * Teste Fila: Puxar antepenúltimo elemento.
     */
    @Test
    @Order(5)
    @DisplayName("Fila: Puxar antepenúltimo elemento")
    void testPuxarAntepenultimoElemento() {
        for (int i = 1; i <= 3; i++) this.fila.inserir(i);
        int valor = this.fila.puxar();
        assertEquals(2, this.fila.tamanho());
        assertEquals(1, valor);
    }

    /**
     * Teste Fila: Puxar penúltimo elemento.
     */
    @Test
    @Order(6)
    @DisplayName("Fila: Puxar penúltimo elemento")
    void testPuxarPenultimoElemento() {
        for (int i = 1; i <= 2; i++) this.fila.inserir(i);
        int valor = this.fila.puxar();
        assertEquals(1, this.fila.tamanho());
        assertEquals(1, valor);
    }
    
    /**
     * Teste Fila: Puxar último elemento.
     */
    @Test
    @Order(7)
    @DisplayName("Fila: Puxar último elemento")
    void testPuxarUltimoElemento() {
        this.fila.inserir(1);
        int valor = this.fila.puxar();
        assertEquals(0, this.fila.tamanho());
        assertEquals(1, valor);
    }
    
    /**
     * Teste Fila: Obtenção de posição de elemento existente.
     */
    @Test
    @Order(8)
    @DisplayName("Fila: Obtenção de posição de elemento existente")
    void testObterPosicaoElementoExistente() {
        for (int i = 1; i <= 3; i++) this.fila.inserir(i);
        int index = this.fila.obterindice(2);
        assertEquals(1, index);
    }

    /**
     * Teste Fila: Obtenção de posição de elemento ausente.
     */
    @Test
    @Order(9)
    @DisplayName("Fila: Obtenção de posição de elemento ausente")
    void testObterPosicaoElementoAusente() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            for (int i = 1; i <= 7; i++) this.fila.inserir(i);
            this.fila.obterindice(9);
        });
        assertEquals("Elemento 9 pesquisado não encontrado na fila.", ex.getMessage());
    }

    /**
     * Teste Fila: Quantidade de elementos
     */
    @Test
    @Order(10)
    @DisplayName("Fila: Quantidade de elementos")
    void testQuantidadeElementos() {
        for (int i = 1; i <= 8; i++) this.fila.inserir(i);
        assertEquals(8, this.fila.tamanho());
    }

    /**
     * Teste de impressão da Fila.
     */
    @Test
    @Order(11)
    @DisplayName("Fila: Impressão")
    void testImprimir() {
        for (int i = 1; i <= 5; i++) this.fila.inserir(i);
        assertEquals("1 2 3 4 5", this.fila.imprimir());
    }
}
