package edu.northeastern.ashish;

import java.util.Arrays;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
public class Main {

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        replaceElementsWithGrestestElementOnRight(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void replaceElementsWithGrestestElementOnRight(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }

        int greatestElement = arr[arr.length-1];
        arr[arr.length-1] = Integer.MIN_VALUE;


        for(int i = arr.length - 2 ; i >= 0; i --){
            int temp = arr[i];
            arr[i] = greatestElement;

            if(greatestElement < temp){
                greatestElement = temp;
            }
        }

    }

}
