import java.util.Scanner;

public class SubsetSum {

    // Function to check if there exists a subset with the given sum
    static boolean isSubsetSum(int[] set, int n, int sum) {
        // Create a DP table
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, we can always have an empty subset to achieve it
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // If set is empty and sum is not 0, we cannot form any subset
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // Exclude the current element
                dp[i][j] = dp[i - 1][j];

                // Include the current element (if it's not greater than j)
                if (set[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp[n][sum]; // The value at dp[n][sum] will be our answer
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of elements in the set
        System.out.println("Enter the number of elements in the set: ");
        int n = scanner.nextInt();

        // Input the set elements
        int[] set = new int[n];
        System.out.println("Enter the elements of the set: ");
        for (int i = 0; i < n; i++) {
            set[i] = scanner.nextInt();
        }

        // Input the sum to check for
        System.out.println("Enter the sum to check: ");
        int sum = scanner.nextInt();

        // Call the function to check for the subset sum
        if (isSubsetSum(set, n, sum)) {
            System.out.println("Subset with the given sum exists.");
        } else {
            System.out.println("No subset with the given sum exists.");
        }

        scanner.close();
    }
}
