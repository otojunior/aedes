/**
 * 
 */
package com.github.otojunior.aedes;

import java.util.NoSuchElementException;

/**
 * Estrutura de dados Árvore.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 05/10/2025
 * @see https://github.com/otojunior
 */
public class Arvore {
    /**
     * Estrurura de dados No
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 05/10/2025
     * @see https://github.com/otojunior
     */
    private class No {
        private int valor;
        private No esquerda;
        private No direita;

        private No(int valor) {
            this.valor = valor;
        }
    }

    private int tamanho;
    private No raiz;

    /**
     * Insere um elemento na árvore.
     * @param valor Valor a ser inserido.
     */
    public void inserir(int valor) {
        this.raiz = inserir(this.raiz, valor);
    }

    /**
     * Obtém um nó com o valor especificado.
     * @param valor Valor a ser buscado.
     * @return Nó encontrado.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    public No obter(int valor) {
        return obter(raiz, valor);
    }

    /**
     * Remove um elemento da árvore.
     * @param valor Valor do elemento a ser removido.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    /**
     * Retorna o tamanho da árvore.
     * @return Tamanho da árvore.
     */
    public int tamanho() {
        return this.tamanho;
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
     * Insere um elemento na árvore recursivamente.
     * @param no Nó atual.
     * @param valor Valor a ser inserido.
     * @return Nó atualizado.
     */
    private No inserir(No no, int valor) {
        if (no == null) {
            this.tamanho++;
            return new No(valor);
        } else {
            if (valor < no.valor) {
                no.esquerda = inserir(no.esquerda, valor);
            } else if (valor > no.valor) {
                no.direita = inserir(no.direita, valor);
            }
            // se for igual, ignora (sem duplicatas)
            return no;
        }
    }

    /**
     * Obtém um nó com o valor especificado.
     * @param no Nó atual.
     * @param valor Valor a ser buscado.
     * @return Nó encontrado.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    private No obter(No no, int valor) {
        if (no == null) {
            throw new NoSuchElementException(
                "Elemento " + valor + 
                " pesquisado não encontrado na árvore.");
        } else if (valor < no.valor) {
            return obter(no.esquerda, valor);
        } else if (valor > no.valor) {
            return obter(no.direita, valor);
        } else {
            return no;
        }
    }

    /**
     * Remove um elemento da árvore recursivamente.
     * @param no Nó atual.
     * @param valor Valor do elemento a ser removido.
     * @return Nó atualizado.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    private No remover(No no, int valor) {
        if (no == null) {
                throw new NoSuchElementException("Arvore Vazia");
        } else {
            if (valor < no.valor) {
                no.esquerda = remover(no.esquerda, valor);
            } else if (valor > no.valor) {
                no.direita = remover(no.direita, valor);
            } else {
                // Caso 1: nó sem filhos
                if (no.esquerda == null && no.direita == null) {
                    this.tamanho--;
                    return null;
                }
                // Caso 2: um filho à direita
                else if (no.esquerda == null) {
                    this.tamanho--;
                    return no.direita;
                }
                // Caso 3: um filho à esquerda
                else if (no.direita == null) {
                    this.tamanho--;
                    return no.esquerda;
                }
                // Caso 4: dois filhos: substitui pelo menor da subarvore da direita
                else {
                    No sucessor = no.direita;
                    while (sucessor.esquerda != null)
                        sucessor = sucessor.esquerda;
                    no.valor = sucessor.valor;
                    no.direita = remover(no.direita, sucessor.valor);
                }
            }
            return no;
        }
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
