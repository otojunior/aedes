/**
 * 
 */
package com.github.otojunior.aedes.fila;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Estrutura de dados Fila.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
public class FilaEncadeada implements Fila {
    /**
     * Estrurura de dados No
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 28/09/2025
     */
    private static class No {
        private int valor;
        private No proximo;

        /**
         * Construtor do No. Por padrão, em Java, as propriedades
         * de classe são inicializadas com valor nulo. 
         * @param valor Valor do elemento.
         */
        private No(int valor) {
            this.valor = valor;
        }
    }

    private int tamanho;
    private No primeiro;
    private No ultimo;
    

    /**
     * Imprime os elementos da fila na tela.
     * @return String representando a fila.
     */
    @Override
    public String imprimir() {
        StringJoiner strjoin = new StringJoiner(" ");
        No atual = this.primeiro;
        while (atual != null) {
            strjoin.add(String.valueOf(atual.valor));
            atual = atual.proximo;
        }
        return strjoin.length() > 0
            ? strjoin.toString()
            : "[Fila Vazia]";
    }

    /**
     * Insere um elemento no fim da fila.
     * @param valor Valor a ser inserido.
     */
    @Override
    public void inserir(int valor) {
        No novo = new No(valor);
        // Caso 1: Fila vazia: inserção do primeiro elemento.
        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        }
        // Caso 2: Inserção dos demais elementos.
        else {
            this.ultimo.proximo = novo;
            this.ultimo = this.ultimo.proximo;
        }
        this.tamanho++;
    }

    /**
     * Obtém o No referente à posição específica na fila.
     * @param posicao Posição requerida.
     * @return No requerido
     */
    @Override
    public int obterindice(int valor) {
        No atual = this.primeiro;
        int i = 0;
        for (; i < this.tamanho && atual.valor != valor; i++) {
            atual = atual.proximo;
        }
        /*
         * No caso da pesquisa por valor dentro da fila, o loop vai parar em
         * duas condições: ou o elemento foi encontrado ou o iterador chegou
         * ao fim da fila. Estes casos são testados abaixo.
         */
        if (i < this.tamanho) {
            return i;
        } else {
            throw new NoSuchElementException(
                "Elemento %d pesquisado não encontrado na fila"
                .formatted(valor));
        }
    }

    /**
     * Remove um elemento do início da fila.
     */
    @Override
    public int puxar() {
        if (this.primeiro != null) {
            No atual = this.primeiro;
            this.primeiro = primeiro.proximo;
            this.tamanho--;
            return atual.valor;
        } else {
            throw new NoSuchElementException("Fila Vazia");
        }
    }

    /**
     * Retorna o tamanho da fila.
     * @return Tamanho da fila (número de elementos na fila).
     */
    @Override
    public int tamanho() {
        return this.tamanho;
    }
}
