package com.github.otojunior.aedes.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConjuntoHashTest {
    private ConjuntoHash conjunto;
    private ConjuntoHash conjuntoColisao;

    @BeforeEach
    void setup() {
        this.conjunto = new ConjuntoHash(5);
        this.conjuntoColisao = new ConjuntoHash(1);
    }
    
    /**
     * Teste de inserção em Conjunto já com elementos.
     */
    @Test
    @DisplayName("Inserção em Conjunto já com elementos.")
    void testInserirConjuntoComElementos() {
        this.conjunto.inserir(1);
        this.conjunto.inserir(2);
        System.out.println(this.conjunto);
        assertEquals(2, this.conjunto.tamanho());
        assertEquals("""
            1: 1
            2: 2""", this.conjunto.toString());
    }
    
    /**
     * Teste de inserção em Conjunto já com elementos.
     */
    @Test
    @DisplayName("Inserção em Conjunto já com elementos com colisão.")
    void testInserirConjuntoComElementosComColisao() {
        this.conjuntoColisao.inserir(1);
        this.conjuntoColisao.inserir(2);
        assertEquals(2, this.conjuntoColisao.tamanho());
        assertEquals("""
            1: 1
            2: 2""", this.conjuntoColisao.toString());
    }

    /**
     * Teste de inserção em Conjunto vazia
     */
    @Test
    @DisplayName("Inserção em Conjunto vazia")
    void testInserirConjuntoVazio() {
        this.conjunto.inserir(1);
        assertEquals(1, this.conjunto.tamanho());
        assertEquals("1", this.conjunto.toString());
    }

    /**
     * Teste de remover elemento.
     */
    @Test
    @DisplayName("Remover elemento")
    void testRemover() {
        this.conjunto.inserir(1);
        this.conjunto.inserir(2);
        this.conjunto.inserir(3);
        this.conjunto.remover(2);
        assertEquals(2, this.conjunto.tamanho());
    }
    
    /**
     * Teste de tamanho (quantidade de elementos) da Conjunto
     */
    @Test
    @DisplayName("Tamanho (quantidade de elementos) da Conjunto")
    void testTamanho() {
        this.conjunto.inserir(1);
        this.conjunto.inserir(2);
        this.conjunto.inserir(3);
        assertEquals(3, this.conjunto.tamanho());
    }

    /**
     * Teste de impressão da Conjunto.
     */
    @Test
    @DisplayName("Impressão da Conjunto")
    void testToString() {
        this.conjunto.inserir(11);
        this.conjunto.inserir(22);
        this.conjunto.inserir(33);
        assertEquals("33 22 11", this.conjunto.toString());
    }
}
