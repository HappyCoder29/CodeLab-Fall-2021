package edu.northeastern.ashish;
//https://leetcode.com/problems/spiral-matrix/
public class Main {

    enum Direction {
        left,
        right,
        down,
        up
    }
    public static void main(String[] args) {

        int[][] matrix = {  {1,2,3,4 },
                {12,13,14,5 },
                {11,16,15,6},
                {10,9,8,7 }
        };
        printSpiral(matrix);
    }

    public static void printSpiral(int[][] arr)
    {
        int N_ROWS =  arr.length;
        int N_COLS = arr[0].length;
        Direction direction = Direction.right;
        int up_limit = 0;
        int down_limit = N_ROWS - 1;
        int left_limit = 0;
        int right_limit = N_COLS - 1;
        int Count = N_ROWS * N_COLS;
        int row = 0;
        int col = 0;

        while (Count > 0)
        {
            System.out.println(arr[row][col]);

            if (direction == Direction.right)
            {
                col++;
                if (col > right_limit)
                {
                    col--;
                    direction = Direction.down;
                    up_limit++;
                    row++;
                }
            }
            else if (direction == Direction.down)
            {
                row++;
                if (row > down_limit)
                {
                    row--;
                    direction = Direction.left;
                    right_limit--;
                    col--;
                }
            }
            else if (direction == Direction.left)
            {
                col = col - 1;
                if (col < left_limit)
                {
                    ++col;
                    direction = Direction.up;
                    --down_limit;
                    --row;
                }
            }
            else if (direction == Direction.up) /* direction == up */
            {
                row = row - 1;
                if (row < up_limit)
                {
                    ++row;
                    direction = Direction.right;
                    ++left_limit;
                    ++col;
                }
            }
            Count--;
        }
    }
}
