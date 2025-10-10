/**
 * 
 */
package com.github.otojunior.aedes.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Teste de unidade da Lista
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Lista")
class ListaTest {
    private Lista lista;

    /**
     * Configuração inicial antes de cada teste.
     */
    @BeforeEach
    void setup() {
        this.lista = new Lista();
    }

    /**
     * Teste Lista: Inserção do 1o. elemento.
     */
    @Test
    @Order(1)
    @DisplayName("Lista: Inserção do 1o. elemento")
    void testInserir1oElemento() {
        this.lista.inserir(1);
        assertEquals(1, this.lista.tamanho());
        assertEquals("1", this.lista.imprimir());
    }

    /**
     * Teste Lista: Inserção do 2o. elemento.
     */
    @Test
    @Order(2)
    @DisplayName("Lista: Inserção do 2o. elemento")
    void testInserir2oElemento() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste Lista: Inserção do 3o. elemento.
     */
    @Test
    @Order(3)
    @DisplayName("Lista: Inserção do 3o. elemento")
    void testInserir3oElemento() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        assertEquals(3, this.lista.tamanho());
        assertEquals("1 2 3", this.lista.imprimir());
    }

    /**
     * Teste Lista: Inserção em posição 0 em lista vazia.
     */
    @Test
    @Order(4)
    @DisplayName("Lista: Inserção em posição 0 em lista vazia")
    void testInserirPosicao0SemElementos() {
        this.lista.inserir(0, 1);
        assertEquals(1, this.lista.tamanho());
        assertEquals("1", this.lista.imprimir());
    }

    /**
     * Teste Lista: Inserção em posição 0 com 1 elemento.
     */
    @Test
    @Order(5)
    @DisplayName("Lista: Inserção em posição 0 com 1 elemento")
    void testInserirPosicao0Com1Elemento() {
        this.lista.inserir(2);
        this.lista.inserir(0, 1);
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste Lista: Inserção em posição 0 com 2 elementos.
     */
    @Test
    @Order(6)
    @DisplayName("Lista: Inserção em posição 0 com 2 elementos")
    void testInserirPosicao0Com2Elementos() {
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.inserir(0, 1);
        assertEquals(3, this.lista.tamanho());
        assertEquals("1 2 3", this.lista.imprimir());
    }

    /**
     * Teste de inserção em posição 1 em lista vazia.
     */
    @Test
    @Order(7)
    @DisplayName("Lista: Inserção em posição 1 em lista vazia")
    void testInserirPosicao1SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(1, 1);
            assertEquals("1", this.lista.imprimir());
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Teste Lista: Inserção em posição 1 com 1 elemento.
     */
    @Test
    @Order(8)
    @DisplayName("Lista: Inserção em posição 1 com 1 elemento")
    void testInserirPosicao1Com1Elemento() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(2);
            this.lista.inserir(1, 1);
            assertEquals("1", this.lista.imprimir());
        });
        assertEquals(
            "Erro ao acessar a posição 1. "
            + "Só é permitido posições entre 0 e 0.",
            ex.getMessage());
    }
    
    /**
     * Teste Lista: Inserção em posição 1 com 2 elementos.
     */
    @Test
    @Order(9)
    @DisplayName("Lista: Inserção em posição 1 com 2 elementos")
    void testInserirPosicao1Com2Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(1, 3);
        assertEquals(3, this.lista.tamanho());
        assertEquals("1 3 2", this.lista.imprimir());
    }

    /**
     * Teste Lista: Obtenção de posição de elemento existente.
     */
    @Test
    @Order(10)
    @DisplayName("Lista: Obtenção de posição de elemento existente")
    void testObterPosicaoElementoExistente() {
        this.lista.inserir(10);
        this.lista.inserir(20);
        this.lista.inserir(30);
        int index = this.lista.obterindice(20);
        assertEquals(1, index);
    }

    /**
     * Teste Lista: Obtenção de posição de elemento ausente.
     */
    @Test
    @Order(11)
    @DisplayName("Lista: Obtenção de posição de elemento ausente")
    void testObterPosicaoElementoAusente() {
        Exception ex = assertThrows(NoSuchElementException.class, () -> {
            this.lista.inserir(10);
            this.lista.inserir(20);
            this.lista.inserir(30);
            this.lista.obterindice(40);
        });
        assertEquals("Elemento 40 pesquisado não encontrado na lista.", ex.getMessage());
    }

    /**
     * Teste Lista: Remoção de elemento no início em lista vazia.
     */
    @Test
    @Order(12)
    @DisplayName("Lista: Remoção de elemento no início em lista vazia")
    void testRemoverInicioListaVazia() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> this.lista.removerinicio());
        assertEquals("Lista Vazia", ex.getMessage());
    }

    /**
     * Teste Lista: Remoção de único elemento no início.
     */
    @Test
    @Order(13)
    @DisplayName("Lista: Remoção de único elemento no início")
    void testRemoverUnicoInicio() {
        this.lista.inserir(1);
        this.lista.removerinicio();
        assertEquals(0, this.lista.tamanho());        
        assertEquals("", this.lista.imprimir());
    }
    
    /**
     * Teste Lista: Remoção de elemento no início.
     */
    @Test
    @Order(14)
    @DisplayName("Lista: Remoção de elemento no início")
    void testRemoverInicio() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.removerinicio();
        assertEquals(2, this.lista.tamanho());        
        assertEquals("2 3", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção de elemento no fim em lista vazia.
     */
    @Test
    @Order(15)
    @DisplayName("Lista: Remoção de elemento no fim em lista vazia")
    void testRemoverFimListaVazia() {
        Exception ex = assertThrows(
            NoSuchElementException.class,
            () -> this.lista.removerfim());
        assertEquals("Lista Vazia", ex.getMessage());
    }

    /**
     * Teste Lista: Remoção de único elemento no fim.
     */
    @Test
    @Order(16)
    @DisplayName("Lista: Remoção de único elemento no fim")
    void testRemoverUnicoFim() {
        this.lista.inserir(1);
        this.lista.removerfim();
        assertEquals(0, this.lista.tamanho());        
        assertEquals("", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção de elemento no fim.
     */
    @Test
    @Order(17)
    @DisplayName("Lista: Remoção de elemento no fim")
    void testRemoverFim() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.removerfim();
        assertEquals(2, this.lista.tamanho());
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção de elemento no meio inferior.
     */
    @Test
    @Order(18)
    @DisplayName("Lista: Remoção de elemento no meio inferior")
    void testRemoverMeioInferior() {
        for (int i = 1; i <= 7; i++) this.lista.inserir(i);
        this.lista.remover(2);
        assertEquals(6, this.lista.tamanho());
        assertEquals("1 2 4 5 6 7", this.lista.imprimir());
    }
    
    /**
     * Teste Lista: Remoção de elemento no meio.
     */
    @Test
    @Order(19)
    @DisplayName("Lista: Remoção de elemento no meio superior")
    void testRemoverMeioSuperior() {
        for (int i = 1; i <= 7; i++) this.lista.inserir(i);
        this.lista.remover(4);
        assertEquals(6, this.lista.tamanho());
        assertEquals("1 2 3 4 6 7", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição negativa
     */
    @Test
    @Order(20)
    @DisplayName("Lista: Remoção em posição negativa")
    void testRemoverPosicaoNegativa() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(1);
            this.lista.inserir(2);
            this.lista.inserir(3);
            this.lista.remover(-1);
        });
        assertEquals(
            "Erro ao acessar a posição -1. Só é permitido posições entre 0 e 2.",
            ex.getMessage());
    }

    /**
     * Teste Lista: Remoção em posição fora do limite
     */
    @Test
    @Order(21)
    @DisplayName("Lista: Remoção em posição fora do limite")
    void testRemoverPosicaoForaLimite() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(1);
            this.lista.inserir(2);
            this.lista.inserir(3);
            this.lista.remover(99);
        });
        assertEquals(
            "Erro ao acessar a posição 99. Só é permitido posições entre 0 e 2.",
            ex.getMessage());
    }

    /**
     * Teste Lista: Remoção em posição 0 em lista vazia
     */
    @Test
    @Order(22)
    @DisplayName("Lista: Remoção em posição 0 em lista vazia")
    void testRemoverPosicao0SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.remover(0);
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Teste Lista: Remoção em posição 0 em lista com 1 elemento.
     */
    @Test
    @Order(23)
    @DisplayName("Lista: Remoção em posição 0 em lista com 1 elemento")
    void testRemoverPosicao0Com1Elemento() {
        this.lista.inserir(1);
        this.lista.remover(0);
        assertEquals(0, this.lista.tamanho());        
        assertEquals("", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição 0 em lista com 2 elementos.
     */
    @Test
    @Order(24)
    @DisplayName("Lista: Remoção em posição 0 em lista com 2 elementos")
    void testRemoverPosicao0Com2Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.remover(0);
        assertEquals(1, this.lista.tamanho());        
        assertEquals("2", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição 0 em lista com 3 elementos.
     */
    @Test
    @Order(25)
    @DisplayName("Lista: Remoção em posição 0 em lista com 3 elementos")
    void testRemoverPosicao0Com3Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.remover(0);
        assertEquals(2, this.lista.tamanho());        
        assertEquals("2 3", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição 1 em lista vazia
     */
    @Test
    @Order(26)
    @DisplayName("Lista: Remoção em posição 1 em lista vazia")
    void testRemoverPosicao1SemElementos() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.remover(1);
        });
        assertEquals("Lista vazia.", ex.getMessage());
    }

    /**
     * Teste Lista: Remoção em posição 1 em lista com 1 elemento.
     */
    @Test
    @Order(27)
    @DisplayName("Lista: Remoção em posição 1 em lista com 1 elemento")
    void testRemoverPosicao1Com1Elemento() {
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            this.lista.inserir(1);
            this.lista.remover(1);
        });
        assertEquals(
            "Erro ao acessar a posição 1. Só é permitido posições entre 0 e 0.",
            ex.getMessage());
    }

    /**
     * Teste Lista: Remoção em posição 1 em lista com 2 elementos.
     */
    @Test
    @Order(28)
    @DisplayName("Lista: Remoção em posição 1 em lista com 2 elementos")
    void testRemoverPosicao1Com2Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.remover(1);
        assertEquals(1, this.lista.tamanho());        
        assertEquals("1", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição 1 em lista com 3 elementos.
     */
    @Test
    @Order(29)
    @DisplayName("Lista: Remoção em posição 1 em lista com 3 elementos")
    void testRemoverPosicao1Com3Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.remover(1);
        assertEquals(2, this.lista.tamanho());        
        assertEquals("1 3", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição final em lista com 1 elemento.
     */
    @Test
    @Order(30)
    @DisplayName("Lista: Remoção em posição final em lista com 1 elemento")
    void testRemoverPosicaoFinalCom1Elemento() {
        this.lista.inserir(1);
        this.lista.remover(this.lista.tamanho() - 1);
        assertEquals(0, this.lista.tamanho());        
        assertEquals("", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição final em lista com 2 elementos.
     */
    @Test
    @Order(31)
    @DisplayName("Lista: Remoção em posição final em lista com 2 elementos")
    void testRemoverPosicaoFinalCom2Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.remover(this.lista.tamanho() - 1);
        assertEquals(1, this.lista.tamanho());        
        assertEquals("1", this.lista.imprimir());
    }

    /**
     * Teste Lista: Remoção em posição final em lista com 3 elementos.
     */
    @Test
    @Order(32)
    @DisplayName("Lista: Remoção em posição final em lista com 3 elementos")
    void testRemoverPosicaoFinalCom3Elementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        this.lista.remover(this.lista.tamanho() - 1);
        assertEquals(2, this.lista.tamanho());        
        assertEquals("1 2", this.lista.imprimir());
    }

    /**
     * Teste Lista: Quantidade de elementos
     */
    @Test
    @Order(33)
    @DisplayName("Lista: Quantidade de elementos")
    void testQuantidadeElementos() {
        this.lista.inserir(1);
        this.lista.inserir(2);
        this.lista.inserir(3);
        assertEquals(3, this.lista.tamanho());
    }

    /**
     * Teste Lista: Impressão da Lista.
     */
    @Test
    @Order(34)
    @DisplayName("Lista: Impressão")
    void testImprimir() {
        this.lista.inserir(11);
        this.lista.inserir(22);
        this.lista.inserir(33);
        assertEquals("11 22 33", this.lista.imprimir());
    }
}
