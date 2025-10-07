/**
 * 
 */
package com.github.otojunior.aedes.basico;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Estrutura de dados Lista duplamente encadeada.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
public class Lista {
    /**
     * Estrurura de dados No
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 28/09/2025
     */
    private static class No {
        private int valor;
        private No anterior;
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
     * Insere um elemento no fim da lista.
     * @param valor Valor a ser inserido.
     */
    public void inserir(int valor) {
        No novo = new No(valor);
        // Caso 1: Lista vazia: inserção do primeiro elemento.
        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        }
        // Caso 2: Inserção dos demais elementos.
        else {
            this.ultimo.proximo = novo;
            novo.anterior = this.ultimo;
            this.ultimo = this.ultimo.proximo;
        }
        this.tamanho++;
    }

    /**
     * Insere elementos em posição específica da lista.
     * @param posicao Posição específica na qual o elemento será inserido.
     * @param valor Valor do elemento.
     */
    public void inserir(int posicao, int valor) {
        No novo = new No(valor);
        // Caso 1: Lista vazia.
        if (posicao == 0 && this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            No atual = this.obter(posicao);
            // Caso 2: Inserir no inicio.
            if (atual == this.primeiro) {
                novo.proximo = atual;
                atual.anterior = novo;
                this.primeiro = novo;
            }
            // Caso 3: Inserir no meio.
            else {
                No esquerda = atual.anterior;
                No direita = atual;
                novo.anterior = esquerda;
                esquerda.proximo = novo;
                novo.proximo = direita;
                direita.anterior = novo;
            }
        }
        this.tamanho++;
    }

    /**
     * Remove elemento de uma posição específica da lista.
     * @param posicao Posição do elemento a ser removido.
     */
    public void remover(int posicao) {
        No atual = this.obter(posicao);
        // Caso 1: Remover no inicio
        if (atual == this.primeiro) {
            this.primeiro = this.primeiro.proximo;
            if (this.primeiro != null) {
                this.primeiro.anterior = null;
            }
        }
        // Caso 2: Remover no fim
        else if (atual == this.ultimo) {
            this.ultimo = this.ultimo.anterior;
            if (this.ultimo != null) {
                this.ultimo.proximo = null; 
            }
        }
        // Caso 3: Remover no meio
        else {
            No esquerda = atual.anterior;
            No direita = atual.proximo;
            esquerda.proximo = direita;
            direita.anterior = esquerda;
        }
        this.tamanho--;
    }

    /**
     * Remove um elemento do início da lista. Anda com o ponteiro de [Primeiro] e se
     * existir [Próximo-Nó], aterra o ponteiro de [Nó-Anterior].
     */
    public void removerinicio() {
        if (this.primeiro != null) {
            this.primeiro = this.primeiro.proximo;  // anda com o ponteiro para frente
            if (this.primeiro != null) {
                this.primeiro.anterior = null;
            }
            this.tamanho--;
        } else {
            throw new NoSuchElementException("Lista Vazia");
        }
    }
    
    /**
     * Remove um elemento do fim da lista. Anda com o ponteiro de [Ultimo] para trás e se
     * existir [Nó-Anterior], aterra o ponteiro de [Próximo-Nó].
     */
    public void removerfim() {
        if (this.ultimo != null) {
            this.ultimo = this.ultimo.anterior;     // anda com o ponteiro para trás
            if (this.ultimo != null) {
                this.ultimo.proximo = null;
            }
            this.tamanho--;
        } else {
            throw new NoSuchElementException("Lista Vazia");
        }
    }

    /**
     * Retorna o tamanho da lista.
     * @return Tamanho da lista (número de elementos na lista).
     */
    public int tamanho() {
        return this.tamanho;
    }

    /**
     * Obtém o No referente à posição específica na lista.
     * @param posicao Posição requerida.
     * @return No requerido
     */
    public int obterindice(int valor) {
        No atual = this.primeiro;
        int i = 0;
        for (; i < this.tamanho && atual.valor != valor; i++) {
            atual = atual.proximo;
        }
        /*
         * No caso da pesquisa por valor dentro da lista, o loop vai parar em
         * duas condições: ou o elemento foi encontrado ou o iterador chegou
         * ao fim da lista. Estes casos são testados abaixo.
         */
        if (i < this.tamanho) {
            return i;
        } else {
            throw new NoSuchElementException(
                "Elemento " + valor + 
                " pesquisado não encontrado na lista.");
        }
    }

    /**
     * Imprime os elementos da lista na tela.
     * @return String representando a lista.
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        No atual = this.primeiro;
        while (atual != null) {
            joiner.add("" + atual.valor);
            atual = atual.proximo;
        }
        return joiner.toString();
    }
    
    /**
     * Obtém o No referente à posição específica na lista.
     * @param posicao Posição requerida.
     * @return No requerido
     */
    private No obter(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            /*
             * Começa a pesquisar de frente para trás caso a posição
             * requerida esteja mais próximo do início da lista. 
             */
            if (posicao < this.tamanho / 2) {
                No atual = this.primeiro;
                for (int i = 0; i != posicao && i < this.tamanho; i++)
                    atual = atual.proximo;
                return atual;
            }
            /*
             * Começa a pesquisar de trás para frente caso a posição
             * requerida esteja mais próximo do fim da lista. 
             */
             else {
                 No atual = this.ultimo;
                 for (int i = this.tamanho-1 ; i != posicao && i >= 0; i--)
                     atual = atual.anterior;
                 return atual;
            }
        } else {
            if (this.tamanho == 0) {
                throw new IndexOutOfBoundsException("Lista vazia.");
            } else {
                throw new IndexOutOfBoundsException(
                    ("Erro ao acessar a posição %d. " +
                    "Só é permitido posições entre 0 e %d.")
                    .formatted(posicao, this.tamanho-1));
                
            }
        }
    }
}
