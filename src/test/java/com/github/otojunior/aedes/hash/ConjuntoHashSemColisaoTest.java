/**
 * 
 */
package com.github.otojunior.aedes.hash;

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
 * Testes unitários para a classe {@link ConjuntoHash} sem colisão.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 08/10/2025
 * @see https://github.com/otojunior
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Conjunto Hash Sem Colisão")
public class ConjuntoHashSemColisaoTest extends ConjuntoHashTest {
    /**
     * Configuração inicial para os testes.
     */
    @BeforeEach
    void setup() {
        this.conjunto = new ConjuntoHash();
    }

    /**
     * Teste Conjunto Hash: Inserção sem colisão.
     */
    @Test
    @Order(1)
    @DisplayName("Conjunto Hash: Inserção sem colisão.")
    void testInserir() {
        assertEquals("""
            1: 1
            2: 2
            3: 3
            4: 4
            5: 5""", super.inserirConjuntoComElementos());
    }

    /**
     * Teste Conjunto Hash: Inserção em conjunto vazio sem colisão
     */
    @Test
    @Order(2)
    @DisplayName("Conjunto Hash: Inserção em conjunto vazio sem colisão")
    void testInserirConjuntoVazio() {
        assertEquals("1: 1", super.inserirConjuntoVazio());
    }

    /**
     * Teste Conjunto Hash: Verificação de existência de elemento sem colisão
     */
    @Test
    @Order(3)
    @DisplayName("Conjunto Hash: Existência de elemento sem colisão")
    void testContem() {
        super.contem();
    }

    /**
     * Teste Conjunto Hash: Ausência de elemento sem colisão
     */
    @Test
    @Order(4)
    @DisplayName("Conjunto Hash: Ausência de elemento sem colisão")
    void testNaoContem() {
        super.naoContem();
    }

    /**
     * Teste Conjunto Hash: Remoção de elemento sem colisão
     */
    @Test
    @Order(5)
    @DisplayName("Conjunto Hash: Remoção de elemento sem colisão")
    void testRemover() {
        assertEquals("""
            1: 1
            2: 2
            4: 4
            5: 5""", super.remover());
    }

    /**
     * Teste Conjunto Hash: Remoção de elemento ausente sem colisão
     */
    @Test
    @Order(6)
    @DisplayName("Conjunto Hash: Remoção de elemento ausente sem colisão")
    void testRemoverNaoExistente() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> super.removerNaoExistente());
        assertEquals("Elemento 9 n\u00E3o encontrado", ex.getMessage());
    }

    /**
     * Teste Conjunto Hash: Quantidade de elementos sem colisão
     */
    @Test
    @Order(7)
    @DisplayName("Conjunto Hash: Quantidade de elementos sem colisão")
    void testTamanho() {
        super.tamanho();
    }

    /**
     * Teste Conjunto Hash: Impressão sem colisão.
     */
    @Test
    @Order(8)
    @DisplayName("Conjunto Hash: Impressão sem colisão")
    void testImprimir() {
        assertEquals("""
            1: 1
            2: 2
            3: 3""", super.imprimir());
    }
}
