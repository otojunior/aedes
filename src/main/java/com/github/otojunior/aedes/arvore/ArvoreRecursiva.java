/**
 * 
 */
package com.github.otojunior.aedes.arvore;

import java.util.NoSuchElementException;

/**
 * Estrutura de dados Árvore.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 05/10/2025
 * @see https://github.com/otojunior
 */
public class ArvoreRecursiva implements Arvore {
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
    private No raiz;

    /**
     * Verifica se um valor existe na árvore.
     * @param valor Valor a ser verificado.
     * @return true se o valor existir, false caso contrário.
     */
    @Override
    public boolean existe(int valor) {
        return existe(raiz, valor);
    }

    /**
     * Retorna uma representação em string da árvore em ordem.
     * @return String representando a árvore em em-ordem.
     */
    @Override
    public String imprimir() {
        StringBuilder strbuild = new StringBuilder();
        imprimir(this.raiz, strbuild);
        return strbuild.length() > 0
            ? strbuild.toString().trim()
            : "[Arvore Vazia]";
    }

    /**
     * Insere um elemento na árvore.
     * @param valor Valor a ser inserido.
     */
    @Override
    public void inserir(int valor) {
        this.raiz = inserir(this.raiz, valor);
    }

    /**
     * Remove um elemento da árvore.
     * @param valor Valor do elemento a ser removido.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    @Override
    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    /**
     * Retorna o tamanho da árvore.
     * @return Tamanho da árvore.
     */
    @Override
    public int tamanho() {
        return this.tamanho;
    }

    /**
     * Verifica se um valor existe na árvore recursivamente.
     * @param no Nó atual.
     * @param valor Valor a ser verificado.
     * @return true se o valor existir, false caso contrário.
     */
    private boolean existe(No no, int valor) {
        if (no != null) {
            if (valor < no.valor)
                return existe(no.esquerda, valor);
            else if (valor > no.valor)
                return existe(no.direita, valor);
            else return true;
        } else {
            return false;
        }
    }

    /**
     * Percorre a árvore em em-ordem recursivamente.
     * @param no Nó atual.
     * @param strbuild StringBuilder para construir a representação em string.
     */
    private void imprimir(No no, StringBuilder strbuild) {
        if (no != null) {
            imprimir(no.esquerda, strbuild);
            strbuild.append(no.valor).append(" ");
            imprimir(no.direita, strbuild);
        }
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
     * Remove um elemento da árvore recursivamente.
     * @param no Nó atual.
     * @param valor Valor do elemento a ser removido.
     * @return Nó atualizado.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    private No remover(No no, int valor) {
        if (raiz != null) {
            if (no != null) {
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
            } else {
                throw new NoSuchElementException(
                    "Elemento %d n\u00E3o encontrado na \u00E1rvore"
                    .formatted(valor));
            }
        } else {
            throw new NoSuchElementException("Arvore Vazia");
        }
    }
}
