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
public class PilhaComVetor implements Pilha {
    private int capacidade;
    private int tamanho;
    private int[] elementos;

    /**
     * Construtor da Pilha com Vetor.
     * @param capacidade Capacidade máxima da pilha.
     */
    public PilhaComVetor(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }

    /**
     * Imprime os elementos da pilha na tela.
     * @return String representando a pilha.
     */
    @Override
    public String imprimir() {
        StringJoiner strjoin = new StringJoiner(" ");
        for (int i = (this.tamanho-1); i >= 0; i--)
            strjoin.add(String.valueOf(elementos[i]));
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
        if (this.tamanho < this.capacidade) {
            this.elementos[this.tamanho] = valor;
            this.tamanho++;
        } else {
            throw new StackOverflowError("Pilha Cheia");
        }
    }

    /**
     * Obtém o No referente à posição específica na pilha.
     * @param posicao Posição requerida.
     * @return No requerido
     */
    @Override
    public int obterindice(int valor) {
        int i = (this.tamanho-1);

        /*
         * No caso da pesquisa por valor dentro da pilha, o loop vai parar em
         * duas condições: ou o elemento foi encontrado ou o iterador chegou
         * ao fim da pilha. Estes casos são testados abaixo.
         */
        for (; i >= 0 && this.elementos[i] != valor; i--);
        if (i >= 0) {
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
        if (this.tamanho > 0) {
            int indice = (this.tamanho-1);
            int elemento = this.elementos[indice]; 
            this.tamanho--;
            return elemento; 
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
