/*Q9) 11)Write a Program to implement Prim’s algorithm to find minimum
spanning tree of a user defined graph. Use Adjacency Matrix to
represent a graph. */

import java.util.*;

class Graph {
    private int[][] adjacencyMatrix; // Adjacency matrix representation
    private int vertices; // Number of vertices

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];

        // Initialize the adjacency matrix with infinity (or a large number)
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight; // For directed graph
        adjacencyMatrix[dest][src] = weight; // Uncomment for undirected graph
    }

    // Prim's algorithm to find the MST
    public void primMST() {
        boolean[] inMST = new boolean[vertices]; // Track vertices included in MST
        int[] key = new int[vertices]; // Minimum weight edge for each vertex
        int[] parent = new int[vertices]; // Store the resulting MST

        // Initialize keys as infinite and parent as -1
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Start from the first vertex
        key[0] = 0; // Starting vertex

        for (int count = 0; count < vertices - 1; count++) {
            int u = selectMinVertex(key, inMST);
            inMST[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (adjacencyMatrix[u][v] != Integer.MAX_VALUE && !inMST[v] && adjacencyMatrix[u][v] < key[v]) {
                    key[v] = adjacencyMatrix[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST(parent);
    }

    // Helper method to select the vertex with the minimum key value
    private int selectMinVertex(int[] key, boolean[] inMST) {
        int minVertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (!inMST[i] && (minVertex == -1 || key[i] < key[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    // Method to print the constructed MST
    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + adjacencyMatrix[parent[i]][i]);
        }
    }

    public static void main(String[] args) {
        // Sample Input:
        // Enter the number of vertices: 5
        // Enter edges in the format 'src dest weight' (enter -1 -1 -1 to stop):
        // 0 1 10
        // 0 2 6
        // 0 3 5
        // 1 3 15
        // 2 3 4
        // 2 4 2
        // 3 4 7
        // -1 -1 -1

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Graph graph = new Graph(numVertices);

        System.out.println("Enter edges in the format 'src dest weight' (enter -1 -1 -1 to stop):");
        
        while (true) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            
            if (src == -1 && dest == -1 && weight == -1) break;

            graph.addEdge(src, dest, weight);
        }

        System.out.println("\nMinimum Spanning Tree using Prim's Algorithm:");
        graph.primMST();

        scanner.close();
    }
}