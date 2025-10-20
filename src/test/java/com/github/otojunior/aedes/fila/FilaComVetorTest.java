package com.github.otojunior.aedes.fila;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Teste de unidade da Fila com Vetor
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 20/10/2025
 * @see https://github.com/otojunior
 */
@DisplayName("Fila com Vetor")
class FilaComVetorTest extends FilaTest {
    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        super.fila = new FilaComVetor(100);
    }
}
