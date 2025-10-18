/**
 * 
 */
package com.github.otojunior.aedes.pilha;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Estrutura de dados Pilha.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
public class PilhaEncadeada implements Pilha {
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
    private No topo;

    /**
     * Imprime os elementos da pilha na tela.
     * @return String representando a pilha.
     */
    @Override
    public String imprimir() {
        StringJoiner strjoin = new StringJoiner(" ");
        No atual = this.topo;
        while (atual != null) {
            strjoin.add(String.valueOf(atual.valor));
            atual = atual.proximo;
        }
        return strjoin.length() > 0
            ? strjoin.toString()
            : "[Pilha Vazia]";
    }

    /**
     * Insere um elemento no topo da pilha.
     * @param valor Valor a ser inserido.
     */
    @Override
    public void inserir(int valor) {
        No novo = new No(valor);
        novo.proximo = this.topo;
        this.topo = novo;
        this.tamanho++;
    }

    /**
     * Obtém o No referente à posição específica na pilha.
     * @param posicao Posição requerida.
     * @return No requerido
     */
    @Override
    public int obterindice(int valor) {
        No atual = this.topo;
        int i = 0;
        for (; i < this.tamanho && atual.valor != valor; i++) {
            atual = atual.proximo;
        }
        /*
         * No caso da pesquisa por valor dentro da pilha, o loop vai parar em
         * duas condições: ou o elemento foi encontrado ou o iterador chegou
         * ao fim da pilha. Estes casos são testados abaixo.
         */
        if (i < this.tamanho) {
            return i;
        } else {
            throw new NoSuchElementException(
                "Elemento %d pesquisado não encontrado na pilha"
                .formatted(valor));
        }
    }

    /**
     * Remove um elemento do início da pilha.
     */
    @Override
    public int puxar() {
        if (this.topo != null) {
            No atual = this.topo;
            this.topo = topo.proximo;
            this.tamanho--;
            return atual.valor;
        } else {
            throw new NoSuchElementException("Pilha Vazia");
        }
    }

    /**
     * Retorna o tamanho da pilha.
     * @return Tamanho da pilha (número de elementos na pilha).
     */
    @Override
    public int tamanho() {
        return this.tamanho;
    }
}
