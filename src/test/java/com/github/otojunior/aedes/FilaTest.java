/**
 * 
 */
package com.github.otojunior.aedes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.*;

/**
 * Teste de unidade da Fila
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
class FilaTest {
    /**
     * Teste de inserção em Fila vazia
     */
    @Test
    @DisplayName("Inserção em Fila vazia")
    void testInserirFilaVazia() {
        Fila fila = new Fila();
        fila.inserir(1);
        assertEquals("1", fila.toString());
    }

    /**
     * Teste de inserção em Fila já com elementos.
     */
    @Test
    @DisplayName("Inserção em Fila já com elementos.")
    void testInserirFilaComElementos() {
        Fila fila = new Fila();
        fila.inserir(1);
        fila.inserir(2);
        assertEquals("1 2", fila.toString());
    }

    /**
     * Teste de tamanho (quantidade de elementos) da Fila
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da Fila")
    void testTamanho() {
        Fila fila = new Fila();
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        assertEquals(3, fila.tamanho());
    }

    /**
     * Teste de puxar elemento.
     */
    @Test
    @DisplayName("Puxar elemento")
    void testRemoverInicio() {
        Fila fila = new Fila();
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        int valor = fila.puxar();
        assertEquals(1, valor);
    }

    @Test
    @DisplayName("Obtenção de posição de um valor de emento que existe")
    void testObterPosicaoElementoQueExiste() {
        Fila fila = new Fila();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        int index = fila.obterindice(30);
        assertEquals(2, index);
    }

    @Test
    @DisplayName("Obtenção de posição de um valor de emento que não existe")
    void testObterPosicaoElementoQueNaoExiste() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            Fila fila = new Fila();
            fila.inserir(10);
            fila.inserir(20);
            fila.inserir(30);
            fila.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na fila.", ex.getMessage());
    }

    /**
     * Teste de impressão da Fila.
     */
    @Test
    @DisplayName("Impressão da Fila")
    void testToString() {
        Fila fila = new Fila();
        fila.inserir(11);
        fila.inserir(22);
        fila.inserir(33);
        assertEquals("11 22 33", fila.toString());
    }
}
