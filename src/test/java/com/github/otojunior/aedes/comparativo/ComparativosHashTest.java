/**
 * 
 */
package com.github.otojunior.aedes.comparativo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.github.otojunior.aedes.hash.ConjuntoHash;

/**
 * Testes unitários para a classe {@link ConjuntoHash} sem colisão.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 08/10/2025
 * @see https://github.com/otojunior
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Comparativos")
public class ComparativosHashTest {
    private HashSet<Integer> hashset;
    private ConjuntoHash conjunto;
    
    private static final int LIMIT = 10_000_000;
    private static final int CAPACITY = (int)(LIMIT * 0.01);
    
    /**
     * Configuração inicial para os testes.
     */
    @BeforeEach
    void setup() {
        this.hashset = new HashSet<>(CAPACITY);
        this.conjunto = new ConjuntoHash(CAPACITY);
    }
    
    @Test
    @Order(1)
    @DisplayName("HashSet INSERT")
    void testInsert1() {
        for (int i = 0; i < LIMIT; i++) hashset.add(i);
        assertEquals(LIMIT, hashset.size());
    }
    
    @Test
    @Order(2)
    @DisplayName("Conjunto INSERT")
    void testInsert2() {
        for (int i = 0; i < LIMIT; i++) conjunto.inserir(i);
        assertEquals(LIMIT, conjunto.tamanho());
    }
    
    @Test
    @Order(3)
    @DisplayName("HashSet REMOVE")
    void testRemove1() {
        for (int i = 0; i < LIMIT; i++) hashset.add(i);
        assertEquals(LIMIT, hashset.size());
        for (int i = 0; i < LIMIT; i++) hashset.remove(i);
        assertEquals(0, hashset.size());
    }
    
    @Test
    @Order(4)
    @DisplayName("Conjunto REMOVE")
    void testRemove2() {
        for (int i = 0; i < LIMIT; i++) conjunto.inserir(i);
        assertEquals(LIMIT, conjunto.tamanho());
        for (int i = 0; i < LIMIT; i++) conjunto.remover(i);
        assertEquals(0, conjunto.tamanho());
    }
    
    @Test
    @Order(5)
    @DisplayName("HashSet CONTAINS")
    void testContains1() {
        for (int i = 0; i < LIMIT; i++) hashset.add(i);
        assertEquals(LIMIT, hashset.size());
        for (int i = 0; i < LIMIT; i++) hashset.contains(i);
    }
    
    @Test
    @Order(6)
    @DisplayName("Conjunto CONTAINS")
    void testContains2() {
        for (int i = 0; i < LIMIT; i++) conjunto.inserir(i);
        assertEquals(LIMIT, conjunto.tamanho());
        for (int i = 0; i < LIMIT; i++) conjunto.contem(i);
    }
}
