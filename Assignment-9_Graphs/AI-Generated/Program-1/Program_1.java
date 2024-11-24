/**Q9) 1)Write a Program to accept a graph from user and represent it with
Adjacency Matrix and perform BFS and DFS traversals on it. */

import java.util.LinkedList;
import java.util.Scanner;

public class Program_1 {
    private int V; // Number of vertices
    private int[][] adjMatrix; // Adjacency matrix

    // Constructor to initialize the graph
    public Program_1(int v) {
        this.V = v;
        adjMatrix = new int[v][v];
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1; // For directed graph
        adjMatrix[dest][src] = 1; // Uncomment for undirected graph
    }

    // BFS traversal
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < V; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    // DFS traversal
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS Traversal: ");
        DFSUtil(startVertex, visited);
        System.out.println();
    }

    // Utility method for DFS
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < V; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Program_1 graph = new Program_1(numVertices);

        System.out.println("Enter edges in the format 'src dest' (enter -1 -1 to stop):");
        
        while (true) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            
            if (src == -1 && dest == -1) break;

            graph.addEdge(src, dest);
        }

        System.out.print("Enter starting vertex for BFS: ");
        int startBFS = scanner.nextInt();
        graph.BFS(startBFS);

        System.out.print("Enter starting vertex for DFS: ");
        int startDFS = scanner.nextInt();
        graph.DFS(startDFS);

        scanner.close();
    }
}

/**Enter the number of vertices: 5
Enter edges in the format 'src dest' (enter -1 -1 to stop):
0 1
0 2
1 3
1 4
2 4
-1 -1
Enter starting vertex for BFS: 0
BFS Traversal: 0 1 2 3 4 
Enter starting vertex for DFS: 0
DFS Traversal: 0 1 3 4 2  */