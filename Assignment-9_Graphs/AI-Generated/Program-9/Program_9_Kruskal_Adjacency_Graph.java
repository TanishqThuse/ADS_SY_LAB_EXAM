/*Q9) 9)Write a Program to implement Kruskal’s algorithm to find minimum
spanning tree of a user defined graph. Use Adjacency List to represent a
graph. */

import java.util.*;

class Edge {
    int dest;
    int weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
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

        System.out.println("\nMinimum Spanning Tree using Prim's Algorithm:");
        graph.primMST();

        scanner.close();
    }
}

class Graph {
    private List<List<Edge>> adjacencyList; // Adjacency list representation
    private int vertices; // Number of vertices

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        adjacencyList.get(src).add(new Edge(dest, weight));
        adjacencyList.get(dest).add(new Edge(src, weight)); // For undirected graph
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
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(0, 0)); // Add starting vertex to priority queue

        while (!pq.isEmpty()) {
            int u = pq.poll().dest; // Get the vertex with the minimum key value
            inMST[u] = true; // Include this vertex in MST

            // Iterate through all adjacent vertices of u
            for (Edge edge : adjacencyList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                // If v is not in MST and weight of edge u-v is smaller than current key value of v
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight; // Update key value
                    parent[v] = u;   // Update parent to u
                    pq.add(new Edge(v, key[v])); // Add v to priority queue
                }
            }
        }

        printMST(parent);
    }

    // Method to print the constructed MST
    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + getEdgeWeight(parent[i], i));
        }
    }

    // Helper method to get the weight of an edge
    private int getEdgeWeight(int src, int dest) {
        for (Edge edge : adjacencyList.get(src)) {
            if (edge.dest == dest) {
                return edge.weight;
            }
        }
        return 0; // Should not reach here if edges are correctly defined
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

        System.out.println("\nMinimum Spanning Tree using Prim's Algorithm:");
        graph.primMST();

        scanner.close();
    }
}

// Input example for testing:
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