package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1,2,11};
        int[] arr2 = {2,5,6};
        ArrayList<int[]> list = getKPairsWithSmallestSum(arr1, arr2, 4);
        for (int[] arr: list) {
            System.out.println("[ " + arr[0] + ", " +arr[1] + " ]");
        }
    }


    public static ArrayList<int[]> getKPairsWithSmallestSum(int[] arr1, int[] arr2, int k){
        ArrayList<int[]> list = new ArrayList<>();
        if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return list;
        }
        int ptr1 = 0;
        int ptr2 = 0;
        int current1 = 0;
        int current2 = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while(ptr1 < arr1.length && ptr2 < arr2.length){
            list.add( new int[]{arr1[current1], arr2[current2]} );
            if(arr1[current1] + arr2[current2 ] < arr1[ptr1]+ arr2[ptr2])
            if(arr1[current1] < arr2[current2]){
                current2++;
            }
            else{
                current1++;
            }
            if(current1 >= arr1.length){
                ptr2++;
                current2= ptr2;
                current1 = ptr1;
            }
            if(current2 >= arr2.length){
                ptr1++;
                current1 = ptr1;
                current2 = ptr2;
            }
            if(k == list.size()){
                break;
            }
        }

        return list;
    }
}
