import java.util.Scanner;

public class KMPAlgorithm {

    // KMP search function to find pattern in text
    void KMPSearch(String pattern, String text) {
        int M = pattern.length(); // Length of pattern
        int N = text.length(); // Length of text

        // Create LPS array to store longest prefix suffix values for pattern
        int[] lps = new int[M];
        int j = 0; // Index for pattern[]

        // Preprocess the pattern to calculate LPS array
        computeLPSArray(pattern, M, lps);

        int i = 0; // Index for text[]
        while (i < N) {
            // If characters match, move both pointers (i and j)
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }

            // If we find a complete match
            if (j == M) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // Reset j using LPS array for next possible match
            }
            // Mismatch after j matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                // If j is not 0, use the LPS array to avoid redundant checks
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++; // Move to next character in text
                }
            }
        }
    }

    // Preprocess the pattern and create LPS array
    void computeLPSArray(String pattern, int M, int[] lps) {
        int length = 0; // Length of previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // LPS for first character is always 0

        // Loop to fill LPS array
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // If mismatch after some matches
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
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

        KMPAlgorithm kmp = new KMPAlgorithm();
        kmp.KMPSearch(pattern, text);

        scanner.close();
    }
}
