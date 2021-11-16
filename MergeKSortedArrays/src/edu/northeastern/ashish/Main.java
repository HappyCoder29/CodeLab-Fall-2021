package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
//https://leetcode.com/problems/merge-k-sorted-lists/solution/
public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1,5,7,9,13};
        int[] arr2 = {-12, 2,5, 8};
        int[] arr3 = {45,65,78};
        int[] arr4 = {99,210,800, 964,1234};
        int[] arr5 = {-23,-12,3,10};
        ArrayList<int[]> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);

        int[] merged = mergeKSortedArrays(list);
        System.out.println(Arrays.toString(merged));
    }

    // O(k * n* log(K*n)
    private static int[] mergeKSortedArrays(ArrayList<int[]> listOfArrays){
        int countMergedArray = 0;

        //O(k)
        for (int[] arr: listOfArrays) {
            countMergedArray += arr.length;
        }

        int[] merged = new int[countMergedArray];

        // O(k * n* log(K*n)
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
       // MinHeap queue = new MinHeap();
        for (int[] arr: listOfArrays) {
            for (int i : arr) {
                queue.add(i);
            }
        }
        // My priority queue has all the integers inside the queue

        // O( K * n*  log(k*n) )
        for(int i = 0 ; i < merged.length ; i++){
            merged[i] = queue.remove();
        }

        return  merged;
    }
}
