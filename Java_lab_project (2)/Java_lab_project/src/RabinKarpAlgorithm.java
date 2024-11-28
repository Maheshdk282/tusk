import java.util.Scanner;

public class RabinKarpAlgorithm {

    // d is the number of characters in the input alphabet (for simplicity, we use d = 256)
    public final static int d = 256;

    // Function to perform Rabin-Karp pattern matching
    static void search(String pattern, String text, int q) {
        int M = pattern.length(); // Length of the pattern
        int N = text.length(); // Length of the text
        int i, j;
        int p = 0; // Hash value for the pattern
        int t = 0; // Hash value for the text
        int h = 1;

        // h = (d^(M-1)) % q
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of the pattern and the first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            // If the hash values of current window of text and pattern match
            if (p == t) {
                // Check for characters one by one
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                // If p == t and pattern[0...M-1] == text[i...i+M-1], pattern is found
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;

                // We might get a negative value of t, converting it to positive
                if (t < 0) {
                    t = (t + q);
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

        // Input the prime number for hashing
        System.out.print("Enter a prime number for hashing: ");
        int q = scanner.nextInt();

        System.out.println("\nText: " + text);
        System.out.println("Pattern: " + pattern);

        // Perform the search
        search(pattern, text, q);

        scanner.close();
    }
}
