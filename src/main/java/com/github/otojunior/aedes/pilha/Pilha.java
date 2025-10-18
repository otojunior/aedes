/**
 * 
 */
package com.github.otojunior.aedes.pilha;

/**
 * Interface da estrutura de dados Pilha.
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 18/10/2025
 * @see https://github.com/otojunior 
 */
public interface Pilha {
    String imprimir();
    void inserir(int valor);
    int obterindice(int valor);
    int puxar();
    int tamanho();
}
