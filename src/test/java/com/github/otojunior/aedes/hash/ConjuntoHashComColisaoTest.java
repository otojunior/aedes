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
 * Testes unitários para a classe {@link ConjuntoHash} com colisão.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 08/10/2025
 * @see https://github.com/otojunior
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Conjunto Hash Com Colisão")
public class ConjuntoHashComColisaoTest extends ConjuntoHashTest {
    /**
     * Configuração inicial para os testes.
     */
    @BeforeEach
    void setup() {
        this.conjunto = new ConjuntoHash(1);
    }

    /**
     * Teste Conjunto Hash: Inserção com colisão.
     */
    @Test
    @Order(1)
    @DisplayName("Conjunto Hash: Inserção com colisão.")
    void testInserir() {
        assertEquals("0: 5 4 3 2 1", super.inserirConjuntoComElementos());
    }

    /**
     * Teste Conjunto Hash: Inserção em conjunto vazio com colisão
     */
    @Test
    @Order(2)
    @DisplayName("Conjunto Hash: Inserção em conjunto vazio com colisão")
    void testInserirConjuntoVazio() {
        assertEquals("0: 1", super.inserirConjuntoVazio());
    }

    /**
     * Teste Conjunto Hash: Verificação de existência de elemento com colisão
     */
    @Test
    @Order(3)
    @DisplayName("Conjunto Hash: Existência de elemento com colisão")
    void testContem() {
        super.contem();
    }

    /**
     * Teste Conjunto Hash: Ausência de elemento com colisão
     */
    @Test
    @Order(4)
    @DisplayName("Conjunto Hash: Ausência de elemento com colisão")
    void testNaoContem() {
        super.naoContem();
    }

    /**
     * Teste Conjunto Hash: Remoção de elemento com colisão
     */
    @Test
    @Order(5)
    @DisplayName("Conjunto Hash: Remoção de elemento com colisão")
    void testRemover() {
        assertEquals("0: 5 4 2 1", super.remover());
    }

    /**
     * Teste Conjunto Hash: Remoção de elemento ausente com colisão
     */
    @Test
    @Order(6)
    @DisplayName("Conjunto Hash: Remoção de elemento ausente com colisão")
    void testRemoverNaoExistente() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> super.removerNaoExistente());
        assertEquals("Elemento 9 n\u00E3o encontrado", ex.getMessage());
    }

    /**
     * Teste Conjunto Hash: Quantidade de elementos com colisão
     */
    @Test
    @Order(7)
    @DisplayName("Conjunto Hash: Quantidade de elementos com colisão")
    void testTamanho() {
        super.tamanho();
    }

    /**
     * Teste Conjunto Hash: Impressão com colisão.
     */
    @Test
    @Order(8)
    @DisplayName("Conjunto Hash: Impressão com colisão")
    void testImprimir() {
        assertEquals("0: 3 2 1", super.imprimir());
    }
}
