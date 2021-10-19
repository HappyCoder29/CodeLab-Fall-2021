package edu.northeastern.ashish;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicatesSortedArray(arr);
        printArray(arr);
    }

    private static int removeDuplicatesSortedArray(int[] arr){
        if (arr.length <= 1)
            return arr.length ;

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }

    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
