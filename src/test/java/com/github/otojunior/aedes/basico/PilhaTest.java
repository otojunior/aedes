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
 * Teste de unidade da Pilha
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
class PilhaTest {
    private Pilha pilha;

    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        this.pilha = new Pilha();
    }

    /**
     * Teste de inserção em Pilha já com elementos.
     */
    @Test
    @DisplayName("Inserção em Pilha já com elementos.")
    void testInserirPilhaComElementos() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        assertEquals(2, this.pilha.tamanho());
        assertEquals("2 1", this.pilha.toString());
    }

    /**
     * Teste de inserção em Pilha vazia
     */
    @Test
    @DisplayName("Inserção em Pilha vazia")
    void testInserirPilhaVazia() {
        this.pilha.inserir(1);
        assertEquals(1, this.pilha.tamanho());
        assertEquals("1", this.pilha.toString());
    }

    /**
     * Teste de obtenção de posição de um valor de emento que existe
     */
    @Test
    @DisplayName("Obtenção de posição de um valor de emento que existe")
    void testObterPosicaoElementoQueExiste() {
        this.pilha.inserir(10);
        this.pilha.inserir(20);
        this.pilha.inserir(30);
        this.pilha.inserir(40);
        int index = this.pilha.obterindice(30);
        assertEquals(1, index);
    }

    /**
     * Teste de obtenção de posição de um valor de emento que não existe
     */
    @Test
    @DisplayName("Obtenção de posição de um valor de emento que não existe")
    void testObterPosicaoElementoQueNaoExiste() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            this.pilha.inserir(10);
            this.pilha.inserir(20);
            this.pilha.inserir(30);
            this.pilha.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na pilha.", ex.getMessage());
    }

    /**
     * Teste de puxar elemento.
     */
    @Test
    @DisplayName("Puxar elemento")
    void testPuxar() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        this.pilha.inserir(3);
        int valor = this.pilha.puxar();
        assertEquals(2, this.pilha.tamanho());
        assertEquals(3, valor);
    }

    /**
     * Teste de tamanho (quantidade de elementos) da Pilha
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da Pilha")
    void testTamanho() {
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        this.pilha.inserir(3);
        assertEquals(3, this.pilha.tamanho());
    }

    /**
     * Teste de impressão da Pilha.
     */
    @Test
    @DisplayName("Impressão da Pilha")
    void testToString() {
        this.pilha.inserir(11);
        this.pilha.inserir(22);
        this.pilha.inserir(33);
        assertEquals("33 22 11", this.pilha.toString());
    }
}
