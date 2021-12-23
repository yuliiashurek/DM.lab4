package com.company;
import java.util.*;
import java.lang.*;
/*
       // Алгоритм перевода в обратную польскую запись:

        считываем поочерёдно все лексемы, попутно убирая пробелы;
        если лексема — это число или переменная, то добавляем её в результирующий список;
        если лексема — это функция, то добавляем её в стэк;
        если лексема — это открывающая скобка, то добавляем её в стэк;
        если лексема — это закрывающая скобка, то:
        помещаем элементы из стэка в результирующую строку пока не встретим открывающую скобку, притом открывающая скобка удаляется из стэка, но в результирующую строку не добавляется;
        если на вершине стэка оказывается символ функции, то мы помещаем его из стэка в результирующую строку;
        если открывающая скока не была встречена, то скобки не согласованы.
        если лексема — это оператор, то:
        если это последний символ выражения, то выражение некорректно;
        если это унарный минус, то добавляем его в стэк;
        иначе:
        выталкиваем верхние элементы стэка в результирующую строку, пока приоритет текущего оператора меньше либо равен приоритету оператора, находящегося на верине стэка;
        помещаем текущий оператор в стэк;
        когда все данные считаны, выталкиваем все элементы стэка в результирующую строку; если в стэке оказались символы не операторов, то скобки не согласованы.

       // Алгоритм вычисления значения выражения в обратной польской нотации:

        если в записи встретили число, то кладём его в стэк;
        если в записи встретили функцию или унарный минус, то :
        вытаскиваем из стэка верхний элемент;
        применяем функцию к нему;
        кладём элемент обратно в стэк;
        если в записи встретили бинарный оператор, то:
        вытаскиваем из стэка два верхних элемента;
        выполняем над ними операцию;
        кладём в стэк результат выполнения операции;
        выводим последний элемент стэка.
*/
class Postfix {
    private static final String operators = "+-*/";
    private static final String delimiters = "() " + operators;

    private static boolean isDelimiter(String token) {
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    private static int priority(String token) {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    public String parse(String input) {
        String[] s = input.split(" ");
        StringBuilder output = new StringBuilder(); //Строка для результату
        Stack<String> stack = new Stack<>(); //Стек для зберігання операторів

        for (String value : s) {

            if (value.equals(" ")) continue;
            else if (isDelimiter(value)) {
                if (value.equals("(")) stack.push(value);
                else if (value.equals(")")) {
                    while (stack.size() > 0 && !stack.peek().equals("(")) {
                        output.append(stack.pop()).append(" ");
                    }
                    stack.pop();

                } else {

                    while (stack.size() > 0 && (priority(value) <= priority(stack.peek()))) {
                        output.append(stack.pop()).append(" ");
                    }
                    stack.push(value);
                }

            } else {
                output.append(value).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) output.append(stack.pop()).append(" ");
        }
        return output.toString();
    }
}