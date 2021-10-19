package edu.northeastern.ashish;

import java.util.ArrayList;

// https://leetcode.com/problems/summary-ranges/
public class Main {

    public static void main(String[] args) {
        ArrayList<String> ranges = summaryRanges(new int[]{0,1,2,4,5,7});
        for (String str : ranges) {
            System.out.println(str);
        }
    }

    public static ArrayList<String> summaryRanges(int[] arr) {

        if(arr == null || arr.length == 0){
            return null;
        }

        ArrayList<String> list = new ArrayList<>();
        int rangeStart = 0;
        int lastNumber = arr[0];
        for(int i = 1 ; i < arr.length; i ++){
            if(lastNumber + 1 != arr[i]){
                if(rangeStart == i-1){
                    list.add(String.valueOf(lastNumber));
                }else{
                    list.add(arr[rangeStart] + " -> " + lastNumber );
                }
                rangeStart = i;
            }
            lastNumber = arr[i];
        }

        if(rangeStart == arr.length -1){
            list.add(String.valueOf(lastNumber));
        }else{
            list.add(arr[rangeStart] + " -> " + lastNumber );
        }

        return list;
    }
}
