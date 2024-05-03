package com.example.kotlinpracticeudemy.problems;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] input = new int[4][4];
        input[0][0]=1;
        input[0][1]=2;
        input[0][2]=3;
        input[0][3]=4;

        input[1][0]=5;
        input[1][1]=6;
        input[1][2]=7;
        input[1][3]=8;

        input[2][0]=9;
        input[2][1]=10;
        input[2][2]=11;
        input[2][3]=12;

        input[3][0]=13;
        input[3][1]=14;
        input[3][2]=15;
        input[3][3]=16;

        System.out.println("----printing input----");
        for (int[] ints : input) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();

        }

        int[][] result=getRotateMatrix(input);
        System.out.println("----printing result----");
        for (int[] ints : result) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();

        }
    }

    public static int[][] getRotateMatrix(int[][] matrix) {

        int[][] result = new int[matrix.length][matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j=0;j<matrix.length;j++) {
                result[j][i]=matrix[(matrix.length-1)-i][j];

            }

        }

        return result;

    }
}
