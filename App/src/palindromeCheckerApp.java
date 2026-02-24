import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class palindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("        Palindrome Checker App - Performance Comparison");
        System.out.println("=================================================");

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println("\nRunning multiple palindrome algorithms...");

        // UC3: String Reverse
        long start = System.nanoTime();
        boolean resultUC3 = stringReverseCheck(input);
        long end = System.nanoTime();
        System.out.println("UC3 - String Reverse: Result=" + resultUC3 + ", Time=" + (end - start) + " ns");

        // UC5: Stack-based
        start = System.nanoTime();
        boolean resultUC5 = stackCheck(input);
        end = System.nanoTime();
        System.out.println("UC5 - Stack-based: Result=" + resultUC5 + ", Time=" + (end - start) + " ns");

        // UC6: Queue+Stack
        start = System.nanoTime();
        boolean resultUC6 = queueStackCheck(input);
        end = System.nanoTime();
        System.out.println("UC6 - Queue+Stack: Result=" + resultUC6 + ", Time=" + (end - start) + " ns");

        // UC7: Deque-based
        start = System.nanoTime();
        boolean resultUC7 = dequeCheck(input);
        end = System.nanoTime();
        System.out.println("UC7 - Deque-based: Result=" + resultUC7 + ", Time=" + (end - start) + " ns");

        // UC9: Recursive
        start = System.nanoTime();
        boolean resultUC9 = recursiveCheck(input, 0, input.length() - 1);
        end = System.nanoTime();
        System.out.println("UC9 - Recursive: Result=" + resultUC9 + ", Time=" + (end - start) + " ns");

        scanner.close();
    }

    // UC3: String Reverse
    private static boolean stringReverseCheck(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return text.equals(reversed);
    }

    // UC5: Stack-based
    private static boolean stackCheck(String text) {
        Stack<Character> stack = new Stack<>();
        for (char ch : text.toCharArray()) stack.push(ch);
        for (char ch : text.toCharArray()) if (stack.pop() != ch) return false;
        return true;
    }

    // UC6: Queue+Stack
    private static boolean queueStackCheck(String text) {
        Stack<Character> stack = new Stack<>();
        java.util.Queue<Character> queue = new LinkedList<>();
        for (char ch : text.toCharArray()) {
            stack.push(ch);
            queue.add(ch);
        }
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) return false;
        }
        return true;
    }

    // UC7: Deque-based
    private static boolean dequeCheck(String text) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : text.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // UC9: Recursive
    private static boolean recursiveCheck(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return recursiveCheck(text, start + 1, end - 1);
    }
}