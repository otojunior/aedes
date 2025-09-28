/**
 * 
 */
package com.github.otojunior.aedes;

/**
 * Estrutura de dados Lista.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 28/09/2025
 */
public class Lista {
    /**
     * Estrurura de dados No
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 28/09/2025
     */
    private class No {
        private int valor;
        private No anterior;
        private No proximo;

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

        // Caso 1 (if): Lista vazia: inserção do primeiro elemento.
        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        }

        // Caso 2 (else): Lista não vazia: inserção dos demais elementos.
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

    public void remover(int posicao) {
        No atual = this.obter(posicao);

        // Caso 1: Remoção do único elemento
        if (atual == this.primeiro && atual == this.ultimo) {
            this.primeiro = null;
            this.ultimo = null;
        }

        // Caso 2: Remover no inicio
        else if (atual == this.primeiro) {
            this.primeiro = this.primeiro.proximo;
            this.primeiro.anterior = null;
        }

        // Caso 3: Remover no fim
        else if (atual == this.ultimo) {
            this.ultimo = this.ultimo.anterior;
            this.ultimo.proximo = null; 
        }

        // Caso 4: Remover no meio
        else {
            No esquerda = atual.anterior;
            No direita = atual.proximo;
            esquerda.proximo = direita;
            direita.anterior = esquerda;
        }

        this.tamanho--;
    }

    /**
     * Retorna o tamanho da lista.
     * @return Tamanho da lista (número de elementos na lista).
     */
    public int tamanho() {
        return this.tamanho;
    }

    /**
     * Imprime a lista de frente para trás caso contenha elementos.
     * @return Elementos da lista ou string (Lista Vazia)
     */
    @Override
    public String toString() {
        if (this.tamanho > 0) {
            StringBuilder str = new StringBuilder();
            No atual = this.primeiro;
            for (int i = 0; i < this.tamanho; i++) {
                str.append(atual.valor).append(' ');
                atual = atual.proximo;
            }
            str.deleteCharAt(str.length()-1);
            return str.toString();
        } else {
            return "(Lista Vazia)";
        }
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
