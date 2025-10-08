/**
 * 
 */
package com.github.otojunior.aedes.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Teste de unidade da Fila
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
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
     * Teste de inserção em Fila já com elementos.
     */
    @Test
    @DisplayName("Inserção em Fila já com elementos.")
    void testInserirFilaComElementos() {
        this.fila.inserir(1);
        this.fila.inserir(2);
        assertEquals(2, this.fila.tamanho());
        assertEquals("1 2", this.fila.imprimir());
    }

    /**
     * Teste de inserção em Fila vazia
     */
    @Test
    @DisplayName("Inserção em Fila vazia")
    void testInserirFilaVazia() {
        this.fila.inserir(1);
        assertEquals(1, this.fila.tamanho());
        assertEquals("1", this.fila.imprimir());
    }

    /**
     * Teste de obtenção de posição de um valor de emento que existe
     */
    @Test
    @DisplayName("Obtenção de posição de um valor de emento que existe")
    void testObterPosicaoElementoQueExiste() {
        this.fila.inserir(10);
        this.fila.inserir(20);
        this.fila.inserir(30);
        this.fila.inserir(40);
        int index = this.fila.obterindice(30);
        assertEquals(2, index);
    }

    /**
     * Teste de obtenção de posição de um valor de emento que não existe
     */
    @Test
    @DisplayName("Obtenção de posição de um valor de emento que não existe")
    void testObterPosicaoElementoQueNaoExiste() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            this.fila.inserir(10);
            this.fila.inserir(20);
            this.fila.inserir(30);
            this.fila.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na fila.", ex.getMessage());
    }

    /**
     * Teste de puxar elemento.
     */
    @Test
    @DisplayName("Puxar elemento")
    void testPuxar() {
        this.fila.inserir(1);
        this.fila.inserir(2);
        this.fila.inserir(3);
        int valor = this.fila.puxar();
        assertEquals(2, this.fila.tamanho());
        assertEquals(1, valor);
    }

    /**
     * Teste de tamanho (quantidade de elementos) da Fila
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da Fila")
    void testTamanho() {
        this.fila.inserir(1);
        this.fila.inserir(2);
        this.fila.inserir(3);
        assertEquals(3, this.fila.tamanho());
    }

    /**
     * Teste de impressão da Fila.
     */
    @Test
    @DisplayName("Impressão da Fila")
    void testToString() {
        this.fila.inserir(11);
        this.fila.inserir(22);
        this.fila.inserir(33);
        assertEquals("11 22 33", this.fila.imprimir());
    }
}
