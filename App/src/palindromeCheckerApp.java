import java.util.Scanner;
import java.util.Stack;

public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC5 (Stack Method)";

    public static void main(String[] args) {

        // Display Application Header
        System.out.println("==========================================");
        System.out.println("        Welcome to " + APP_NAME);
        System.out.println("        " + APP_VERSION);
        System.out.println("==========================================");

        Scanner scanner = new Scanner(System.in);

        // Accept input from user
        System.out.print("Enter a string to check if it is a palindrome: ");
        String inputString = scanner.nextLine();

        // Create Stack
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        // Check palindrome by popping and comparing
        boolean isPalindrome = true;

        for (int i = 0; i < inputString.length(); i++) {
            char poppedChar = stack.pop();
            if (inputString.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The entered string IS a Palindrome.");
        } else {
            System.out.println("Result: The entered string is NOT a Palindrome.");
        }

        scanner.close();
    }
}