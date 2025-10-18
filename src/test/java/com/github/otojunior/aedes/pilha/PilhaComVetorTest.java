package com.github.otojunior.aedes.pilha;

import org.junit.jupiter.api.BeforeEach;

/**
 * Teste de unidade da Pilha Encadeada
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 18/10/2025
 * @see https://github.com/otojunior
 */
class PilhaComVetorTest extends PilhaTest {
    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        super.pilha = new PilhaComVetor(100);
    }
}
