/**
 * 
 */
package com.github.otojunior.aedes.arvore;

/**
 * Estrutura de dados Árvore (interface).
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 07/10/2025
 * @see https://github.com/otojunior
 */
public interface Arvore {
    public void inserir(int valor);
    public void remover(int valor);
    public int tamanho();
}
