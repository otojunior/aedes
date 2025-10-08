/**
 * 
 */
package com.github.otojunior.aedes.hash;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Estrutura de dados Conjunto (Set) utilizando tabela hash com tratamento de
 * colisões por encadeamento.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 07/10/2025
 * @see https://github.com/otojunior
 */
public class ConjuntoHash {
    /**
     * Estrurura de dados No.
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 07/10/2025
     * @see https://github.com/otojunior
     */
    private static class No {
        private int chave;
        private No proximo;
        
        /**
         * Construtor do No. Por padrão, em Java, as propriedades
         * de classe são inicializadas com valor nulo. 
         * @param chave Chave do elemento.
         */
        private No(int chave) {
            this.chave = chave;
        }
    }

    private No[] primeiro;
    private int tamanho;

    /**
     * Construtor do ConjuntoHash.
     * @param capacidade Capacidade inicial da tabela hash.
     */
    public ConjuntoHash(int capacidade) {
        this.primeiro = new No[capacidade];
        this.tamanho = 0;
    }

    /**
     * Construtor do ConjuntoHash com capacidade padrão.
     * A capacidade padrão é um valor grande para minimizar colisões.
     */
    public ConjuntoHash() {
        this(Integer.MAX_VALUE >> 32);
    }

    /**
     * Função hash simples.
     * @param chave Chave a ser transformada em índice.
     * @return Índice na tabela hash.
     */
    private int hash(int chave) {
        return Math.abs(chave) % primeiro.length;
    }

    /**
     * Insere um elemento, se não existir.
     * @param chave Chave a ser inserida.
     */
    public void inserir(int chave) {
        int indice = this.hash(chave);
        No atual = this.primeiro[indice];
        while (atual != null && atual.chave != chave) {
            atual = atual.proximo;
        }
        if (atual == null) {
            No novo = new No(chave);
            novo.proximo = this.primeiro[indice];
            this.primeiro[indice] = novo;
            this.tamanho++;
        }
    }

    /**
     * Verifica se o elemento existe.
     * @param chave Chave a ser verificada.
     * @return <code>true</code> se o elemento existir, <code>false</code> caso contrário.
     */
    public boolean contem(int chave) {
        int indice = this.hash(chave);
        No atual = this.primeiro[indice];
        while (atual != null && atual.chave != chave) {
            atual = atual.proximo;
        }
        return (atual != null);
    }

    /**
     * Remove um elemento, se existir.
     * @param chave Chave a ser removida.
     */
    public void remover(int chave) {
        int indice = this.hash(chave);
        No atual = this.primeiro[indice];
        No anterior = null;

        while (atual != null && atual.chave != chave) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual != null) {
            if (anterior == null) {
                this.primeiro[indice] = atual.proximo;
            } else {
                anterior.proximo = atual.proximo;
            }
            this.tamanho--;
        } else {
            throw new NoSuchElementException("Chave não encontrada: " + chave);
        }
    }

    /**
     * Retorna o número de elementos no conjunto.
     * @return Número de elementos.
     */
    public int tamanho() {
        return tamanho;
    }

    /**
     * Retorna uma representação em string do conjunto.
     * @return Representação em string.
     */
    public String toString() {
        StringJoiner stri = new StringJoiner("\n");
        for (int i = 0; i < primeiro.length; i++) {
            StringJoiner stre = new StringJoiner(" ");
            No atual = this.primeiro[i];
            while (atual != null) {
                String str = String.valueOf(atual.chave);
                stre.add(str);
                atual = atual.proximo;
            }
            if (stre.length() > 0) {
                stri.add(i + ": " + stre.toString());
            }
        }
        return stri.toString();
    }
}
