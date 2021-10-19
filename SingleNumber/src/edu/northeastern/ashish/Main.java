package edu.northeastern.ashish;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }

    private static int singleNumber(int[] arr){
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : arr) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
