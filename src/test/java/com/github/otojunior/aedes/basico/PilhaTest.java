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
 * Teste de unidade da Pilha
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Pilha")
class PilhaTest {
    private Pilha pilha;

    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        this.pilha = new Pilha();
    }

    /**
     * Teste Pilha: Inserção do 1o. elemento.
     */
    @Test
    @Order(1)
    @DisplayName("Pilha: Inserção do 1o. elemento")
    void testInserir1oElemento() {
        this.pilha.inserir(1);
        assertEquals(1, this.pilha.tamanho());
        assertEquals("1", this.pilha.imprimir());
    }

    /**
     * Teste Pilha: Inserção do 2o. elemento.
     */
    @Test
    @Order(2)
    @DisplayName("Pilha: Inserção do 2o. elemento")
    void testInserir2oElemento() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        assertEquals(2, this.pilha.tamanho());
        assertEquals("2 1", this.pilha.imprimir());
    }

    /**
     * Teste Pilha: Inserção do 3o. elemento.
     */
    @Test
    @Order(3)
    @DisplayName("Pilha: Inserção do 3o. elemento")
    void testInserir3oElemento() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        this.pilha.inserir(3);
        assertEquals(3, this.pilha.tamanho());
        assertEquals("3 2 1", this.pilha.imprimir());
    }

    /**
     * Teste Pilha: Puxar antepenúltimo elemento.
     */
    @Test
    @Order(4)
    @DisplayName("Pilha: Puxar antepenúltimo elemento")
    void testPuxarAntepenultimoElemento() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        this.pilha.inserir(3);
        int valor = this.pilha.puxar();
        assertEquals(2, this.pilha.tamanho());
        assertEquals(3, valor);
    }

    /**
     * Teste Pilha: Puxar penúltimo elemento.
     */
    @Test
    @Order(5)
    @DisplayName("Pilha: Puxar penúltimo elemento")
    void testPuxarPenultimoElemento() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        int valor = this.pilha.puxar();
        assertEquals(1, this.pilha.tamanho());
        assertEquals(2, valor);
    }
    
    /**
     * Teste Pilha: Puxar último elemento.
     */
    @Test
    @Order(6)
    @DisplayName("Pilha: Puxar último elemento")
    void testPuxarUltimoElemento() {
        this.pilha.inserir(1);
        int valor = this.pilha.puxar();
        assertEquals(0, this.pilha.tamanho());
        assertEquals(1, valor);
    }
    
    /**
     * Teste Pilha: Obtenção de posição de elemento existente.
     */
    @Test
    @Order(7)
    @DisplayName("Pilha: Obtenção de posição de elemento existente")
    void testObterPosicaoElementoExistente() {
        this.pilha.inserir(10);
        this.pilha.inserir(20);
        this.pilha.inserir(30);
        int index = this.pilha.obterindice(20);
        assertEquals(1, index);
    }

    /**
     * Teste Pilha: Obtenção de posição de elemento ausente.
     */
    @Test
    @Order(8)
    @DisplayName("Pilha: Obtenção de posição de elemento ausente")
    void testObterPosicaoElementoAusente() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            this.pilha.inserir(10);
            this.pilha.inserir(20);
            this.pilha.inserir(30);
            this.pilha.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na pilha.", ex.getMessage());
    }

    /**
     * Teste Pilha: Quantidade de elementos
     */
    @Test
    @Order(9)
    @DisplayName("Pilha: Quantidade de elementos")
    void testQuantidadeElementos() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        this.pilha.inserir(3);
        assertEquals(3, this.pilha.tamanho());
    }

    /**
     * Teste de impressão da Pilha.
     */
    @Test
    @Order(10)
    @DisplayName("Pilha: Impressão")
    void testImprimir() {
        this.pilha.inserir(11);
        this.pilha.inserir(22);
        this.pilha.inserir(33);
        assertEquals("33 22 11", this.pilha.imprimir());
    }
}
