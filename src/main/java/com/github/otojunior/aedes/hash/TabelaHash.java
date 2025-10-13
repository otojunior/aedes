/**
 * 
 */
package com.github.otojunior.aedes.hash;

import static java.lang.Math.abs;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Estrutura de dados Tabela Hash com tratamento de colisões por encadeamento.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 07/10/2025
 * @see https://github.com/otojunior
 */
public class TabelaHash {
    /**
     * Estrurura de dados No.
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 07/10/2025
     * @see https://github.com/otojunior
     */
    private static class No {
        private int chave;
        private int valor;
        private No proximo;

        /**
         * Construtor do No. Por padrão, em Java, as propriedades
         * de classe são inicializadas com valor nulo. 
         * @param chave Chave do elemento.
         */
        private No(int chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }

        /**
         * Retorna uma representação em string do nó.
         * @return Representação em string.
         */
        private String imprimir() {
            return "%d:%d".formatted(this.chave, this.valor);
        }
    }

    private No[] primeiro;
    private int tamanho;

    /**
     * Construtor do TabelaHash com capacidade padrão.
     * A capacidade padrão é um valor grande para minimizar colisões.
     */
    public TabelaHash() {
        this(1024);
    }

    /**
     * Construtor da TabelaHash.
     * @param capacidade Capacidade inicial da tabela hash.
     */
    public TabelaHash(int capacidade) {
        this.primeiro = new No[capacidade];
        this.tamanho = 0;
    }

    /**
     * Verifica se o elemento existe.
     * @param chave Chave a ser verificada.
     * @return <code>true</code> se o elemento existir, <code>false</code> caso contrário.
     */
    public boolean contem(int chave) {
        int indice = this.hash(chave);
        No atual = this.primeiro[indice];
        while (atual != null && atual.chave != chave)
            atual = atual.proximo;
        return (atual != null);
    }

    /**
     * Retorna uma representação em string do conjunto.
     * @return Representação em string.
     */
    public String imprimir() {
        final String delim1 = "\n";
        final String delim2 = " ";
        StringJoiner strjoin1 = new StringJoiner(delim1);
        for (int i = 0; i < primeiro.length; i++) {
            if (primeiro[i] != null) {
                StringJoiner strjoin2 = new StringJoiner(delim2);
                No atual = primeiro[i];
                while (atual != null) {
                    strjoin2.add(atual.imprimir());
                    atual = atual.proximo;
                }
                strjoin1.add(i + ": " + strjoin2.toString());
            }
        }
        return strjoin1.length() > 0
            ? strjoin1.toString()
            : "[Tabela Hash Vazia]";
    }

    /**
     * Insere um elemento, se não existir.
     * @param chave Chave a ser inserida.
     */
    public void inserir(int chave, int valor) {
        int indice = this.hash(chave);
        if (this.primeiro[indice] == null) {
            No novo = new No(chave, valor);
            this.primeiro[indice] = novo;
            this.tamanho++;
        } else {
            No atual = this.primeiro[indice];
            while (atual != null && atual.chave != chave)
                atual = atual.proximo;
            if (atual != null) {
                atual.valor = valor; // Atualiza o valor se a chave já existir
            } else {
                No novo = new No(chave, valor);
                novo.proximo = this.primeiro[indice];
                this.primeiro[indice] = novo;
                this.tamanho++;
            }
        }
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
            throw new NoSuchElementException(
                "Elemento %d n\u00E3o encontrado"
                .formatted(chave));
        }
    }

    /**
     * Retorna o número de elementos no conjunto.
     * @return Número de elementos.
     */
    public int tamanho() {
        return this.tamanho;
    }

    /**
     * Função hash simples.
     * @param chave Chave a ser transformada em índice.
     * @return Índice na tabela hash.
     */
    private int hash(int chave) {
        int chaveabs = abs(chave);
        return chaveabs % primeiro.length;
    }
}
