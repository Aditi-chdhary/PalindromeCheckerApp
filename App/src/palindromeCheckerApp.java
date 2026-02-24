import java.util.Scanner;

public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC11 (OOP Palindrome Service)";

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("        Welcome to " + APP_NAME);
        System.out.println("        " + APP_VERSION);
        System.out.println("=================================================");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker(input);

        // Use checkPalindrome() method
        boolean result = checker.checkPalindrome();

        if (result) {
            System.out.println("Result: The entered string IS a Palindrome.");
        } else {
            System.out.println("Result: The entered string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

// Encapsulated Palindrome Logic
class PalindromeChecker {

    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Public method to check palindrome
    public boolean checkPalindrome() {

        // Simple stack-based implementation
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : text.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}