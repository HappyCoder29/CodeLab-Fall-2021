package edu.northeastern.ashish;

public class Main {

    static enum Direction{left, right, up , down};
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1,1,1,0,1,1},
                {1,1,1,1,1,0,1,1},
                {1,0,1,1,1,1,1,1},
                {0,0,0,1,0,0,0,0},
                {1,1,1,1,1,1,1,1}
        };
        // 1 == Not painted
        // 2 == painted
        // 0 == Blocked cell
        int rows = matrix.length;
        int cols = matrix[0].length;
        Direction dir = Direction.up;

        int count = 0;
        for(int i = 0 ; i < rows; i ++){
            for(int j = 0 ; j < cols; j ++){
                if(matrix[i][j] == 1){
                    count ++;
                }
            }
        }
        BoxValue<Integer> count = new BoxValue(0);

    }

    private static void colorMatrix(int[][] matrix, int count, BoxValue<Integer> box, int row, int col, Direction dir){
        if(count == box.value){
            System.out.println("All the boxes are painted");
            return;
        }
        if( canMove(row, col, matrix, dir)){
            colorMatrix(matrix, count, box, row -1, col, dir);
        }






    }


    private static boolean canMove(int row, int col, int[][] matrix, Direction dir ){
        if(dir ==  Direction.up  ){
            if(row == 0 && matrix[row-1][col]){
                return false;
            }
        }else  if(dir ==  Direction.down  ){
            if(row == matrix.length -1){
                return false;
            }
        }else  if(dir ==  Direction.left  ){
            if(col == 0){
                return false;
            }
        }else{
            if(col == matrix[0].length){
                return false;
            }
        }

        return true;


    }






}
