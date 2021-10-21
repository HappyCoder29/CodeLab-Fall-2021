package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Stack;
//https://leetcode.com/problems/buildings-with-an-ocean-view/
public class Main {

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        Integer[] list = findBuildingsWithOceanView(arr);
        for (Integer i : list) {
            System.out.print(i + ", ");
        }

        System.out.println();
    }

    private static Integer[]  findBuildingsWithOceanView(int[] arr){

        ArrayList<Integer> list =  new ArrayList<>();
        if(arr == null || arr.length == 0){
            return null;
        }

        //Create a stack which will keep traclk of all the bui8ldings on the right
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length -1; i >= 0; i --){

            // Keep popping till the stack is empty(no building to right is bigger) or you found a building in
            // right which is bigger
            while( !stack.isEmpty()  && arr[i] > stack.peek()){
                stack.pop();
            }

            // If stack is empty there is no building to right which is bigger add this building index
            if(stack.isEmpty()){
                list.add(i);
            }
            // Add the height of current building
            stack.push(arr[i]);
        }

        // return the result in reverse order
        Integer[] result = new Integer[list.size()];
        for(int i = list.size() -1 ; i >= 0; i  --){
            result[i] = list.remove(0);
        }

        return result;

    }
}
