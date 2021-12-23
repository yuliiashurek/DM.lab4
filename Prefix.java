package com.company;

import java.util.Stack;

public class Prefix {
//          Algorithm:
//    -Reverse the given infix expression.
//    -Do Infix to postfix expression and get the result.
//    -Reverse the result to get the prefix expression.
//          for our expression:
//    -given :                                          ( ( 4 - ( 6 / 3 ) ) * ( 1 + ( 4 * 2 ) ) )
//    -reverse, switch "(" to ")" and vice verse:       ( ( ( 2 * 4 ) + 1 ) * ( ( 3 / 6 ) - 4 ) )
//    -infix to postfix :                               2 4 * 1 + 3 6 / 4 - *
//    -reverse again :                                  * - 4 / 6 3 + 1 * 4 2

    public static String prefix(String expression) {

        StringBuilder result = new StringBuilder();
        String expression1 = StringReverse.reverse(expression);
        StringBuilder input = new StringBuilder(expression1);
        Stack<Character> stack = new Stack<Character>();

        char[] inputCharArray = new String(input).toCharArray();

        for (int i = 0; i < inputCharArray.length; i++) {
            if (inputCharArray[i] == '(') {
                inputCharArray[i] = ')';
                i++;
            } else if (inputCharArray[i] == ')') {
                inputCharArray[i] = '(';
                i++;
            }
        }
        for (int i = 0; i < inputCharArray.length; i++) {
            char c = inputCharArray[i];
            //check if char is operator or operand
            if (priority(c) > 0) {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result.append(x);
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                //character is neither operator nor "("
                result.append(c);
            }
        }
        if (!stack.isEmpty()) {
            for (int i = 0; i <= stack.size(); i++) {
                result.append(stack.pop());
            }
        }
        return StringReverse.reverse(result.toString().trim().replaceAll(" +", " "));
    }

    static int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}