package com.github.otojunior.aedes.pilha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * Teste de unidade da Pilha Encadeada
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 18/10/2025
 * @see https://github.com/otojunior
 */
@DisplayName("Pilha com Vetor")
class PilhaComVetorTest extends PilhaTest {
    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        super.pilha = new PilhaComVetor(100);
    }
    
    /**
     * Teste Pilha: Inserção do 3o. elemento: Pilha cheia.
     */
    @Test
    @Order(3)
    @DisplayName("Pilha: Inserção do 3o. elemento: Pilha cheia")
    @Override
    void testInserir3oElemento() {
        Throwable ex = assertThrows(StackOverflowError.class, () -> {
            Pilha pilha = new PilhaComVetor(2);
            for (int i = 1; i <= 3; i++)
                pilha.inserir(i);
        });
        assertEquals("Pilha Cheia", ex.getMessage());
    }
}
