import java.util.*;

public class MaxBipartiteMatching {

    private int maxMatch; // Count of maximum matching
    private int[] match; // Array to store matched vertex
    private boolean[] visited; // Visited array for DFS
    private List<List<Integer>> adj; // Adjacency list for graph

    // Constructor
    public MaxBipartiteMatching(int vertices) {
        match = new int[vertices];
        Arrays.fill(match, -1); // Initialize all matches as -1 (no match)
        visited = new boolean[vertices];
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        maxMatch = 0; // Initialize maxMatch
    }

    // Function to add edges to the bipartite graph
    public void addEdge(int u, int v) {
        adj.get(u).add(v); // Add edge from u to v
    }

    // DFS function to find a matching for vertex u
    private boolean dfs(int u) {
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                visited[v] = true; // Mark v as visited
                // If v is not matched or previously matched vertex can find alternate match
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u; // Match u with v
                    return true;
                }
            }
        }
        return false;
    }

    // Function to find maximum matching
    public int findMaxMatching() {
        for (int u = 0; u < adj.size(); u++) {
            Arrays.fill(visited, false); // Reset visited for each u
            if (dfs(u)) {
                maxMatch++;
            }
        }
        return maxMatch; // Return the maximum match count
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the number of vertices in the left set
        System.out.println("Enter the number of vertices in the left set: ");
        int leftSetSize = scanner.nextInt();

        // Input for the number of vertices in the right set
        System.out.println("Enter the number of vertices in the right set: ");
        int rightSetSize = scanner.nextInt();

        MaxBipartiteMatching bpm = new MaxBipartiteMatching(leftSetSize + rightSetSize);

        // Input the number of edges
        System.out.println("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Input the edges between left set and right set
        System.out.println("Enter the edges (left vertex, right vertex): ");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            bpm.addEdge(u, v + leftSetSize); // Adjust the right set index by offsetting with leftSetSize
        }

        // Find and print the maximum matching
        
        int maxMatching = bpm.findMaxMatching();
        System.out.println("Maximum Bipartite Matching is: " + maxMatching);

        scanner.close();
    }
}

// OUTPUT
//Enter the number of vertices in the left set: 
// 4
// Enter the number of vertices in the right set: 
// 4
// Enter the number of edges: 
// 7
// Enter the edges (left vertex, right vertex): 
// 0 0
// 0 1
// 1 0
// 1 2
// 2 1
// 3 2
// 3 3
// Maximum Bipartite Matching is: 4