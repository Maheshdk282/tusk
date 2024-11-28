import java.util.*;

class ShortestPathInDAG {
    static class Edge {
        int destination, weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Function to perform topological sort using DFS
    static void topologicalSort(int v, boolean[] visited, Stack<Integer> stack, List<List<Edge>> graph) {
        visited[v] = true;

        // Traverse all adjacent vertices
        for (Edge edge : graph.get(v)) {
            if (!visited[edge.destination]) {
                topologicalSort(edge.destination, visited, stack, graph);
            }
        }

        // Push current vertex to stack after visiting all its adjacent vertices
        stack.push(v);
    }

    // Function to find the shortest path in a DAG
    static void shortestPath(List<List<Edge>> graph, int source, int vertices) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        // Perform topological sort
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, graph);
            }
        }

        // Initialize distances to all vertices as infinity, except the source
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();

            // If the vertex has been reached, update the distances of its neighbors
            if (distance[u] != Integer.MAX_VALUE) {
                for (Edge edge : graph.get(u)) {
                    if (distance[u] + edge.weight < distance[edge.destination]) {
                        distance[edge.destination] = distance[u] + edge.weight;
                    }
                }
            }
        }

        // Print the shortest distances
        for (int i = 0; i < vertices; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " is unreachable from source " + source);
            } else {
                System.out.println("Shortest distance to vertex " + i + " is " + distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        // Create a graph as an adjacency list representation
        List<List<Edge>> graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Input the number of edges
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        // Input edge details: source, destination, weight
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter edge " + (i + 1) + " (source, destination, weight): ");
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.get(source).add(new Edge(destination, weight));
        }

        // Input the source vertex
        System.out.print("Enter the source vertex: ");
        int sourceVertex = scanner.nextInt();

        // Find and print shortest paths from the source vertex
        System.out.println("Shortest paths from source " + sourceVertex + ":");
        shortestPath(graph, sourceVertex, vertices);

        scanner.close();
    }
}
