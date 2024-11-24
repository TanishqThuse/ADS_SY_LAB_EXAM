import java.util.*;

public class PrimsAlgorithm {

    // Function to implement Prim's algorithm to find MST
    public static void primMST(int[][] graph, int numVertices) {
        // Array to store the minimum weight edge for each vertex
        int[] parent = new int[numVertices];
        // Array to store the minimum weight edge that connects a vertex to the MST
        int[] key = new int[numVertices];
        // Boolean array to track vertices that are included in MST
        boolean[] mstSet = new boolean[numVertices];

        // Initialize key values to infinity and mstSet[] to false
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        // Starting from vertex 0
        key[0] = 0;
        parent[0] = -1; // First node has no parent

        // Loop to find the MST
        for (int count = 0; count < numVertices - 1; count++) {
            // Get the vertex with the minimum key value from the set of vertices not yet included in MST
            int u = minKey(key, mstSet, numVertices);

            // Include the vertex in MST
            mstSet[u] = true;

            // Update key value and parent index of the adjacent vertices
            for (int v = 0; v < numVertices; v++) {
                // graph[u][v] != 0 ensures there's an edge between u and v, and v is not included in MST
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph, numVertices);
    }

    // A utility function to find the vertex with the minimum key value
    public static int minKey(int[] key, boolean[] mstSet, int numVertices) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to print the constructed MST
    public static void printMST(int[] parent, int[][] graph, int numVertices) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < numVertices; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }

    // Function to accept a graph from the user and represent it as an adjacency matrix
    public static int[][] createGraph(int numVertices, int numEdges) {
        int[][] graph = new int[numVertices][numVertices];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the edges (vertex1 vertex2 weight):");
        for (int i = 0; i < numEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            graph[u][v] = weight;
            graph[v][u] = weight;  // For undirected graph
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

        // Apply Prim's Algorithm to find MST
        System.out.println("\nMinimum Spanning Tree (MST):");
        primMST(graph, numVertices);
    }
}
