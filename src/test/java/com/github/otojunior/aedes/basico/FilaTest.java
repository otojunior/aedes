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
@Order(2)
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
        this.fila.inserir(1);
        this.fila.inserir(2);
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
        this.fila.inserir(1);
        this.fila.inserir(2);
        this.fila.inserir(3);
        assertEquals(3, this.fila.tamanho());
        assertEquals("1 2 3", this.fila.imprimir());
    }

    /**
     * Teste Fila: Puxar antepenúltimo elemento.
     */
    @Test
    @Order(4)
    @DisplayName("Fila: Puxar antepenúltimo elemento")
    void testPuxarAntepenultimoElemento() {
        this.fila.inserir(1);
        this.fila.inserir(2);
        this.fila.inserir(3);
        int valor = this.fila.puxar();
        assertEquals(2, this.fila.tamanho());
        assertEquals(1, valor);
    }

    /**
     * Teste Fila: Puxar penúltimo elemento.
     */
    @Test
    @Order(5)
    @DisplayName("Fila: Puxar penúltimo elemento")
    void testPuxarPenultimoElemento() {
        this.fila.inserir(1);
        this.fila.inserir(2);
        int valor = this.fila.puxar();
        assertEquals(1, this.fila.tamanho());
        assertEquals(1, valor);
    }
    
    /**
     * Teste Fila: Puxar último elemento.
     */
    @Test
    @Order(6)
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
    @Order(7)
    @DisplayName("Fila: Obtenção de posição de elemento existente")
    void testObterPosicaoElementoExistente() {
        this.fila.inserir(10);
        this.fila.inserir(20);
        this.fila.inserir(30);
        int index = this.fila.obterindice(20);
        assertEquals(1, index);
    }

    /**
     * Teste Fila: Obtenção de posição de elemento existente.
     */
    @Test
    @Order(8)
    @DisplayName("Fila: Obtenção de posição de elemento ausente")
    void testObterPosicaoElementoAusente() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            this.fila.inserir(10);
            this.fila.inserir(20);
            this.fila.inserir(30);
            this.fila.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na fila.", ex.getMessage());
    }

    /**
     * Teste Fila: Quantidade de elementos
     */
    @Test
    @Order(9)
    @DisplayName("Fila: Quantidade de elementos")
    void testQuantidadeElementos() {
        this.fila.inserir(1);
        this.fila.inserir(2);
        this.fila.inserir(3);
        assertEquals(3, this.fila.tamanho());
    }

    /**
     * Teste de impressão da Fila.
     */
    @Test
    @Order(10)
    @DisplayName("Fila: Impressão")
    void testImprimir() {
        this.fila.inserir(11);
        this.fila.inserir(22);
        this.fila.inserir(33);
        assertEquals("11 22 33", this.fila.imprimir());
    }
}
