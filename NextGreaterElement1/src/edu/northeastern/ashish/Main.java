package edu.northeastern.ashish;

import java.util.HashMap;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/
public class Main {

    public static void main(String[] args) {

        int[] arr1 = {4,1,2};
        int [] arr2 = {1,3,4,2};
        printArray(nextGreaterElementTwoArrays(arr1, arr2));
        System.out.println();
    }

    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i +  ", ");
        }
        System.out.println();
    }

    private static int[] nextGreaterElementTwoArrays(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map = getNextGreaterElementNoDuplicates(arr2);

        int[] result = new int[arr1.length];
        for(int i = 0; i < arr1.length; i ++){
            result[i] = map.getOrDefault(arr1[i], Integer.MIN_VALUE);
        }
        return result;

    }

    private static HashMap<Integer, Integer> getNextGreaterElementNoDuplicates(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        if(arr == null || arr.length == 0 ){
            return map;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i ++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                while( !stack.isEmpty() &&  arr[i] > stack.peek() ){
                    map.put(stack.pop(), arr[i]);
                }
                stack.push(arr[i]);
            }
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        return map;
    }
}
