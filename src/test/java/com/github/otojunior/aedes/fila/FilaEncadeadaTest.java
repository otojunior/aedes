package com.github.otojunior.aedes.fila;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Teste de unidade da Fila Encadeada
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 20/10/2025
 * @see https://github.com/otojunior
 */
@DisplayName("Fila Encadeada")
class FilaEncadeadaTest extends FilaTest {
    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        super.fila = new FilaEncadeada();
    }
}
