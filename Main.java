/*
Description: Checks if delimiters are properly matched using a stack.

Programmed by: Junyl Mark Cortez, BSIT, 48143, CC104
Last Modified: October 20, 2026
Version: 1.0

*/
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static boolean isOpening(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isClosing(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public static boolean checkDelimiters(String input) {
        Stack<Character> stack = new Stack<>();

        System.out.println("\nSTACK EXECUTION TRACE");

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (isOpening(ch)) {
                stack.push(ch);

                System.out.println("\nRead: " + ch);
                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);
            }

            else if (isClosing(ch)) {
                System.out.println("\nRead: " + ch);

                if (stack.isEmpty()) {
                    System.out.println("Operation: INVALID");
                    System.out.println(
                        "Reason: No matching opening delimiter."
                    );
                    System.out.println("Stack: " + stack);
                    return false;
                }

                char top = stack.peek();
                System.out.println("Operation: PEEK " + top);

                if (isMatching(top, ch)) {
                    stack.pop();

                    System.out.println("Operation: POP " + top);
                    System.out.println("Stack: " + stack);
                } else {
                    System.out.println("Operation: INVALID");
                    System.out.println(
                        "Reason: Mismatched delimiters."
                    );
                    System.out.println("Stack: " + stack);
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("\nOperation: INVALID");
            System.out.println(
                "Reason: Unmatched opening delimiter remains."
            );
            System.out.println("Stack: " + stack);
            return false;
        }

        System.out.println("\nAll delimiters are matched.");
        System.out.println("Final stack: " + stack);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("MATCHING DELIMITERS CHECKER");
        System.out.print("Enter a sequence: ");

        String input = sc.nextLine();

        boolean valid = checkDelimiters(input);

        System.out.println("\nRESULT: " +
                (valid ? "Valid" : "Invalid"));

        sc.close();
    }
}
