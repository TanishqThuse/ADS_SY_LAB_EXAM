import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Edge>[] adjacencyList; // Adjacency list to store graph

    static class Edge {
        int target; // Target vertex
        int weight; // Weight of the edge

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int target, int weight) {
        adjacencyList[source].add(new Edge(target, weight));
        adjacencyList[target].add(new Edge(source, weight)); // If the graph is undirected
    }

    public int dijkstra(int source, int destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;

            for (Edge edge : adjacencyList[currentVertex]) {
                int neighbor = edge.target;
                int newDist = distances[currentVertex] + edge.weight;

                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    pq.add(new Node(neighbor, newDist));
                }
            }
        }

        return distances[destination];
    }

    static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of vertices and edges
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        Graph graph = new Graph(vertices);

        System.out.println("Enter the number of edges: ");
        int edges = sc.nextInt();

        // Input: Graph edges
        System.out.println("Enter the edges (source, target, weight): ");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int target = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(source, target, weight);
        }

        // Input: Source and destination
        System.out.println("Enter the source vertex: ");
        int source = sc.nextInt();
        System.out.println("Enter the destination vertex: ");
        int destination = sc.nextInt();

        // Calculate shortest distance
        int shortestDistance = graph.dijkstra(source, destination);

        System.out.println("The shortest distance from vertex " + source + " to vertex " + destination + " is: " + shortestDistance);
    }
}
