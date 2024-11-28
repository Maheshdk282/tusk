import java.util.*;

class VertexCover {

    // Function to find the vertex cover using a greedy algorithm
    static void findVertexCover(List<int[]> edges, int V) {
        // Array to mark visited vertices
        boolean[] visited = new boolean[V];

        // Traverse all edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If both vertices are not yet visited, add them to vertex cover
            if (!visited[u] && !visited[v]) {
                visited[u] = true;
                visited[v] = true;
                System.out.println("Including edge: (" + u + ", " + v + ")");
            }
        }

        // Print the vertex cover
        System.out.print("Vertex Cover: ");
        for (int i = 0; i < V; i++) {
            if (visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        // Input number of edges
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        // List of edges
        List<int[]> edges = new ArrayList<>();

        // Input each edge
        System.out.println("Enter the edges (as pairs of vertices, 0-indexed):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }

        // Call function to find the vertex cover
        findVertexCover(edges, V);

        scanner.close();
    }
}
