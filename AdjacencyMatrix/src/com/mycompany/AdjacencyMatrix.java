package com.mycompany;

import java.util.*;

/**
 *
 * @author joaovb
 */
public class AdjacencyMatrix {
    
    private boolean[][] matrix;

    private int n_vertices;

    public AdjacencyMatrix(int num){
        this.n_vertices = num;
        matrix = new boolean[num][num];
    }
    
    public void putEdge(int i, int j){
        matrix[i][j]=true;
        matrix[j][i]=true;
    }
    
    public void deleteEdge(int i, int j) {
        matrix[i][j]=false;
        matrix[j][i]=false;
    }
    
    public boolean checkIfExist(int i, int j){
        return matrix[i][j];
    }
    
    public List<Integer> listNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < n_vertices; i++) {
            if (matrix[v][i]) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
    
    public boolean areAdjacent(int u, int v) {
        return matrix[u][v];
    }
    
    public void print(){
    	for (int i = 0; i < n_vertices; i++) {
            for (int j = 0; j < n_vertices; j++) {
            	char value = matrix[i][j] ? '1' : '0';
                System.out.print(value + "\t");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(5);

        System.out.println("Matriz de Adjacência:");
        matrix.print();
        
        matrix.putEdge(0, 1);
        matrix.putEdge(0, 2);
        matrix.putEdge(1, 3);
        matrix.putEdge(2, 4);
        matrix.putEdge(3, 4);
        
        System.out.println("Matriz de Adjacência:");
        matrix.print();

        System.out.println("\nVizinhos do vértice 0: " + matrix.listNeighbors(0));
        System.out.println("Vizinhos do vértice 4: " + matrix.listNeighbors(4));

        System.out.println("\nVerificando se os vértices 1 e 3 são adjacentes: " + matrix.areAdjacent(1, 3));

        matrix.deleteEdge(1, 3);
        System.out.println("\nApós remover a aresta entre 1 e 3:");
        
        matrix.print();
    }
}


