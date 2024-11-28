import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FordFulkerson {
    static int V; // Number of vertices in the graph

    // BFS function to check if there's an augmenting path
    boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        // Mark all vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i) {
            visited[i] = false;
        }

        // Create a queue, enqueue source vertex, and mark it as visited
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS loop
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                // If vertex is not visited and there's a residual capacity
                if (!visited[v] && rGraph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true; // Found a path to the sink
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false; // No augmenting path found
    }

    // Ford-Fulkerson function to calculate the maximum flow
    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;

        // Create a residual graph and fill it with initial capacities
        int rGraph[][] = new int[V][V];
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        // This array will store the augmenting path
        int parent[] = new int[V];

        int maxFlow = 0; // Initial maximum flow

        // Augment the flow while there is a path from source to sink
        while (bfs(rGraph, s, t, parent)) {
            // Find the maximum flow through the path found by BFS
            int pathFlow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            // Update residual capacities of the edges and reverse edges
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            // Add path flow to the overall flow
            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        V = scanner.nextInt();

        // Create an adjacency matrix for the graph
        int graph[][] = new int[V][V];

        // Input the graph's adjacency matrix
        System.out.println("Enter the adjacency matrix (capacity of each edge): ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Input source and sink vertices
        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        System.out.print("Enter the sink vertex: ");
        int sink = scanner.nextInt();

        FordFulkerson m = new FordFulkerson();
        System.out.println("The maximum possible flow is " +
                           m.fordFulkerson(graph, source, sink)); // Calculate max flow

        scanner.close();
    }
}
