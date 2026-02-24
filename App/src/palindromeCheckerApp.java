import java.util.Scanner;

public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC4 (Character Array Method)";

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

        // Convert string to character array
        char[] charArray = inputString.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = charArray.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
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