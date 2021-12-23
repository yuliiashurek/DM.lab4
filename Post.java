package com.company;

import java.util.Arrays;
import java.util.Stack;

class Post {
    private static final String operators = "+-*/";

    private static boolean isOperator(String token) {
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    public StringBuilder counting(String s) {
        String[] input = s.split(" ");
        int result = 0;
        Stack<Integer> temp = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {

            if (input[i].equals(" ")) continue;
            //Якщо символ - цифра, то читаємо все число и записуємо на вершину стека

            if (isNumber(input[i])) {
                temp.push(Integer.parseInt(input[i])); //Записуємо в стек
            }
            if (isOperator(input[i])) { //Якщо символ - оператор

                //Беремо два останніх значення із стеку
                int a = temp.pop();
                int b = temp.pop();

                switch (input[i]) //Проводимо над ними дії
                {
                    case "+":
                        result = b + a;
                        sb.append("\n\t" + b + " + " + a + " = " + result + "\n");
                        break;
                    case "-":
                        result = b - a;
                        sb.append("\n\t" + b + " - " + a + " = " + result + "\n");
                        break;
                    case "*":
                        result = b * a;
                        sb.append("\n\t" + b + " * " + a + " = " + result + "\n");
                        break;
                    case "/":
                        result = b / a;
                        sb.append("\n\t" + b + " / " + a + " = " + result + "\n");
                        break;
                }
                String aa = String.valueOf(a);
                String bb = String.valueOf(b);
                String res = String.valueOf(result);
                String toReplace = "";
                if (input[i].equals("*")) {
                    toReplace = bb + " " + aa + " " + "\\*";
                } else if (input[i].equals("+")) {
                    toReplace = bb + " " + aa + " " + "\\+";
                } else if (input[i].equals("-")) {
                    toReplace = bb + " " + aa + " " + "-";
                } else if (input[i].equals("/")) {
                    toReplace = bb + " " + aa + " " + "/";
                }
                String newStr = s.replaceAll(toReplace, res);
                s = newStr;
                sb.append(newStr);
                temp.push(result);
            }
        }

        return sb;
    }

    public static boolean isNumber(String word) {
        boolean found = false;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (c >= '0' && c <= '9') {
                found = true;
                break;
            }
        }
        return found;
    }
}