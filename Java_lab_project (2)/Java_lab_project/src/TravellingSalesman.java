import java.util.Arrays;
import java.util.Scanner;

public class TravellingSalesman {

    // A large value to represent infinity (for cities that can't be directly connected)
    private static final int INF = 9999999;

    // Method to find the minimum path using permutation (brute force)
    private static int tsp(int[][] distance, int N) {
        int[] cities = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            cities[i] = i + 1;
        }

        int minPathCost = INF;
        do {
            int currentCost = 0;
            int k = 0;  // start from the 0th city
            for (int i = 0; i < cities.length; i++) {
                currentCost += distance[k][cities[i]];
                k = cities[i];
            }
            currentCost += distance[k][0];  // return to the start city
            minPathCost = Math.min(minPathCost, currentCost);
        } while (nextPermutation(cities));

        return minPathCost;
    }

    // Helper function to generate the next permutation
    private static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) i--;
        if (i <= 0) return false;
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) j--;
        swap(array, i - 1, j);
        j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
        return true;
    }

    // Helper function to swap elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of cities
        System.out.print("Enter the number of cities: ");
        int N = scanner.nextInt();

        // Input the distance matrix
        int[][] distance = new int[N][N];
        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = scanner.nextInt();
            }
        }

        // Calculate and print the minimum cost
        System.out.println("Minimum cost: " + tsp(distance, N));

        scanner.close();
    }
}
