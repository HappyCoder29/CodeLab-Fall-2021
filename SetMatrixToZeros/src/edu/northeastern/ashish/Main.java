package edu.northeastern.ashish;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/set-matrix-zeroes/

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {  {0,1,2,0},
                            {3,4,5,2},
                            {1,3,1,5}};

        setMatrixToZeros(matrix);
        printMatrix(matrix);

    }

    private static void setMatrixToZeros(int[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;

        HashSet<Integer> rowZeroIndex = new HashSet<>();
        HashSet<Integer> colZeroIndex = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowZeroIndex.add(i);
                    colZeroIndex.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (rowZeroIndex.contains(i) || colZeroIndex.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }// end of function setMatrixToZeros


    private static void printMatrix(int[][] matrix){
        int rows = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " , ");
            }
            System.out.println();
        }
    }
}
