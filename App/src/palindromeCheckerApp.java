import java.util.Scanner;

public class palindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "Version 1.0 - UC3 (String Reverse Method)";

    public static void main(String[] args) {

        // Display Application Header
        System.out.println("====================================");
        System.out.println("      Welcome to " + APP_NAME);
        System.out.println("      " + APP_VERSION);
        System.out.println("====================================");

        // Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String originalString = scanner.nextLine();

        // Reverse the string using for loop
        String reversedString = "";

        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i);
        }

        // Display reversed string
        System.out.println("Reversed String: " + reversedString);

        // Compare original and reversed string
        if (originalString.equals(reversedString)) {
            System.out.println("Result: The entered string IS a Palindrome.");
        } else {
            System.out.println("Result: The entered string is NOT a Palindrome.");
        }

        scanner.close();
    }
}