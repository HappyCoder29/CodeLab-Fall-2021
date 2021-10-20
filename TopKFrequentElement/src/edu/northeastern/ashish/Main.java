package edu.northeastern.ashish;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/


public class Main {

    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,3};
        int[] result = topKFrequentElements(arr, 2);

        for (int i : result) {
            System.out.print(i + " ,");
        }
        System.out.println();

    }


    private static int[] topKFrequentElements(int[] arr, int k){
        // Hash map and add all values inside it with frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i,0) +1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(b).compareTo(map.get(a)));

        minHeap.addAll(map.keySet());

        k = Math.min(minHeap.size(), k);
        int[] result = new int[k];
        int index = 0;
        while(index < k ){
            int current = minHeap.remove();
            result[index++] = current;
        }
        return result;
    }

}
