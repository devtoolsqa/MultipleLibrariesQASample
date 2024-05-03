package com.example.kotlinpracticeudemy.problems;

public class RotateMatrixInplace {
    public static void main(String[] args) {
        int[][] input = new int[4][4];
        input[0][0] = 1;
        input[0][1] = 2;
        input[0][2] = 3;
        input[0][3] = 4;

        input[1][0] = 5;
        input[1][1] = 6;
        input[1][2] = 7;
        input[1][3] = 8;

        input[2][0] = 9;
        input[2][1] = 10;
        input[2][2] = 11;
        input[2][3] = 12;

        input[3][0] = 13;
        input[3][1] = 14;
        input[3][2] = 15;
        input[3][3] = 16;

        System.out.println("----printing input----");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + "  ");
            }
            System.out.println();

        }

        int[][] result = getRotateMatrix(input);
        System.out.println("----printing result----");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();

        }
    }

    public static int[][] getRotateMatrix(int[][] matrix) {

        int[][] result = new int[matrix.length][matrix.length];
        int l = result.length;

        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[0][i];
            matrix[0][i] = matrix[(l - 1) - i][0];
            matrix[(l - 1) - i][0] = matrix[l - 1][(l - 1) - i];
            matrix[l - 1][(l - 1) - i] = matrix[i][l - 1];
            matrix[i][l - 1] = temp;

        }

        return result;

    }
}
