/**
 * 
 */
package com.github.otojunior.aedes.grafo;

import static java.lang.Math.abs;
import java.util.NoSuchElementException;

/**
 * Implementação de um grafo não direcionado e não valorado usando listas de adjacência
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @since 13/10/2025
 * @see https://github.com/otojunior
 */
public class GrafoNaoDirecionadoNaoValorado {
    /**
     * Estrutura interna para representar uma aresta
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 13/10/2025
     * @see https://github.com/otojunior
     */
    private static class Aresta {
        private Vertice destino;
        private Aresta proxima;

        /**
         * Construtor da aresta
         * @param destino Vértice de destino da aresta
         */
        private Aresta(Vertice destino) {
            this.destino = destino;
            this.proxima = null;
        }
    }

    /**
     * Estrutura interna para representar um vértice
     * @author Oto Soares Coelho Junior (otojunior@gmail.com)
     * @since 13/10/2025
     * @see https://github.com/otojunior
     */
    private static class Vertice {
        int valor;
        Aresta primeiraaresta;
        Vertice proximolista;  // liga a lista geral de vértices
        Vertice proximohash;   // colisões dentro da hash table

        /**
         * Construtor do vértice
         * @param valor o valor do vértice
         */
        Vertice(int valor) {
            this.valor = valor;
            this.primeiraaresta = null;
            this.proximolista = null;
            this.proximohash = null;
        }
    }

    private Vertice primeirovertice;
    private Vertice[] vertices;
    private int capacidade = 101;  // número primo
    private int quantidadeVertices;
    private int quantidadeArestas;

    /**
     * Construtor do grafo
     */
    public GrafoNaoDirecionadoNaoValorado() {
        vertices = new Vertice[capacidade];
    }

    /**
     * Adiciona uma aresta entre dois vértices
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     */
    public void adicionarAresta(int origem, int destino) {
        Vertice v1 = obtervertice(origem);
        Vertice v2 = obtervertice(destino);
        if (v1 != null && v2 != null) {
            if (!existearesta(v1, v2)) {
                inseriraresta(v1, v2);
                inseriraresta(v2, v1); // grafo não direcionado
                quantidadeArestas++;
            }
        } else {
            throw new NoSuchElementException("Vértice inexistente.");
        }
    }

    /**
     * Adiciona um vértice ao grafo
     * @param valor o valor do vértice a ser adicionado
     */
    public void adicionarVertice(int valor) {
        if (obtervertice(valor) == null) {
            Vertice novo = new Vertice(valor);
            novo.proximolista = primeirovertice;
            primeirovertice = novo;
            
            // insere na hash
            int indice = hash(valor);
            novo.proximohash = vertices[indice];
            vertices[indice] = novo;
            
            quantidadeVertices++;
        }
    }

    /**
     * Imprime o grafo em formato legível
     * @return String representando o grafo
     */
    public String imprimir() {
        StringBuilder strbuild = new StringBuilder();
        Vertice vertice = primeirovertice;
        while (vertice != null) {
            strbuild.append(vertice.valor).append(": ");
            Aresta aresta = vertice.primeiraaresta;
            while (aresta != null) {
                strbuild.append(aresta.destino.valor);
                if (aresta.proxima != null)
                    strbuild.append(", ");
                aresta = aresta.proxima;
            }
            strbuild.append("\n");
            vertice = vertice.proximolista;
        }
        return strbuild.toString();
    }

    /**
     * Remove uma aresta entre dois vértices
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     */
    public void removerAresta(int origem, int destino) {
        Vertice v1 = obtervertice(origem);
        Vertice v2 = obtervertice(destino);
        if (v1 != null && v2 != null) {
            if (removerarestaunidirecional(v1, v2))
                quantidadeArestas--;
            removerarestaunidirecional(v2, v1);
        } else {
            throw new NoSuchElementException("Vértice inexistente.");
        }
    }

