package edu.northeastern.ashish;

//https://leetcode.com/problems/increasing-triplet-subsequence/
public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] result = increasingTriplet(arr);
        if(result != null){
            System.out.println("Increasing triplet = [" + result[0] + ", " + result[1] + ", " + result[2] + "]");
        }
    }

    public static int[]  increasingTriplet(int[] arr) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n: arr) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return new int[]{first_num, second_num, n};
            }
        }
        return null;
    }
}
