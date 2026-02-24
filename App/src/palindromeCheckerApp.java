import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Main Application
public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC12 (Strategy Pattern)";

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("        Welcome to " + APP_NAME);
        System.out.println("        " + APP_VERSION);
        System.out.println("=================================================");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        System.out.println("\nSelect strategy:");
        System.out.println("1. Stack-based");
        System.out.println("2. Deque-based");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeStrategy strategy;

        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                System.out.println("Invalid choice. Using Stack-based as default.");
                strategy = new StackStrategy();
        }

        boolean result = strategy.isPalindrome(input);

        if (result) {
            System.out.println("Result: The entered string IS a Palindrome.");
        } else {
            System.out.println("Result: The entered string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack-based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
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

// Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}