    /**
     * Remove um vértice do grafo, junto com todas as arestas associadas
     * @param valor o valor do vértice a ser removido
     */
    public void removerVertice(int valor) {
        Vertice alvo = obtervertice(valor);
        if (alvo != null) {
            // remove todas as arestas que apontam para ele
            Vertice v = primeirovertice;
            while (v != null) {
                if (v != alvo)
                    removerarestaunidirecional(v, alvo);
                v = v.proximolista;
            }
            // remove o vértice da lista principal
            if (primeirovertice == alvo) {
                primeirovertice = alvo.proximolista;
            } else {
                Vertice anterior = primeirovertice;
                while (anterior != null && anterior.proximolista != alvo)
                    anterior = anterior.proximolista;
                if (anterior != null)
                    anterior.proximolista = alvo.proximolista;
            }
            // remove da tabela hash
            int indice = hash(valor);
            Vertice atual = vertices[indice];
            Vertice anteriorHash = null;
            while (atual != null) {
                if (atual == alvo) {
                    if (anteriorHash == null)
                        vertices[indice] = atual.proximohash;
                    else
                        anteriorHash.proximohash = atual.proximohash;
                    break;
                }
                anteriorHash = atual;
                atual = atual.proximohash;
            }
            quantidadeVertices--;
        } else {
            throw new NoSuchElementException("Vértice inexistente.");
        }
    }

    /**
     * Busca um vértice pelo seu valor
     * @param valor o valor do vértice a ser buscado
     * @return o vértice encontrado ou null se não existir
     */
    private Vertice obtervertice(int valor) {
        int indice = hash(valor);
        Vertice atual = vertices[indice];
        while (atual != null && atual.valor != valor)
            atual = atual.proximohash;
        return atual != null ? atual : null;
    }

    /**
     * Verifica se uma aresta já existe entre dois vértices
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @return true se a aresta existir, false caso contrário
     */
    private boolean existearesta(Vertice origem, Vertice destino) {
        Aresta atual = origem.primeiraaresta;
        while (atual != null && atual.destino != destino)
            atual = atual.proxima;
        return (atual != null);
    }

    /**
     * Função hash simples para mapear valores inteiros para índices na tabela
     * @param valor o valor do vértice
     * @return o índice na tabela hash
     */
    private int hash(int valor) {
        int valorabs = abs(valor);
        return valorabs % capacidade;
    }

    /**
     * Insere uma aresta unidirecional
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     */
    private void inseriraresta(Vertice origem, Vertice destino) {
        Aresta nova = new Aresta(destino);
        nova.proxima = origem.primeiraaresta;
        origem.primeiraaresta = nova;
    }
    
    /**
     * Remove uma aresta unidirecional
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @return true se a aresta foi removida, false se não existia
     */
    private boolean removerarestaunidirecional(Vertice origem, Vertice destino) {
        Aresta anterior = null;
        Aresta atual = origem.primeiraaresta;
        while (atual != null) {
            if (atual.destino == destino) {
                if (anterior == null)
                    origem.primeiraaresta = atual.proxima;
                else
                    anterior.proxima = atual.proxima;
                return true;
            }
            anterior = atual;
            atual = atual.proxima;
        }
        return false;
    }
    
    private boolean removerarestaunidirecional2(Vertice origem, Vertice destino) {
        Aresta anterior = null;
        Aresta atual = origem.primeiraaresta;
        while (atual != null && atual.destino != destino) {
            anterior = atual;
            atual = atual.proxima;
        }
        if (atual != null) {
            if (anterior == null) origem.primeiraaresta = atual.proxima;
            else anterior.proxima = atual.proxima;
        }
        return (atual != null);
    }
    
    public static void main(String[] args) {
        GrafoNaoDirecionadoNaoValorado g = new GrafoNaoDirecionadoNaoValorado();

        g.adicionarVertice(1);
        g.adicionarVertice(2);
        g.adicionarVertice(3);
        g.adicionarVertice(4);

        g.adicionarAresta(1, 2);
        g.adicionarAresta(1, 3);
        g.adicionarAresta(2, 4);

        System.out.println("Grafo inicial:");
        System.out.println(g.imprimir());

        g.removerAresta(1, 2);
        System.out.println("Após remover aresta 1-2:");
        System.out.println(g.imprimir());

        g.removerVertice(3);
        System.out.println("Após remover vértice 3:");
        System.out.println(g.imprimir());

        System.out.println("Vértices: " + g.quantidadeVertices);
        System.out.println("Arestas: " + g.quantidadeArestas);
    }
}
