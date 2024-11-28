import java.util.Arrays;
import java.util.Scanner;

class Edge {
    int source, destination, weight;

    Edge(int s, int d, int w) {
        source = s;
        destination = d;
        weight = w;
    }
}

public class BellmanFord {
    private int vertices;
    private Edge[] edges;

    // Constructor to initialize the number of vertices and edges
    public BellmanFord(int v, int e) {
        vertices = v;
        edges = new Edge[e];
    }

    // Method to add an edge to the graph
    public void addEdge(int index, int s, int d, int w) {
        edges[index] = new Edge(s, d, w);
    }

    // Bellman-Ford algorithm implementation
    public void bellmanFord(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax edges |V| - 1 times
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printSolution(distance);
    }

    // Method to print the shortest distances from the source
    private void printSolution(int[] distance) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    // Driver program to test the Bellman-Ford algorithm dynamically
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        BellmanFord graph = new BellmanFord(vertices, edges);

        // Input: Edges (source, destination, weight)
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter edge " + (i + 1) + " (source, destination, weight): ");
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(i, source, destination, weight);
        }

        // Input: Starting vertex
        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        // Run Bellman-Ford algorithm
        graph.bellmanFord(source);

        scanner.close();
    }
}
