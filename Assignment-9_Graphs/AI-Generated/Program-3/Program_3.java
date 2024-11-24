/**Q9) 3)Write a Program to implement Kruskal’s algorithm to find minimum
spanning tree of a user defined graph. Use Adjacency List to represent a
graph. */

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight; // Compare edges by weight
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

        System.out.println("\nMinimum Spanning Tree using Kruskal's Algorithm:");
        graph.kruskalMST();

        scanner.close();
    }
}

class Graph {
    private List<Edge> edges; // List of edges in the graph
    private int vertices; // Number of vertices

    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Find function for Union-Find
    private int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    // Union function for Union-Find
    private void union(int[] parent, int x, int y) {
        parent[x] = y;
    }

    // Kruskal's algorithm to find the MST
    public void kruskalMST() {
        Collections.sort(edges); // Sort edges based on weight

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1); // Initialize parent array

        List<Edge> mstEdges = new ArrayList<>(); // To store the resulting MST

        for (Edge edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            // If x and y are not in the same set, include this edge in the MST
            if (x != y) {
                mstEdges.add(edge);
                union(parent, x, y);
            }
        }

        printMST(mstEdges);
    }

    // Method to print the constructed MST
    private void printMST(List<Edge> mstEdges) {
        System.out.println("Edge \tWeight");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + "\t" + edge.weight);
        }
    }
}

// public class Program_3 {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the number of vertices: ");
//         int numVertices = scanner.nextInt();

//         Graph graph = new Graph(numVertices);

//         System.out.println("Enter edges in the format 'src dest weight' (enter -1 -1 -1 to stop):");
        
//         while (true) {
//             int src = scanner.nextInt();
//             int dest = scanner.nextInt();
//             int weight = scanner.nextInt();
            
//             if (src == -1 && dest == -1 && weight == -1) break;

//             graph.addEdge(src, dest, weight);
//         }

//         System.out.println("\nMinimum Spanning Tree using Kruskal's Algorithm:");
//         graph.kruskalMST();

//         scanner.close();
//     }
// }

// Enter the number of vertices: 4
// Enter edges in the format 'src dest weight' (enter -1 -1 -1 to stop):
// 0 1 10
// 0 2 6
// 0 3 5
// 1 3 15
// 2 3 4
// -1 -1 -1