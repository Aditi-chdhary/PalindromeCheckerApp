import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC7 (Deque Optimized Method)";

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

        // Create Deque (Double Ended Queue)
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (int i = 0; i < inputString.length(); i++) {
            deque.addLast(inputString.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear characters
        while (deque.size() > 1) {

            char frontChar = deque.removeFirst();  // Remove from front
            char rearChar = deque.removeLast();    // Remove from rear

            if (frontChar != rearChar) {
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