/**
 * 
 */
package com.github.otojunior.aedes.arvore;

import org.junit.jupiter.api.BeforeEach;

/**
 * Teste de unidade da Árvore Recursiva.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 05/10/2025
 * @see https://github.com/otojunior
 */
class ArvoreIterativaTest extends ArvoreTest {
    /**
     * Configuração inicial para cada teste.
     */
    @BeforeEach
    void setup() {
        this.arvore = new ArvoreIterativa();
    }
}
