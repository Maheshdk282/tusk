import java.util.Scanner;

public class NQueenProblem {

    private int N; // Number of queens (N x N chessboard)

    // Constructor to set the value of N dynamically
    public NQueenProblem(int N) {
        this.N = N;
    }

    /* A utility function to print the solution */
    void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* A utility function to check if a queen can be placed on board[row][col] */
    boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    /* A recursive utility function to solve N-Queen problem */
    boolean solveNQUtil(int[][] board, int col) {
        // Base case: If all queens are placed, return true
        if (col >= N) return true;

        // Try placing a queen in all rows one by one for the current column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                // Place the queen
                board[i][col] = 1;

                // Recur to place the rest of the queens
                if (solveNQUtil(board, col + 1)) return true;

                // If placing queen doesn't lead to a solution, backtrack
                board[i][col] = 0; // BACKTRACK
            }
        }

        // If the queen can't be placed in any row in this column, return false
        return false;
    }

    /* This function solves the N-Queen problem using backtracking */
    boolean solveNQ() {
        int[][] board = new int[N][N]; // Dynamic board size based on N

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Get the size of the board (N)
        System.out.print("Enter the size of the board (N): ");
        int N = scanner.nextInt();

        // Create an instance of NQueenProblem with the specified size
        NQueenProblem Queen = new NQueenProblem(N);
        Queen.solveNQ();

        scanner.close();
    }
}
