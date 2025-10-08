/**
 * 
 */
package com.github.otojunior.aedes.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Testes unitários para a classe {@link ConjuntoHash} com colisão.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 08/10/2025
 * @see https://github.com/otojunior
 */
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
     * Teste de verificação de ausência de elemento com colisão
     */
    @Test
    @DisplayName("Ausencia de elemento com colisão")
    void testNaoContem() {
        super.naoContem();
    }

    /**
     * Teste de verificação de existência de elemento com colisão
     */
    @Test
    @DisplayName("Existência de elemento com colisão")
    void testContem() {
        super.contem();
    }

    /**
     * Teste de impressão do Conjunto.
     */
    @Test
    @DisplayName("Impressão do Conjunto com colisão")
    void testImprimir() {
        assertEquals("0: 33 22 11", super.imprimir());
    }

    /**
     * Teste de inserção em Conjunto já com elementos com colisão.
     */
    @Test
    @DisplayName("Inserção em Conjunto já com elementos com colisão.")
    void testInserirConjuntoComElementos() {
        assertEquals("0: 5 4 3 2 1", super.inserirConjuntoComElementos());
    }

    /**
     * Teste de inserção em Conjunto vazio com colisão
     */
    @Test
    @DisplayName("Inserção em Conjunto vazio com colisão")
    void testInserirConjuntoVazio() {
        String result = super.inserirConjuntoVazio();
        assertEquals("0: 1", result);
    }
    
    /**
     * Teste de remoção de elemento com colisão
     */
    @Test
    @DisplayName("Remoção de elemento com colisão")
    void testRemover() {
        assertEquals("0: 5 4 2 1", super.remover());
    }
    
    /**
     * Teste de remoção de elemento com colisão
     */
    @Test
    @DisplayName("Remoção de elemento não existente com colisão")
    void testRemoverNaoExistente() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> super.removerNaoExistente());
        assertEquals("Elemento 9 não encontrado.", ex.getMessage());
    }
    
    /**
     * Teste de tamanho (quantidade de elementos) da Conjunto com colisão
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) do Conjunto com colisão")
    void testTamanho() {
        super.tamanho();
    }
}
