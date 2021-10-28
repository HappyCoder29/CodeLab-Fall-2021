package edu.northeastern.ashish;

import java.util.HashMap;
import java.util.Stack;
//https://leetcode.com/problems/daily-temperatures/
public class Main {

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        printArray(waitTimeBeforeWarmerWeather(temperatures));
    }

    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i +  ", ");
        }
        System.out.println();
    }

    private static int[] waitTimeBeforeWarmerWeather(int[] arr){
        if(arr == null || arr.length == 0 ){
            return null;
        }

        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < arr.length; i ++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while( !stack.isEmpty() &&  arr[i] > arr[stack.peek()] ){
                    result[stack.peek()] = i - stack.pop();
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = 0;
        }
        return result;
    }
}
