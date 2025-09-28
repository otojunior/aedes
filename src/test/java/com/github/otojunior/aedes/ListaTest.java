/**
 * 
 */
package com.github.otojunior.aedes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Teste de unidade da Lista
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
class ListaTest {
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em Lista vazia")
    void testInserirListaVazia() {
        Lista lista = new Lista();
        lista.inserir(1);
        assertEquals("1", lista.toString());
    }

    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em Lista já com elementos.")
    void testInserirListaComElementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        assertEquals("1 2", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em posição 0 em lista vazia")
    void testInserirListaPosicao0SemElementos() {
        Lista lista = new Lista();
        lista.inserir(0, 1);
        assertEquals("1", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em posição 0 em lista com 1 elemento")
    void testInserirListaPosicao0Com1Elemento() {
        Lista lista = new Lista();
        lista.inserir(2);
        lista.inserir(0, 1);
        assertEquals("1 2", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em posição 0 em lista com 2 elementos")
    void testInserirListaPosicao0Com2Elementos() {
        Lista lista = new Lista();
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(0, 1);
        assertEquals("1 2 3", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em posição 1 em lista vazia")
    void testInserirListaPosicao1SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            Lista lista = new Lista();
            lista.inserir(1, 1);
            assertEquals("1", lista.toString());
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em posição 1 em lista com 1 elemento")
    void testInserirListaPosicao1Com1Elemento() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            Lista lista = new Lista();
            lista.inserir(2);
            lista.inserir(1, 1);
            assertEquals("1", lista.toString());
        });
        assertEquals(
            "Erro ao acessar a posição 1. "
            + "Só é permitido posições entre 0 e 0.",
            ex.getMessage());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Inserção em posição 1 em lista com 2 elementos")
    void testInserirListaPosicao1Com2Elementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(3);
        lista.inserir(1, 2);
        assertEquals("1 2 3", lista.toString());
    }

    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#tamanho()}.
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da Lista")
    void testTamanho() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        assertEquals(3, lista.tamanho());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 0 em lista vazia")
    void testRemoverListaPosicao0SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            Lista lista = new Lista();
            lista.remover(0);
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 0 em lista com 1 elemento")
    void testRemoverListaPosicao0Com1Elemento() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.remover(0);
        assertEquals("(Lista Vazia)", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 0 em lista com 2 elementos")
    void testRemoverListaPosicao0Com2Elementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        lista.remover(0);
        assertEquals("2", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista vazia")
    void testRemoverListaPosicao1SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            Lista lista = new Lista();
            lista.remover(1);
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 1 elemento")
    void testRemoverListaPosicao1Com1Elemento() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            Lista lista = new Lista();
            lista.inserir(1);
            lista.remover(1);
        });
        assertEquals(
            "Erro ao acessar a posição 1. "
            + "Só é permitido posições entre 0 e 0.",
            ex.getMessage());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 2 elementos")
    void testRemoverirListaPosicao1Com2Elementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        lista.remover(1);
        assertEquals("1", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 3 elementos")
    void testRemoverirListaPosicao1Com3Elementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.remover(1);
        assertEquals("1 3", lista.toString());
    }
    
    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 3 elementos")
    void testRemoverirListaPosicao2Com3Elementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.remover(2);
        assertEquals("1 2", lista.toString());
    }

    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 1 em lista com 5 elementos")
    void testRemoverirListaPosicao1Com5Elementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.remover(1);
        assertEquals("1 3 4 5", lista.toString());
    }

    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#inserir(int)}.
     */
    @Test
    @DisplayName("Remoção em posição 3 em lista com 5 elementos")
    void testRemoverirListaPosicao5Com5Elementos() {
        Lista lista = new Lista();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.remover(3);
        assertEquals("1 2 3 5", lista.toString());
    }

    /**
     * Test method for {@link com.github.otojunior.aedes.Lista#toString()}.
     */
    @Test
    @DisplayName("Impressão da Lista")
    void testToString() {
        Lista lista = new Lista();
        lista.inserir(11);
        lista.inserir(22);
        lista.inserir(33);
        assertEquals("11 22 33", lista.toString());
    }
}
