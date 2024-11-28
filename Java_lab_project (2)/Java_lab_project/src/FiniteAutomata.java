import java.util.Scanner;

public class FiniteAutomata {

    static final int NO_OF_CHARS = 256; // Number of possible characters (ASCII)

    // Function to build the transition table
    static void buildTransitionTable(String pattern, int M, int[][] TF) {
        int i, lps = 0;

        // Fill the first row of the table
        for (int x = 0; x < NO_OF_CHARS; x++) {
            TF[0][x] = 0; // No match initially
        }
        TF[0][pattern.charAt(0)] = 1;

        // Build the rest of the transition table
        for (i = 1; i <= M; i++) {
            for (int x = 0; x < NO_OF_CHARS; x++) {
                TF[i][x] = TF[lps][x]; // Copy the mismatch entries from the LPS
            }
            if (i < M) {
                TF[i][pattern.charAt(i)] = i + 1; // Update the match entry
                lps = TF[lps][pattern.charAt(i)]; // Update the LPS for next row
            }
        }
    }

    // Function to search the pattern in text using FA
    static void search(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();

        int[][] TF = new int[M + 1][NO_OF_CHARS]; // Create the transition table

        // Build the transition table for the given pattern
        buildTransitionTable(pattern, M, TF);

        // Process the text through the finite automaton
        int state = 0;
        for (int i = 0; i < N; i++) {
            state = TF[state][text.charAt(i)];
            if (state == M) {
                System.out.println("Pattern found at index " + (i - M + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the text
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        // Input the pattern to search for
        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        search(pattern, text);

        scanner.close();
    }
}
