import java.util.Scanner;

public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC9 (Recursive Method)";

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("        Welcome to " + APP_NAME);
        System.out.println("        " + APP_VERSION);
        System.out.println("=================================================");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeRecursive(input, 0, input.length() - 1);

        if (result) {
            System.out.println("Result: The entered string IS a Palindrome.");
        } else {
            System.out.println("Result: The entered string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Recursive Palindrome Logic
    private static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base Condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If mismatch found
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call (smaller subproblem)
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}