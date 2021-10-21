package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1,3,4,2,2};

        System.out.println(findDuplicate(arr));

    }

    private static int findDuplicate(int[] arr){

        if(arr == null || arr.length <=1){
            return Integer.MIN_VALUE;
        }

        int slow = arr[0];
        int fast = arr[arr[0]];

        while( slow != fast ){
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        System.out.println(arr[arr[fast]]);

        return arr[fast];
    }

}
