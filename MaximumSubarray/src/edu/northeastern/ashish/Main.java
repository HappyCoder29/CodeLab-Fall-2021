package edu.northeastern.ashish;
//https://leetcode.com/problems/maximum-subarray/
public class Main {

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    private static int maxSubArraySum(int[] arr){
        if(arr== null || arr.length == 0){
            return Integer.MIN_VALUE;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxCurrent = arr[0];
        for(int i = 1; i < arr.length; i ++){
            if(maxCurrent + arr[i] > 0){
                maxCurrent = maxCurrent + arr[i];
            }else{
                maxCurrent = 0;
            }

            if(maxCurrent > maxSum){
                maxSum = maxCurrent;
            }
        }

        return maxSum;
    }
}
