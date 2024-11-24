/*Q9) 10)Write a Program to implement Dijkstra’s algorithm to find shortest
distance between two nodes of a user defined graph. Use Adjacency List
to represent a graph. */

import java.util.*;

class Edge {
    int dest;
    int weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
    public static void main(String[] args) {
        // Sample Input:
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
        //
        // Enter the starting vertex for Dijkstra's algorithm: 0
        // Enter the destination vertex: 3

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

    // Dijkstra's algorithm to find the shortest distance from source to destination
    public void dijkstra(int startVertex, int endVertex) {
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(startVertex, 0));

        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.dest;

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            for (Edge edge : adjacencyList.get(currentVertex)) {
                if (!visited[edge.dest]) {
                    int newDist = distances[currentVertex] + edge.weight;
                    if (newDist < distances[edge.dest]) {
                        distances[edge.dest] = newDist;
                        pq.add(new Edge(edge.dest, newDist));
                    }
                }
            }
        }

        System.out.println("Shortest distance from vertex " + startVertex + " to vertex " + endVertex + " is: " + distances[endVertex]);
    }

    // public static void main(String[] args) {
    //     // Sample Input:
    //     // Enter the number of vertices: 5
    //     // Enter edges in the format 'src dest weight' (enter -1 -1 -1 to stop):
    //     // 0 1 10
    //     // 0 2 3
    //     // 1 2 1
    //     // 1 3 2
    //     // 2 1 4
    //     // 2 3 8
    //     // 2 4 2
    //     // 3 4 7
    //     // -1 -1 -1
    //     //
    //     // Enter the starting vertex for Dijkstra's algorithm: 0
    //     // Enter the destination vertex: 3

    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Enter the number of vertices: ");
    //     int numVertices = scanner.nextInt();

    //     Graph graph = new Graph(numVertices);

    //     System.out.println("Enter edges in the format 'src dest weight' (enter -1 -1 -1 to stop):");
        
    //     while (true) {
    //         int src = scanner.nextInt();
    //         int dest = scanner.nextInt();
    //         int weight = scanner.nextInt();
            
    //         if (src == -1 && dest == -1 && weight == -1) break;

    //         graph.addEdge(src, dest, weight);
    //     }

    //     System.out.print("Enter the starting vertex for Dijkstra's algorithm: ");
    //     int startVertex = scanner.nextInt();
        
    //     System.out.print("Enter the destination vertex: ");
    //     int endVertex = scanner.nextInt();

    //     graph.dijkstra(startVertex, endVertex);

    //     scanner.close();
    // }
}