package com.company;

import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 1},
                {0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1}
        };

//                Scanner input = new Scanner(System.in);
//                System.out.println("Enter");
//                int[][] matrix = new int[5][5];
//                for (int i = 0; i < matrix.length; i++) {
//                    for (int j = 0; j < matrix.length; j++) {
//                        matrix[i][j] = input.nextInt();
//                    }
//                }

        //System.out.println(twoDimToString(matrix));
        System.out.println(Symetrychnist(matrix) + "\n");

        Post post = new Post();
        Pre pre = new Pre();
        Postfix postfix = new Postfix();
        //Prefix prefix = new Prefix();
        String sl = "( ( 4 - 6 / 3 ) * ( 1 + 4 * 2 ) )";
        System.out.println("Польський запис:\n" + Prefix.prefix(sl));
        System.out.println("Результат: " + pre.counting(StringReverse.reverse(Prefix.prefix(sl))) + "\n");
        System.out.println("Зворотній польський запис:\n" + postfix.parse(sl));
        System.out.println("Результат: " + post.counting(postfix.parse(sl)) + "\n");

    }


    public static String Symetrychnist(int[][] matrix) {
        if (Symetric.symetric(matrix)) {
            return "граф може бути як неорієнтованим, так і орієнтованим";
        } else {
            return "граф орієнтований";
        }
    }

    //для вывода двухмерного массива таблицей
    public static StringBuilder twoDimToString(int[][] twoDim) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : twoDim) {
            sb.append(Arrays.toString(arr) + "\n");
        }
        return sb;
    }
}

