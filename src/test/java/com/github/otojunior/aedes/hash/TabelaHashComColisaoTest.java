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
 * Testes unitários para a classe {@link TabelaHash} com colisão.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 08/10/2025
 * @see https://github.com/otojunior
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tabela Hash Com Colisão")
public class TabelaHashComColisaoTest extends TabelaHashTest {
    /**
     * Configuração inicial para os testes.
     */
    @BeforeEach
    void setup() {
        this.tabelahash = new TabelaHash(1);
    }

    /**
     * Teste Tabela Hash: Inserção com colisão.
     */
    @Test
    @Order(1)
    @DisplayName("Tabela Hash: Inserção com colisão.")
    void testInserir() {
        assertEquals("0: 5:50 4:40 3:30 2:20 1:10", super.inserirTabelaComElementos());
    }

    /**
     * Teste Tabela Hash: Inserção em tabela vazia com colisão
     */
    @Test
    @Order(2)
    @DisplayName("Tabela Hash: Inserção em tabela vazia com colisão")
    void testInserirTabelaVazia() {
        assertEquals("0: 1:10", super.inserirTabelaVazio());
    }

    /**
     * Teste Tabela Hash: Inserção em tabela substituindo valor com colisão
     */
    @Test
    @Order(3)
    @DisplayName("Tabela Hash: Inserção em tabela substituindo valor com colisão")
    void testInserirTabelaSubstituindoValor() {
        assertEquals("0: 1:15", super.inserirTabelaSubstituindoValor());
    }

    /**
     * Teste Tabela Hash: Verificação de existência de elemento com colisão
     */
    @Test
    @Order(4)
    @DisplayName("Tabela Hash: Existência de elemento com colisão")
    void testContem() {
        super.contem();
    }

    /**
     * Teste Tabela Hash: Ausência de elemento com colisão
     */
    @Test
    @Order(5)
    @DisplayName("Tabela Hash: Ausência de elemento com colisão")
    void testNaoContem() {
        super.naoContem();
    }

    /**
     * Teste Tabela Hash: Remoção de elemento com colisão
     */
    @Test
    @Order(6)
    @DisplayName("Tabela Hash: Remoção de elemento com colisão")
    void testRemover() {
        assertEquals("0: 5:50 4:40 2:20 1:10", super.remover());
    }

    /**
     * Teste Tabela Hash: Remoção de elemento ausente com colisão
     */
    @Test
    @Order(7)
    @DisplayName("Tabela Hash: Remoção de elemento ausente com colisão")
    void testRemoverNaoExistente() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> super.removerNaoExistente());
        assertEquals("Elemento 9 n\u00E3o encontrado", ex.getMessage());
    }

    /**
     * Teste Tabela Hash: Quantidade de elementos com colisão
     */
    @Test
    @Order(8)
    @DisplayName("Tabela Hash: Quantidade de elementos com colisão")
    void testTamanho() {
        super.tamanho();
    }

    /**
     * Teste Tabela Hash: Impressão com colisão.
     */
    @Test
    @Order(9)
    @DisplayName("Tabela Hash: Impressão com colisão")
    void testImprimir() {
        assertEquals("0: 3:30 2:20 1:10", super.imprimir());
    }
}
