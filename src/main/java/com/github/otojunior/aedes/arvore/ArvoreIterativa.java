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

    private No raiz;
    private int tamanho = 0;

    /**
     * Busca um valor na árvore.
     * @param valor Valor a ser buscado.
     * @return <code>true</code> se o valor for encontrado, <code>false</code> caso
     * contrário.
     */
    @Override
    public boolean existe(int valor) {
        No atual = raiz;
        while (atual != null) {
            if (valor == atual.valor)
                return true;
            atual = (valor < atual.valor)
                ? atual.esquerda
                : atual.direita;
        }
        return false;
    }

    /**
     * Imprime os elementos da árvore em ordem crescente.
     * Implementação iterativa do percurso em-ordem usando o algoritmo de Morris.
     * @return String representando a árvore.
     */
    public String imprimir() {
        StringBuilder strbuild = new StringBuilder();
        No atual = raiz;
        while (atual != null) {
            if (atual.esquerda == null) {
                // Adiciona o valor à string
                strbuild.append(atual.valor).append(" ");
                atual = atual.direita;
            } else {
                // Encontra o predecessor (mais à direita da subárvore esquerda)
                No prececessor = atual.esquerda;
                while (prececessor.direita != null && prececessor.direita != atual)
                    prececessor = prececessor.direita;
                if (prececessor.direita == null) {
                    // Cria o link temporário de volta para o nó atual
                    prececessor.direita = atual;
                    atual = atual.esquerda;
                } else {
                    // Quebra o link temporário e adiciona o valor à string
                    prececessor.direita = null;
                    strbuild.append(atual.valor).append(" ");
                    atual = atual.direita;
                }
            }
        }
        // Remove o espaço final, se houver
        if (strbuild.length() > 0) {
            strbuild.setLength(strbuild.length() - 1);
            return strbuild.toString();
        } else {
            return "[Arvore Vazia]";
        }
    }
    
    /**
     * Insere um novo elemento na árvore.
     * @param valor Valor do elemento a ser inserido.
     */
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
     * Remove um elemento da árvore.
     * Passo 1: Busca o nó a ser removido (atual) e seu pai (paiatual).
     * Passo 2: Escolha do nó substituto.
     * Passo 3: Reconexão.
     * @param valor Valor do elemento a ser removido.
     * @throws NoSuchElementException se o valor não for encontrado.
     */
    @Override
    public void remover(int valor) {
        if (this.raiz == null) {
            throw new NoSuchElementException("Arvore Vazia");
        } else {
            No atual = this.raiz;
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
            if (atual != null) {
                No substituto;
                if (atual.esquerda == null || atual.direita == null) {
                    // Caso 1: Nenhum ou um filho.
                    substituto = (atual.esquerda != null)
                        ? atual.esquerda
                        : atual.direita;
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
            } else {
                throw new NoSuchElementException(
                    "Elemento %d n\u00E3o encontrado na \u00E1rvore"
                    .formatted(valor));
            }
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
}
