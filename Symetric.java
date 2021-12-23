package com.company;


public class Symetric {
    public static boolean symetric(int[][] matrix){
        boolean symmetric = true;
        int rows = matrix[0].length;
        int cols = matrix.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    symmetric = false;
                    break;
                }
            }
        }
        return symmetric;
    }
}

