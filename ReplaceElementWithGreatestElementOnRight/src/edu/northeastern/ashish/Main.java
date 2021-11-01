package edu.northeastern.ashish;

import java.util.Arrays;
//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
public class Main {

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        replaceElementsGreatest(arr);

        System.out.println(Arrays.toString(arr) );

    }


    private static void replaceElementsGreatest(int[] arr){
        int maxElement = -1;

        for(int i = arr.length-1 ; i >= 0 ; i --){
            int temp = arr[i];
            arr[i] = maxElement;
            if(temp > maxElement){
                maxElement = temp;
            }
        }
    }


}
