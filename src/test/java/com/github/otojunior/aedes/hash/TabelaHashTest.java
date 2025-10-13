package com.github.otojunior.aedes.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

abstract class TabelaHashTest {
    TabelaHash tabelahash;

    /**
     * Teste Tabela Hash: Impressão de tabela vazio.
     */
    @Test
    @Order(9)
    @DisplayName("Tabela Hash: Impressão de tabela vazio")
    void testImprimirVazio() {
        assertEquals("[Tabela Hash Vazia]", this.tabelahash.imprimir());
    }

    /**
     * Verifica se a tabela contém um elemento.
     */
    void contem() {
        for (int i = 1; i <= 3; i++) tabelahash.inserir(i,i*10);
        assertTrue(tabelahash.contem(2));
    }

    /**
     * Impressão do Tabela.
     */
    String imprimir() {
        for (int i = 1; i <= 3; i++) tabelahash.inserir(i,i*10);
        return tabelahash.imprimir();
    }

    /**
     * Inserção em Tabela já com elementos.
     * 
     */
    String inserirTabelaComElementos() {
        for (int i = 1; i <= 5; i++) tabelahash.inserir(i,i*10);
        assertEquals(5, tabelahash.tamanho());
        return tabelahash.imprimir();
    }

    /**
     * Inserção em Tabela vazia
     */
    String inserirTabelaVazio() {
        tabelahash.inserir(1,10);
        assertEquals(1, tabelahash.tamanho());
        return tabelahash.imprimir();
    }
    
    /**
     * Inserção em Tabela substituindo valor
     */
    String inserirTabelaSubstituindoValor() {
        tabelahash.inserir(1,10);
        tabelahash.inserir(1,15);
        assertEquals(1, tabelahash.tamanho());
        return tabelahash.imprimir();
    }
    
    /**
     * Verifica se a tabela não contém um elemento.
     */
    void naoContem() {
        for (int i = 1; i <= 3; i++) tabelahash.inserir(i,i*10);
        assertFalse(tabelahash.contem(4));
    }

    /**
     * Remoção de elemento
     */
    String remover() {
        for (int i = 1; i <= 5; i++) tabelahash.inserir(i,i*10);
        tabelahash.remover(3);
        assertEquals(4, tabelahash.tamanho());
        return tabelahash.imprimir();
    }
    
    /**
     * Remoção de elemento
     */
    String removerNaoExistente() {
        for (int i = 1; i <= 5; i++) tabelahash.inserir(i,i*10);
        tabelahash.remover(9);
        assertEquals(4, tabelahash.tamanho());
        return tabelahash.imprimir();
    }

    /**
     * Tamanho (quantidade de elementos) da Tabela
     */
    void tamanho() {
        for (int i = 1; i <= 3; i++) tabelahash.inserir(i,i*10);
        assertEquals(3, tabelahash.tamanho());
    }
}
