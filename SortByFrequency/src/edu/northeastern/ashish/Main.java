package edu.northeastern.ashish;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// Leet code : 1636. Sort Array by Increasing Frequency
// Leet code https://leetcode.com/problems/sort-array-by-increasing-frequency/
public class Main {

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,2,3};

        int[] sorted = frequencySort(arr);

        printArray(sorted);

    }

    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private static int[] frequencySort(int[] arr){
        // Hash map and add all values inside it with frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a).compareTo(map.get(b));
            }
        });

        minHeap.addAll(map.keySet());
        int[] result = new int[arr.length];
        int index = 0;
        while(! minHeap.isEmpty()){
            int current = minHeap.remove();
            for(int i = 0; i < map.get(current); i++) {
                result[index] = current;
                index++;
            }
        }
        return result;




    }
}
