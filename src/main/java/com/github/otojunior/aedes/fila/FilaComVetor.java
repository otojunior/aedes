/**
 * 
 */
package com.github.otojunior.aedes.fila;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Estrutura de dados Fila com Vetor.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 20/10/2025
 * @see https://github.com/otojunior
 */
public class FilaComVetor implements Fila {
    private int capacidade;
    private int tamanho;
    private int inicio;
    private int[] elementos;

    /**
     * Construtor da Fila com Vetor.
     * @param capacidade Capacidade máxima da fila.
     */
    public FilaComVetor(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
        this.inicio = 0;
    }

    /**
     * Imprime os elementos da fila na tela.
     * @return String representando a fila.
     */
    @Override
    public String imprimir() {
        StringJoiner strjoin = new StringJoiner(" ");
        for (int i = 0; i < this.tamanho; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            strjoin.add(String.valueOf(elementos[indice]));
        }
        return strjoin.length() > 0
            ? strjoin.toString()
            : "[Fila Vazia]";
    }

    /**
     * Insere um elemento no final da fila.
     * @param valor Valor a ser inserido.
     */
    @Override
    public void inserir(int valor) {
        if (this.tamanho < this.capacidade) {
            int indice = (this.inicio + this.tamanho) % this.capacidade;
            this.elementos[indice] = valor;
            this.tamanho++;
        } else {
            throw new IllegalStateException("Fila Cheia");
        }
    }

    /**
     * Obtém o índice do elemento na fila.
     * @param valor Valor a ser pesquisado.
     * @return Índice do elemento.
     */
    @Override
    public int obterindice(int valor) {
        for (int i = 0; i < this.tamanho; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            if (this.elementos[indice] == valor)
                return i;
        }
        /*
         * Se chegou ao fim do laço:
         * o elemento não foi encontrado.
         */
        throw new NoSuchElementException(
            "Elemento %d pesquisado não encontrado na fila"
            .formatted(valor));
    }

    /**
     * Remove e retorna o elemento do início da fila.
     * @return Elemento removido.
     */
    @Override
    public int puxar() {
        if (this.tamanho > 0) {
            int indice = this.inicio % this.capacidade;
            System.out.println("Inicio: %d - Indice: %d"
                .formatted(inicio, indice));
            int elemento = this.elementos[indice];
            this.inicio++;
            this.tamanho--;
            return elemento; 
        } else {
            throw new NoSuchElementException("Fila Vazia");
        }
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }
}
