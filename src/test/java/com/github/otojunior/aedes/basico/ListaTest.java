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
 * Teste de unidade da Lista
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
@DisplayName("Lista")
class ListaTest {
    private Lista lista;

    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        this.lista = new Lista();
    }

    /**
     * Teste de inserção em Lista já com elementos.
     */
    @Test
    @DisplayName("Inserção em Lista já com elementos.")
    void testInserirListaComElementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste de inserção em posição 0 com 1 elemento.
     */
    @Test
    @DisplayName("Inserção em posição 0 com 1 elemento")
    void testInserirListaPosicao0Com1Elemento() {
        this.lista.inserir(2);
        this.lista.inserir(0, 1);
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste de inserção em posição 0 com 2 elementos.
     */
    @Test
    @DisplayName("Inserção em posição 0 com 2 elementos")
    void testInserirListaPosicao0Com2Elementos() {
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.inserir(0, 1);
        assertEquals(3, this.lista.tamanho());
        assertEquals("1 2 3", this.lista.imprimir());
    }

    /**
     * Teste de inserção em posição 0 em lista vazia.
     */
    @Test
    @DisplayName("Inserção em posição 0 em lista vazia")
    void testInserirListaPosicao0SemElementos() {
        this.lista.inserir(0, 1);
        assertEquals(1, this.lista.tamanho());
        assertEquals("1", this.lista.imprimir());
    }

    /**
     * Teste de inserção em posição 1 com 1 elemento.
     */
    @Test
    @DisplayName("Inserção em posição 1 com 1 elemento")
    void testInserirListaPosicao1Com1Elemento() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(2);
            this.lista.inserir(1, 1);
            assertEquals("1", this.lista.imprimir());
        });
        assertEquals(
            "Erro ao acessar a posição 1. "
            + "Só é permitido posições entre 0 e 0.",
            ex.getMessage());
    }

    /**
     * Teste de inserção em posição 0 em lista vazia.
     */
    @Test
    @DisplayName("Inserção em posição 1 em lista vazia")
    void testInserirListaPosicao1Com2Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(3);
        this.lista.inserir(1, 2);
        assertEquals(3, this.lista.tamanho());
        assertEquals("1 2 3", this.lista.imprimir());
    }

    /**
     * Teste de inserção em posição 1 em lista vazia.
     */
    @Test
    @DisplayName("Inserção em posição 1 em lista vazia")
    void testInserirListaPosicao1SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(1, 1);
            assertEquals("1", this.lista.imprimir());
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Teste de inserção em Lista vazia
     */
    @Test
    @DisplayName("Inserção em Lista vazia")
    void testInserirListaVazia() {
        this.lista.inserir(1);
        assertEquals(1, this.lista.tamanho());
        assertEquals("1", this.lista.imprimir());
    }

    /**
     * Teste de obtenção de posição de um valor de elemento que existe.
     */
    @Test
    @DisplayName("Obtenção de posição de um valor de emento que existe")
    void testObterPosicaoElementoQueExiste() {
        this.lista.inserir(10);
        this.lista.inserir(20);
        this.lista.inserir(30);
        int index = this.lista.obterindice(20);
        assertEquals(1, index);
    }

    /**
     * Teste de obtenção de posição de um valor de elemento que não existe.
     */
    @Test
    @DisplayName("Obtenção de posição de um valor de emento que não existe")
    void testObterPosicaoElementoQueNaoExiste() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            this.lista.inserir(10);
            this.lista.inserir(20);
            this.lista.inserir(30);
            this.lista.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na lista.", ex.getMessage());
    }

    /**
     * Teste de Remoção no fim.
     */
    @Test
    @DisplayName("Remoção de elemento no fim")
    void testRemoverFim() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.removerfim();
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste de Remoção no início.
     */
    @Test
    @DisplayName("Remoção de elemento no início")
    void testRemoverInicio() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.removerinicio();
        assertEquals(2, this.lista.tamanho());        
        assertEquals("2 3", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 1 em lista com 2 elementos.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 2 elementos")
    void testRemoverirListaPosicao1Com2Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.remover(1);
        assertEquals(1, this.lista.tamanho());
        assertEquals("1", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 1 em lista com 3 elementos.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 3 elementos")
    void testRemoverirListaPosicao1Com3Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.remover(1);
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 3", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 1 em lista com 5 elementos.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 5 elementos")
    void testRemoverirListaPosicao1Com5Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.inserir(4);
        this.lista.inserir(5);
        this.lista.remover(1);
        assertEquals(4, this.lista.tamanho());
        assertEquals("1 3 4 5", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 2 em lista com 3 elementos.
     */
    @Test
    @DisplayName("Remoção em posição 2 em lista com 3 elementos")
    void testRemoverirListaPosicao2Com3Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.remover(2);
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 4 em lista com 5 elementos.
     */
    @Test
    @DisplayName("Remoção em posição 4 em lista com 5 elementos")
    void testRemoverirListaPosicao4Com5Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.inserir(4);
        this.lista.inserir(5);
        this.lista.remover(4);
        assertEquals(4, this.lista.tamanho());
        assertEquals("1 2 3 4", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 0 com 1 elemento.
     */
    @Test
    @DisplayName("Remoção em posição 0 com 1 elemento")
    void testRemoverListaPosicao0Com1Elemento() {
        this.lista.inserir(1);
        this.lista.remover(0);
        assertEquals(0, this.lista.tamanho());
        assertEquals("", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 0 com 2 elemento.
     */
    @Test
    @DisplayName("Remoção em posição 0 com 2 elementos")
    void testRemoverListaPosicao0Com2Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.remover(0);
        assertEquals(1, this.lista.tamanho());
        assertEquals("2", this.lista.imprimir());
    }

    /**
     * Teste de remoção em posição 0 em lista vazia.
     */
    @Test
    @DisplayName("Remoção em posição 0 em lista vazia.")
    void testRemoverListaPosicao0SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.remover(0);
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Teste de remoção em posição 1 em lista com 1 elemento.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 1 elemento")
    void testRemoverListaPosicao1Com1Elemento() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(1);
            this.lista.remover(1);
        });
        assertEquals(
            "Erro ao acessar a posição 1. "
            + "Só é permitido posições entre 0 e 0.",
            ex.getMessage());
    }

    /**
     * Teste de remoção em posição 1 em lista vazia.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista vazia")
    void testRemoverListaPosicao1SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.remover(1);
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Teste de tamanho (quantidade de elementos) da Lista
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da lista")
    void testTamanho() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        assertEquals(3, this.lista.tamanho());
    }

    /**
     * Teste de impressão da Lista.
     */
    @Test
    @DisplayName("Impressão da Lista")
    void testToString() {
        this.lista.inserir(11);
        this.lista.inserir(22);
        this.lista.inserir(33);
        assertEquals(3, this.lista.tamanho());
        assertEquals("11 22 33", this.lista.imprimir());
    }
}
