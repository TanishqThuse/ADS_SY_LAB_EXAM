/**Q9) 7)Write a Program to implement Dijkstra’s algorithm to find shortest
distance between two nodes of a user defined graph. Use Adjacency
Matrix to represent a graph. */

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

    // Dijkstra's algorithm to find the shortest distance from source to destination
    public void dijkstra(int startVertex, int endVertex) {
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = selectMinVertex(distances, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != Integer.MAX_VALUE) {
                    int newDist = distances[u] + adjacencyMatrix[u][v];
                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                    }
                }
            }
        }

        System.out.println("Shortest distance from vertex " + startVertex + " to vertex " + endVertex + " is: " + distances[endVertex]);
    }

    // Helper method to select the vertex with the minimum distance value
    private int selectMinVertex(int[] distances, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && (minVertex == -1 || distances[i] < distances[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
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

        System.out.print("Enter the starting vertex for Dijkstra's algorithm: ");
        int startVertex = scanner.nextInt();
        
        System.out.print("Enter the destination vertex: ");
        int endVertex = scanner.nextInt();

        graph.dijkstra(startVertex, endVertex);

        scanner.close();
    }
}
// Input example for testing:
// Enter the number of vertices: 5
// Enter edges in the format 'src dest weight' (enter -1 -1 -1 to stop):
// 0 1 10
// 0 2 3
// 1 2 1
// 1 3 2
// 2 1 4
// 2 3 8
// 2 4 2
// 3 4 7
// -1 -1 -1
// Enter the starting vertex for Dijkstra's algorithm: 0
// Enter the destination vertex: 3