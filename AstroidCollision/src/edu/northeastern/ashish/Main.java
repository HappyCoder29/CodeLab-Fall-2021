package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/

public class Main {

    public static void main(String[] args) {
        int[] arr = {-2,-1,1,2};
        printArray(collisionResult(arr));
    }
    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i +  ", ");
        }
        System.out.println();
    }

    private static int[] collisionResult(int[] arr){
        if(arr == null ||arr.length == 0 ){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        for(int val : arr){
            if(val > 0){
                stack.push(val);
            }
            else{
                while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < -val){
                    stack.pop();
                }
                if(stack.size() > 0 && stack.peek() > 0 && stack.peek() == -val){
                    stack.pop();
                }else if(stack.size() > 0 && stack.peek() > 0 && stack.peek() > -val){
                    continue;
                }else{
                    stack.push(val);
                }
            }
        }
        int[] result = new int[stack.size()];
        int i = result.length - 1;
        while(i >= 0)
            result[i--] = stack.pop();
        return result;

    }
}
