// Q9) 5)Write a Program to accept a graph from user and represent it with
// Adjacency List and perform BFS and DFS traversals on it.
//Actually this is the first one which is I found doable as of now but anyways imma improve

import java.util.*;

class Graph {
    private List<List<Integer>> adjacencyList; // Adjacency list representation
    private int vertices; // Number of vertices

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest) {
        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src); // For undirected graph
    }

    // BFS traversal
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS traversal
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        DFSUtil(startVertex, visited);
        System.out.println();
    }

    // Utility method for DFS
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Graph graph = new Graph(numVertices);

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

/*Enter the number of vertices: 5
Enter edges in the format 'src dest' (enter -1 -1 to stop):
0 1
0 2
1 3
1 4
2 4
-1 -1
Enter starting vertex for BFS: 0
Enter starting vertex for DFS: 0 */