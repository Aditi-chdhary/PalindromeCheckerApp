import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC6 (Queue + Stack Method)";

    public static void main(String[] args) {

        // Display Application Header
        System.out.println("=================================================");
        System.out.println("        Welcome to " + APP_NAME);
        System.out.println("        " + APP_VERSION);
        System.out.println("=================================================");

        Scanner scanner = new Scanner(System.in);

        // Accept user input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String inputString = scanner.nextLine();

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both data structures
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);       // FIFO (Enqueue)
        }

        boolean isPalindrome = true;

        // Compare dequeue (queue) with pop (stack)
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();  // Dequeue
            char fromStack = stack.pop();     // Pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Display Result
        if (isPalindrome) {
            System.out.println("Result: The entered string IS a Palindrome.");
        } else {
            System.out.println("Result: The entered string is NOT a Palindrome.");
        }

        scanner.close();
    }
}