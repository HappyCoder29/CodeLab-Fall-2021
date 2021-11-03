package edu.northeastern.ashish;

import java.util.Arrays;
//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
public class Main {

    public static void main(String[] args) {
        int[] arr = {3,4,5,2};
        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] arr){


        if( arr == null || arr.length <=1 ){
            return Integer.MIN_VALUE;
        }
        int maxValue = arr[0]< arr[1] ? arr[1] : arr[0];
        int secondMax = arr[0]< arr[1] ? arr[0] : arr[1];

        for(int i = 2; i < arr.length; i ++){
            if(arr[i] > maxValue){
                secondMax = maxValue;
                maxValue = arr[i];
            }else if (arr[i] > secondMax){
                secondMax = arr[i];
            }
        }

        return  (maxValue -1) * (secondMax -1);
    }
}
