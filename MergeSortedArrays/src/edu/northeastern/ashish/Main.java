package edu.northeastern.ashish;
//https://leetcode.com/problems/merge-sorted-array/
/*
* Checking in code for 88. Merge Sorted Array did not add values in arr1 and assume there is enough
*  space in the end since no one writes code like this.
 * */

public class Main {

    public static void main(String[] args) {

        int[] arr1 = {1,2,3};
        int[] arr2 = {2,5,6};

        printArray(mergeSorted(arr1, arr2));


    }

    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ,");
        }
        System.out.println();
    }

    private  static int[]  mergeSorted(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int ptr1 = 0;
        int ptr2 = 0;

        for (int i = 0; i < arr1.length + arr2.length; i++) {

            if ( ptr2 >= arr2.length || (ptr1 < arr1.length && arr1[ptr1] < arr2[ptr2] ) ) {
                merged[i] =  arr1[ptr1++];
            } else {
                merged[i] = arr2[ptr2++];
            }
        }
        return merged;
    }
}
