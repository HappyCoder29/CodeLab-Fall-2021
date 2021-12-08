package edu.northeastern.ashish;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[][] matrix = {       {"E","E","E","E","E"},
                                    {"E","E","M","E","E"},
                                    {"E","E","E","E","E"},
                                    {"E","E","E","E","E"}
        };
       // MineSweep(matrix, 3, 0);

        int rows = matrix.length;
        int col = matrix[0].length;

        for(int i = 0 ; i < matrix.length; i ++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

//    private static void MineSweep(String[][] matrix, int row, int col){
//        int maxRow = matrix.length;
//        int maxCol = matrix[0].length;
//        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
//            return;
//        }
//
//        if(matrix[row][col] == "M"){
//            matrix[row][col] = "X";
//            // Update Matrix Values
//            return;
//        }
//
//        System.out.println("Row = " + row + "col = " + col);
//
//
//        MineSweep(matrix, row-1, col-1);
//        MineSweep(matrix, row-1, col);
//        MineSweep(matrix, row-1, col+1);
//        MineSweep(matrix, row, col-1);
//        MineSweep(matrix, row, col+1);
//        MineSweep(matrix, row+1, col-1);
//        MineSweep(matrix, row+1, col);
//        MineSweep(matrix, row+1, col+1);
//    }
//
//    private static void updateDigitMatrixValues(String[][] matrix, int row,int  col){
//        if()
//    }
//
//    private static void updateEmptyMatrixValues(String[][] matrix, int row,int  col){
//        if(matrix[row-1][col-1] == "E"){
//            matrix[row-1][col-1] = "1";
//        }
//        if(matrix[row-1][col] == "E"){
//            matrix[row-1][col] = "1";
//        }
//        if(matrix[row-1][col+1] == "E"){
//            matrix[row-1][col+1] = "1";
//        }
//        if(matrix[row][col-1] == "E"){
//            matrix[row][col-1] = "1";
//        }
//        if(matrix[row][col+1] == "E"){
//            matrix[row][col+1] = "1";
//        }
//        if(matrix[row+1][col-1] == "E"){
//            matrix[row+1][col-1] = "1";
//        }
//        if(matrix[row+1][col] == "E"){
//            matrix[row+1][col] = "1";
//        }
//        if(matrix[row][col+1] == "E"){
//            matrix[row][col+1] = "1";
//        }
//    }
}
