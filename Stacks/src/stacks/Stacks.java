package stacks;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Stacks {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter a bunch of code, and we'll check for balanced braces");

        String code = keyboard.nextLine();

        System.out.println("Your code has balanced braces: " + isBalanced(code));
        
        Vector<String> strings = new Vector<String>();
        
        

    }

    public static boolean isBalanced(String input) {
        Stack<Character> bracesStack = new Stack<Character>();

        for (char character : input.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                bracesStack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (bracesStack.isEmpty()) {
                    return false;
                }
                char openingBrace = bracesStack.pop();
                if ((openingBrace == '(' && character != ')')
                        || (openingBrace == '[' && character != ']')
                        || (openingBrace == '{' && character != '}')) {
                    return false;
                }
            }
        }
        return bracesStack.isEmpty();
    }

}
