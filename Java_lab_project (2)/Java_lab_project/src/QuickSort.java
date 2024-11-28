import java.util.Scanner;

public class QuickSort {

    // Function to perform Quick Sort
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose the rightmost element as pivot
        int i = low - 1;        // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and the pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // Return the partition index
    }

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // Partition the array

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Utility function to print the array
    static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    // Driver program to test Quick Sort
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Input for array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create a QuickSort object and perform the sort
        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
