/**
 * 
 */
package com.github.otojunior.aedes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.*;

/**
 * Teste de unidade da Pilha
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
class PilhaTest {
    /**
     * Teste de inserção em Pilha vazia
     */
    @Test
    @DisplayName("Inserção em Pilha vazia")
    void testInserirPilhaVazia() {
        Pilha pilha = new Pilha();
        pilha.inserir(1);
        assertEquals("1", pilha.toString());
    }

    /**
     * Teste de inserção em Pilha já com elementos.
     */
    @Test
    @DisplayName("Inserção em Pilha já com elementos.")
    void testInserirPilhaComElementos() {
        Pilha pilha = new Pilha();
        pilha.inserir(1);
        pilha.inserir(2);
        assertEquals("2 1", pilha.toString());
    }

    /**
     * Teste de tamanho (quantidade de elementos) da Pilha
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da Pilha")
    void testTamanho() {
        Pilha pilha = new Pilha();
        pilha.inserir(1);
        pilha.inserir(2);
        pilha.inserir(3);
        assertEquals(3, pilha.tamanho());
    }

    /**
     * Teste de puxar elemento.
     */
    @Test
    @DisplayName("Puxar elemento")
    void testRemoverInicio() {
        Pilha pilha = new Pilha();
        pilha.inserir(1);
        pilha.inserir(2);
        pilha.inserir(3);
        int valor = pilha.puxar();
        assertEquals(3, valor);
    }

    @Test
    @DisplayName("Obtenção de posição de um valor de emento que existe")
    void testObterPosicaoElementoQueExiste() {
        Pilha pilha = new Pilha();
        pilha.inserir(10);
        pilha.inserir(20);
        pilha.inserir(30);
        pilha.inserir(40);
        int index = pilha.obterindice(30);
        assertEquals(1, index);
    }

    @Test
    @DisplayName("Obtenção de posição de um valor de emento que não existe")
    void testObterPosicaoElementoQueNaoExiste() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            Pilha pilha = new Pilha();
            pilha.inserir(10);
            pilha.inserir(20);
            pilha.inserir(30);
            pilha.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na pilha.", ex.getMessage());
    }

    /**
     * Teste de impressão da Pilha.
     */
    @Test
    @DisplayName("Impressão da Pilha")
    void testToString() {
        Pilha pilha = new Pilha();
        pilha.inserir(11);
        pilha.inserir(22);
        pilha.inserir(33);
        assertEquals("33 22 11", pilha.toString());
    }
}
