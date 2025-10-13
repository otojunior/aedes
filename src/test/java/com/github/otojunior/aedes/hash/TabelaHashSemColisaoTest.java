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
 * Testes unitários para a classe {@link TabelaHash} sem colisão.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 08/10/2025
 * @see https://github.com/otojunior
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tabela Hash Sem Colisão")
public class TabelaHashSemColisaoTest extends TabelaHashTest {
    /**
     * Configuração inicial para os testes.
     */
    @BeforeEach
    void setup() {
        this.tabelahash = new TabelaHash();
    }

    /**
     * Teste Tabela Hash: Inserção sem colisão.
     */
    @Test
    @Order(1)
    @DisplayName("Tabela Hash: Inserção sem colisão.")
    void testInserir() {
        assertEquals("""
            1: 1:10
            2: 2:20
            3: 3:30
            4: 4:40
            5: 5:50""", super.inserirTabelaComElementos());
    }

    /**
     * Teste Tabela Hash: Inserção em tabela vazia sem colisão
     */
    @Test
    @Order(2)
    @DisplayName("Tabela Hash: Inserção em tabela vazia sem colisão")
    void testInserirTabelaVazia() {
        assertEquals("1: 1:10", super.inserirTabelaVazio());
    }
    
    /**
     * Teste Tabela Hash: Inserção em tabela substituindo valor sem colisão
     */
    @Test
    @Order(3)
    @DisplayName("Tabela Hash: Inserção em tabela substituindo valor sem colisão")
    void testInserirTabelaSubstituindoValor() {
        assertEquals("1: 1:15", super.inserirTabelaSubstituindoValor());
    }

    /**
     * Teste Tabela Hash: Verificação de existência de elemento sem colisão
     */
    @Test
    @Order(4)
    @DisplayName("Tabela Hash: Existência de elemento sem colisão")
    void testContem() {
        super.contem();
    }

    /**
     * Teste Tabela Hash: Ausência de elemento sem colisão
     */
    @Test
    @Order(5)
    @DisplayName("Tabela Hash: Ausência de elemento sem colisão")
    void testNaoContem() {
        super.naoContem();
    }

    /**
     * Teste Tabela Hash: Remoção de elemento sem colisão
     */
    @Test
    @Order(6)
    @DisplayName("Tabela Hash: Remoção de elemento sem colisão")
    void testRemover() {
        assertEquals("""
            1: 1:10
            2: 2:20
            4: 4:40
            5: 5:50""", super.remover());
    }

    /**
     * Teste Tabela Hash: Remoção de elemento ausente sem colisão
     */
    @Test
    @Order(7)
    @DisplayName("Tabela Hash: Remoção de elemento ausente sem colisão")
    void testRemoverNaoExistente() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> super.removerNaoExistente());
        assertEquals("Elemento 9 n\u00E3o encontrado", ex.getMessage());
    }

    /**
     * Teste Tabela Hash: Quantidade de elementos sem colisão
     */
    @Test
    @Order(8)
    @DisplayName("Tabela Hash: Quantidade de elementos sem colisão")
    void testTamanho() {
        super.tamanho();
    }

    /**
     * Teste Tabela Hash: Impressão sem colisão.
     */
    @Test
    @Order(9)
    @DisplayName("Tabela Hash: Impressão sem colisão")
    void testImprimir() {
        assertEquals("""
            1: 1:10
            2: 2:20
            3: 3:30""", super.imprimir());
    }
}
