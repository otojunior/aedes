/**
 * 
 */
package com.github.otojunior.aedes.arvore;

import java.util.NoSuchElementException;

/**
 * Estrutura de dados Árvore (implementação iterativa) proposta por Donald Knuth em
 * "The Art of Computer Programming, Volume 1, Fundamental Algorithms", 3rd Edition, 1997.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 07/10/2025
 * @see https://github.com/otojunior
 */
public class ArvoreIterativa implements Arvore {
    private No raiz;
    private int tamanho = 0;
    
    /**
     * Estrurura de dados No
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 05/10/2025
     * @see https://github.com/otojunior
     */
    private static class No {
        private int valor;
        private No esquerda;
        private No direita;

        private No(int valor) {
            this.valor = valor;
        }
    }

    @Override
    public void inserir(int valor) {
        No novo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novo;
        } else {
            No atual = raiz;
            No pai = null;
            while (atual != null) {
                pai = atual;
                if (valor < atual.valor) {
                    atual = atual.esquerda;
                } else if (valor > atual.valor) {
                    atual = atual.direita;
                } else {
                    return; // já existe, não insere duplicado
                }
            }
            if (valor < pai.valor) {
                pai.esquerda = novo;
            } else {
                pai.direita = novo;
            }
        }
        this.tamanho++;

    }

    /**
     * Busca um valor na árvore.
     * @param valor Valor a ser buscado.
     * @return <code>true</code> se o valor for encontrado, <code>false</code> caso
     * contrário.
     */
    public boolean buscar(int valor) {
        No atual = raiz;
        while (atual != null) {
            if (valor == atual.valor) {
                return true;
            }
            atual = (valor < atual.valor)
                ? atual.esquerda
                : atual.direita;
        }
        return false;
    }

    /**
     * Remove um elemento da árvore.
     * Passo 1: Busca o nó a ser removido (atual) e seu pai (paiatual).
     * Passo 2: Escolha do nó substituto.
     * Passo 3: Reconexão.
     * @param valor Valor do elemento a ser removido.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    @Override
    public void remover(int valor) {
        if (raiz == null) throw new NoSuchElementException("Árvore vazia");

        No atual = raiz;
        No paiatual = null;

        /*
         * Passo 1: Busca o nó a ser removido (atual) e seu pai (paiatual)
         */
        while (atual != null && atual.valor != valor) {
            paiatual = atual;
            atual = (valor < atual.valor)
                ? atual.esquerda
                : atual.direita;
        }

        /*
         * Passo 2: Escolha do nó substituto
         */
        if (atual == null) {
            throw new NoSuchElementException("Elemento " + valor + " não encontrado.");
        } else {
            No substituto;
            if (atual.esquerda == null || atual.direita == null) {
                // Caso 1: Nenhum ou um filho.
                substituto = (atual.esquerda != null) ? atual.esquerda : atual.direita;
            } else {
                // Caso 2: Dois filhos: encontra sucessor e remove
                No sucessor = atual.direita;
                No paisucessor = atual;
                while (sucessor.esquerda != null) {
                    paisucessor = sucessor;
                    sucessor = sucessor.esquerda;
                }

                // Copia valor do sucessor
                atual.valor = sucessor.valor;   

                // Remove o sucessor (tem no máximo um filho direito)
                if (paisucessor == atual) {
                    paisucessor.direita = sucessor.direita;
                } else {
                    paisucessor.esquerda = sucessor.direita;
                }

                // Manter caminho uniforme até reconexão
                substituto = atual;
            }

            /*
             * Passo 3: Reconexão
             */
            if (atual != this.raiz) {
                if (atual == paiatual.esquerda) {
                    paiatual.esquerda = substituto;
                } else {
                    paiatual.direita = substituto;
                }
            } else {
                this.raiz = substituto;
            }
            this.tamanho--;
        }
    }

    /**
     * Retorna o número de elementos na árvore.
     * @return Número de elementos na árvore.
     */
    @Override
    public int tamanho() {
        return tamanho;
    }

    /**
     * Retorna uma representação em string da árvore em ordem.
     * @return String representando a árvore em em-ordem.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(raiz, sb);
        return sb.toString().trim();
    }

    /**
     * Percorre a árvore em em-ordem recursivamente.
     * @param no Nó atual.
     * @param str StringBuilder para construir a representação em string.
     */
    private void toString(No no, StringBuilder str) {
        if (no != null) {
            toString(no.esquerda, str);
            str.append(no.valor).append(" ");
            toString(no.direita, str);
        }
    }
}
