package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        String[][] matrix = {
                {"A", "B", "C","D"},
                {"E", "F", "G","H"},
                {"I", "J", "K","L"},
                {"M", "N", "O","P"}
        };

        String[] words = {"AEI", "JKO", "EFP", "XYZ"};
        getAllMatchingWords(matrix, words);

    }

    private static void getAllMatchingWords(String[][] matrix, String[] words){
        if(words == null || words.length == 0){
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (String word : words) {
            boolean[][] visited = new boolean[rows][cols];
            for(int i = 0 ; i < rows; i ++){
                for(int j = 0 ; j < cols; j ++){
                    solveBoggle(matrix, word, 0, i,j, visited);
                }
            }
        }

    }
    private static  void solveBoggle(String[][] matrix, String word, int index, int row, int col,boolean[][] visited ){

        if(row < 0 || row > matrix.length-1  || col < 0 || col > matrix[0].length -1){
            return;
        }


        if(visited[row][col] == true){
            return;
        }
        if(index == word.length() -1 && matrix[row][col].charAt(0) == word.charAt(index)){
            System.out.println("Found Word : " + word);
            return;
        }

        if(matrix[row][col].charAt(0) != word.charAt(index)){
            return;
        }
        // We have matched the character
        visited[row][col] = true;
        // recurse for all its neighbours

        solveBoggle(matrix, word, index +1 , row -1, col, visited);
        solveBoggle(matrix, word, index +1 , row +1, col, visited);
        solveBoggle(matrix, word, index +1 , row , col -1, visited);
        solveBoggle(matrix, word, index +1 , row , col + 1, visited);
    }


}
