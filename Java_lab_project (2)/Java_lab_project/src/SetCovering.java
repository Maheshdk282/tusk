import java.util.*;

public class SetCovering {

    // Function to find the set cover using a greedy approach
    static Set<Integer> findSetCover(Set<Integer> universe, List<Set<Integer>> subsets) {
        // To store the selected sets for the final solution
        Set<Integer> selectedSets = new HashSet<>();
        // To keep track of covered elements
        Set<Integer> covered = new HashSet<>();

        // Loop until the entire universe is covered
        while (!covered.containsAll(universe)) {
            // Find the subset that covers the maximum number of uncovered elements
            Set<Integer> bestSubset = null;
            int maxCovered = 0;
            for (Set<Integer> subset : subsets) {
                Set<Integer> temp = new HashSet<>(subset);
                temp.removeAll(covered); // Uncovered elements in this subset

                if (temp.size() > maxCovered) {
                    bestSubset = subset;
                    maxCovered = temp.size();
                }
            }

            // Add the best subset to the solution and update the covered elements
            if (bestSubset != null) {
                selectedSets.addAll(bestSubset);
                covered.addAll(bestSubset);
            }
        }

        return selectedSets;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the universe
        System.out.println("Enter the number of elements in the universe: ");
        int n = scanner.nextInt();
        Set<Integer> universe = new HashSet<>();
        System.out.println("Enter the elements of the universe: ");
        for (int i = 0; i < n; i++) {
            universe.add(scanner.nextInt());
        }

        // Input for the number of subsets
        System.out.println("Enter the number of subsets: ");
        int m = scanner.nextInt();
        List<Set<Integer>> subsets = new ArrayList<>();

        // Input for the subsets
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the number of elements in subset " + (i + 1) + ": ");
            int subsetSize = scanner.nextInt();
            Set<Integer> subset = new HashSet<>();
            System.out.println("Enter the elements of subset " + (i + 1) + ": ");
            for (int j = 0; j < subsetSize; j++) {
                subset.add(scanner.nextInt());
            }
            subsets.add(subset);
        }

        // Call the function to find the set cover
        Set<Integer> result = findSetCover(universe, subsets);

        // Print the result
        System.out.println("Set cover is: " + result);

        scanner.close();
    }
}
