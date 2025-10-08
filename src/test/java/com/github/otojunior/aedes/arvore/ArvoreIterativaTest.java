/**
 * 
 */
package com.github.otojunior.aedes.arvore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Teste de unidade da Árvore Recursiva.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 05/10/2025
 * @see https://github.com/otojunior
 */
@DisplayName("Árvore Iterativa")
class ArvoreIterativaTest extends ArvoreTest {
    /**
     * Configuração inicial para cada teste.
     */
    @BeforeEach
    void setup() {
        this.arvore = new ArvoreIterativa();
    }
}
