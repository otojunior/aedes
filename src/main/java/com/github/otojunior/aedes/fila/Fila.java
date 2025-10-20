package com.github.otojunior.aedes.fila;

public interface Fila {
    String imprimir();
    void inserir(int valor);
    int obterindice(int valor);
    int puxar();
    int tamanho();
}
