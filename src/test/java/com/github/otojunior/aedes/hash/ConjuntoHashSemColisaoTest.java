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
 * Testes unitários para a classe {@link ConjuntoHash} sem colisão.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 08/10/2025
 * @see https://github.com/otojunior
 */
@DisplayName("Conjunto Hash Sem Colisão")
public class ConjuntoHashSemColisaoTest extends ConjuntoHashTest {
    /**
     * Configuração inicial para os testes.
     */
    @BeforeEach
    void setup() {
        this.conjunto = new ConjuntoHash(5);
    }
    
    /**
     * Teste de verificação de ausência de elemento sem colisão
     */
    @Test
    @DisplayName("Ausencia de elemento sem colisão")
    void testNaoContem() {
        super.naoContem();
    }

    /**
     * Teste de verificação de existência de elemento sem colisão
     */
    @Test
    @DisplayName("Existência de elemento sem colisão")
    void testContem() {
        super.contem();
    }

    /**
     * Teste de impressão do Conjunto.
     */
    @Test
    @DisplayName("Impressão do Conjunto sem colisão")
    void testImprimir() {
        String result = super.imprimir();
        assertEquals("""
            1: 11
            2: 22
            3: 33""", result);
    }

    /**
     * Teste de inserção em Conjunto já com elementos sem colisão.
     */
    @Test
    @DisplayName("Inserção em Conjunto já com elementos sem colisão.")
    void testInserirConjuntoComElementos() {
        String result = super.inserirConjuntoComElementos();
        assertEquals("""
            0: 5
            1: 1
            2: 2
            3: 3
            4: 4""", result);
    }

    /**
     * Teste de inserção em Conjunto vazio sem colisão
     */
    @Test
    @DisplayName("Inserção em Conjunto vazio sem colisão")
    void testInserirConjuntoVazio() {
        String result = super.inserirConjuntoVazio();
        assertEquals("1: 1", result);
    }
    
    /**
     * Teste de remoção de elemento sem colisão
     */
    @Test
    @DisplayName("Remoção de elemento sem colisão")
    void testRemover() {
        String result = super.remover();
        assertEquals("""
            0: 5
            1: 1
            2: 2
            4: 4""", result);
    }
    
    /**
     * Teste de remoção de elemento sem colisão
     */
    @Test
    @DisplayName("Remoção de elemento não existente sem colisão")
    void testRemoverNaoExistente() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> super.removerNaoExistente());
        assertEquals("Elemento 9 não encontrado.", ex.getMessage());
    }
    
    /**
     * Teste de tamanho (quantidade de elementos) da Conjunto sem colisão
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) do Conjunto sem colisão")
    void testTamanho() {
        super.tamanho();
    }
}
