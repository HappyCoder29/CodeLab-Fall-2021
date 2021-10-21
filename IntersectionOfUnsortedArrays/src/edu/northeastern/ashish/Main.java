package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/solution/
public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        int[] arr = findIntersectionWithSorting(arr1, arr2);
        System.out.println();

    }

    private static int[] findIntersectionWithHashMap(int[] arr1, int[] arr2){
        if(arr1 == null || arr2 == null){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer i : arr2) {
            if(map.containsKey(i)){
                list.add(i);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public  static int[] findIntersectionWithSorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                list.add(nums1[i]);
                i++;
                j ++;
            }
        }
        return  list.stream().mapToInt(k->k).toArray();
    }
}
