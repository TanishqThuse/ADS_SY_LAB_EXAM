import java.util.*;

public class GraphTraversal {

    // Function to perform BFS traversal
    public static void bfs(int[][] graph, int start) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        
        // Start from the 'start' node
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            // Explore all adjacent vertices
            for (int i = 0; i < numVertices; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // Function to perform DFS traversal
    public static void dfs(int[][] graph, int vertex, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        // Recur for all the vertices adjacent to this vertex
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    // Function to accept a graph from the user and represent it as an adjacency matrix
    public static int[][] createGraph(int numVertices, int numEdges) {
        int[][] graph = new int[numVertices][numVertices];
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the edges (pair of vertices, 0-based index):");
        for (int i = 0; i < numEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;  // Since the graph is undirected
        }
        return graph;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Accept number of vertices and edges
        System.out.print("Enter number of vertices: ");
        int numVertices = sc.nextInt();
        
        System.out.print("Enter number of edges: ");
        int numEdges = sc.nextInt();
        
        // Create the graph
        int[][] graph = createGraph(numVertices, numEdges);
        
        // Display the adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        
        // BFS and DFS Traversal
        System.out.print("\nBFS traversal starting from vertex 0: ");
        bfs(graph, 0);
        
        System.out.println("\nDFS traversal starting from vertex 0: ");
        boolean[] visited = new boolean[numVertices];
        dfs(graph, 0, visited);
    }
}
